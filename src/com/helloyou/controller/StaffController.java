package com.helloyou.controller;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.helloyou.model.Department;
import com.helloyou.model.FileMeta;
import com.helloyou.model.Staff;
import com.helloyou.model.StaffLevel;
import com.helloyou.model.Syslog;
import com.helloyou.service.DepartmentService;
import com.helloyou.service.StaffLevelService;
import com.helloyou.service.StaffService;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Constants;
import com.helloyou.util.Paginator;
import com.helloyou.util.PaginatorImpl;
import com.helloyou.vo.DataTableVO;

@Controller
public class StaffController {
	@Autowired
	private StaffService staffService;
	@Autowired
	private StaffLevelService staffLevelService;
	@Autowired
	private DepartmentService departmentService;
	@Autowired
	private SyslogService syslogService;
	
	@RequestMapping(value="/staff_list", method = RequestMethod.POST)
	public @ResponseBody 
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session){
		int page=vo.getiDisplayStart()/vo.getiDisplayLength()+1;
		Paginator paginator = new PaginatorImpl(page, vo.getiDisplayLength());
		List<Staff> staffs = staffService.getAll(paginator, vo.getiSortCol_0(), vo.getsSortDir_0(), vo.getsSearch());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("iTotalRecords", paginator.getTotal());
		result.put("iTotalDisplayRecords", paginator.getTotal());
		result.put("aaData", staffs);
		result.put("sEcho", vo.getsEcho());
		
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		syslogService.create(Syslog.GREEN, curStaff, "[POST] staff_list");
		return result;
	}
	
	@RequestMapping(value="/staff_list", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("staff_list", "active");
		model.addAttribute("main_nav", "用户管理");
		model.addAttribute("sub_nav", "用户列表");
		
		model.addAttribute("ajax_url", "staff_list");
		model.addAttribute("edit_url", "staff_update");
		model.addAttribute("delete_url", "staff_delete");
		
		String[] columns_key={"id","username","sex","department.name","level.name","time"};
		String[] columns_value={"编号","姓名","性别","部门","等级","注册时间"};
		model.addAttribute("columns_key", columns_key);
		model.addAttribute("columns_value", columns_value);
		
		return "common_list";
	}
	
	@RequestMapping(value="/staff_delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(
			@RequestParam(value="id") Long id, HttpSession session){
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		
		Map<String,String> resp=new HashMap<String, String>();
		resp.put("message", "删除记录失败！");
		if(id.equals(curStaff.getId())){
			resp.put("message", "无法删除用户自己！");
		}else if(id!=null){
			try{
				staffService.delete(id);
				syslogService.create(Syslog.RED, curStaff, "[POST] staff_delete id="+id);
				resp.put("message", "记录删除成功！");
			}catch(Exception ex){
				resp.put("message", "删除记录失败！");
			}
		}
		return resp;
	}
	
	@RequestMapping(value = "/user_profile", method = RequestMethod.GET)
	public String user_profile(Model model) {
		model.addAttribute("user_profile", "active");
		return "user_profile";
	}
	
	@RequestMapping(value = "/staff_new", method = RequestMethod.GET)
	public String initForm(Model model, HttpSession session) {
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		List<StaffLevel> levels=new ArrayList<StaffLevel>();
		for(StaffLevel level:staffLevelService.getAll()){
			if(level.getId()<curStaff.getLevel().getId()){
				levels.add(level);
			}
		}
		List<Department> departments=null;
		if(curStaff.getLevel().getId()==3){
			departments=departmentService.getAll();
		}else{
			departments=new ArrayList<Department>();
			departments.add(curStaff.getDepartment());
		}
		
		model.addAttribute("staff_new", "active");
		model.addAttribute("departments", departments);
		model.addAttribute("levels", levels);
		model.addAttribute("staff", new Staff());
		model.addAttribute("cur_department", 1);
		model.addAttribute("cur_level", 1);
		
		return "staff_form";
	}
	
	@RequestMapping(value = "/staff_new", method = RequestMethod.POST)
	public String processForm(@ModelAttribute Staff staff, Model model, HttpSession session) {
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		
		Boolean isNew=staff.isNew();
		staffService.saveOrUpdate(staff);
		
		if(isNew){
			syslogService.create(Syslog.YELLOW, curStaff, "[POST] staff_new id=" + staff.getId());
		}else{
			syslogService.create(Syslog.YELLOW, curStaff, "[POST] staff_update id=" + staff.getId());
		}
		
		if(staff.getId().equals(curStaff.getId())){
			session.setAttribute(Constants.USER_INFO_SESSION, staffService.get(staff.getId()));
		}
		
		return "redirect:/staff_update?id=" + staff.getId();
	}
	
	@RequestMapping(value = "/staff_update", method = RequestMethod.GET)
	public String update(@RequestParam(value="id") Long id,
			Model model, HttpSession session) {
		
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		
		List<StaffLevel> levels=new ArrayList<StaffLevel>();
		for(StaffLevel level:staffLevelService.getAll()){
			if(level.getId()<=curStaff.getLevel().getId()){
				levels.add(level);
			}
		}
		List<Department> departments=null;
		if(curStaff.getLevel().getId()==3){
			departments=departmentService.getAll();
		}else{
			departments=new ArrayList<Department>();
			departments.add(curStaff.getDepartment());
		}
		
		Staff staff=staffService.get(id);
		
		model.addAttribute("staff_new", "active");
		model.addAttribute("departments", departments);
		model.addAttribute("levels", levels);
		model.addAttribute("staff", staff);
		model.addAttribute("cur_department", staff.getDepartment().getId());
		model.addAttribute("cur_level", staff.getLevel().getId());
		
		return "staff_form";
	}
	
	@RequestMapping(value="/avatar_upload", method = RequestMethod.POST)
	public @ResponseBody LinkedList<FileMeta> upload(MultipartHttpServletRequest request, HttpServletResponse response) {
		//1. build an iterator
		Iterator<String> itr = request.getFileNames();
		MultipartFile mpf = null;
		LinkedList<FileMeta> files = new LinkedList<FileMeta>();
		//2. get each file
		while(itr.hasNext()){
			//2.1 get next MultipartFile
			mpf = request.getFile(itr.next());
			try {
				//2.2 create new fileMeta
				FileMeta fileMeta = new FileMeta();
				fileMeta.setFileSize(mpf.getSize()/1024+" Kb");
				fileMeta.setFileType(mpf.getContentType());
				fileMeta.setBytes(mpf.getBytes());
				// copy file to local disk
				String ext = mpf.getOriginalFilename().substring(mpf.getOriginalFilename().lastIndexOf("."));
				String realName=UUID.randomUUID().toString() + ext;
				String path = request.getServletContext().getRealPath("temp/");
				fileMeta.setFileName(realName);
				FileCopyUtils.copy(mpf.getBytes(), new FileOutputStream(path + "/" + realName));
				
				files.add(fileMeta);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		// result will be like this
		// [{"fileName":"app_engine-85x77.png","fileSize":"8 Kb","fileType":"image/png"},...]
		return files;
	}
	
	@RequestMapping(value="/crop_image",method=RequestMethod.GET)
	public void crop_image(
			@RequestParam("src") String src,
			@RequestParam("x") double x,
			@RequestParam("y") double y,
			@RequestParam("w") double w,
			@RequestParam("h") double h,
			@RequestParam("sw") double sw,
			@RequestParam("sh") double sh,
			HttpServletResponse response,
			HttpSession session){
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		String path = session.getServletContext().getRealPath("temp/"+src);
		String realPath=session.getServletContext().getRealPath("uploads/")+"/"+curStaff.getId()+".jpg";
		
		try {
			BufferedImage image=ImageIO.read(new File(path));
			int x0=(int)(x*image.getWidth()/sw);
			int y0=(int)(y*image.getHeight()/sh);
			int w0=(int)(w*image.getWidth()/sw);
			int h0=(int)(h*image.getHeight()/sh);
			
			BufferedImage out=image.getSubimage(x0, y0, w0, h0);
			ImageIO.write(out, "jpg", new File(realPath));
			response.setContentType("image/jpeg");
			response.setHeader("Content-disposition", "attachment; filename=\""+curStaff.getId()+".jpg\"");
			ImageIO.write(out, "jpg", response.getOutputStream());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
