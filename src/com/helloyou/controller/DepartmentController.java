package com.helloyou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloyou.model.Department;
import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.service.DepartmentService;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Constants;
import com.helloyou.util.Paginator;
import com.helloyou.util.PaginatorImpl;
import com.helloyou.vo.DataTableVO;

@Controller
public class DepartmentController {
	@Autowired
	private DepartmentService deptService;
	@Autowired
	private SyslogService syslogService;
	
	@RequestMapping(value="/dept_list", method = RequestMethod.POST)
	public @ResponseBody 
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session){
		int page=vo.getiDisplayStart()/vo.getiDisplayLength()+1;
		Paginator paginator = new PaginatorImpl(page, vo.getiDisplayLength());
		List<Department> depts = deptService.getAll(paginator, vo.getiSortCol_0(), vo.getsSortDir_0(), vo.getsSearch());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("iTotalRecords", paginator.getTotal());
		result.put("iTotalDisplayRecords", paginator.getTotal());
		result.put("aaData", depts);
		result.put("sEcho", vo.getsEcho());
		
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		syslogService.create(Syslog.GREEN, curStaff, "[POST] dept_list");
		return result;
	}
	
	@RequestMapping(value="/dept_list", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("dept_list", "active");
		model.addAttribute("main_nav", "部门管理");
		model.addAttribute("sub_nav", "部门列表");
		
		model.addAttribute("ajax_url", "dept_list");
		model.addAttribute("edit_url", "dept_edit");
		model.addAttribute("delete_url", "dept_delete");
		
		String[] columns_key={"id", "name","time"};
		String[] columns_value={"编号","部门名称","添加时间"};
		model.addAttribute("columns_key", columns_key);
		model.addAttribute("columns_value", columns_value);
		
		return "common_list";
	}
	
	@RequestMapping(value="/dept_delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(
			@RequestParam(value="id") Long id, HttpSession session){
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		
		Map<String,String> resp=new HashMap<String, String>();
		try{
			deptService.delete(id);
			syslogService.create(Syslog.RED, curStaff, "[POST] dept_delete id="+id);
			resp.put("message", "记录删除成功！");
		}catch(Exception ex){
			resp.put("message", "当前部门包含职工，删除记录失败！");
		}
		return resp;
	}

}
