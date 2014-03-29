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

import com.helloyou.model.Goods;
import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.service.GoodsService;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Constants;
import com.helloyou.util.Paginator;
import com.helloyou.util.PaginatorImpl;
import com.helloyou.vo.DataTableVO;

@Controller
public class GoodsController {
	
	@Autowired
	private GoodsService goodsService;
	@Autowired
	private SyslogService syslogService;
	
	
	@RequestMapping(value="/goods_list", method = RequestMethod.POST)
	public @ResponseBody 
	Map<String, Object> list(@ModelAttribute DataTableVO vo, HttpSession session){
		int page=vo.getiDisplayStart()/vo.getiDisplayLength()+1;
		Paginator paginator = new PaginatorImpl(page, vo.getiDisplayLength());
		List<Goods> goods = goodsService.getAll(paginator, vo.getiSortCol_0(), vo.getsSortDir_0(), vo.getsSearch());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("iTotalRecords", paginator.getTotal());
		result.put("iTotalDisplayRecords", paginator.getTotal());
		result.put("aaData", goods);
		result.put("sEcho", vo.getsEcho());
		
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		syslogService.create(Syslog.GREEN, curStaff, "[POST] goods_list");
		return result;
	}
	@RequestMapping(value="/goods_list", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("goods_list", "active");
		model.addAttribute("main_nav", "入库管理");
		model.addAttribute("sub_nav", "入库列表");
		
		model.addAttribute("ajax_url", "goods_list");
		model.addAttribute("edit_url", "goods_edit");
		model.addAttribute("delete_url", "goods_delete");
		
		String[] columns_key={"id", "name", "type.name", "staff.username", "number", "time"};
		String[] columns_value={"编号","器械名称","器械类型","入库人","数量","入库时间"};
		model.addAttribute("columns_key", columns_key);
		model.addAttribute("columns_value", columns_value);
		
		return "common_list";
	}
	
	@RequestMapping(value="/goods_delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(
			@RequestParam(value="id") Long id, HttpSession session){
		Staff curStaff=(Staff)session.getAttribute(Constants.USER_INFO_SESSION);
		
		Map<String,String> resp=new HashMap<String, String>();
		try{
			goodsService.delete(id);
			syslogService.create(Syslog.RED, curStaff, "[POST] goods_delete id="+id);
			resp.put("message", "记录删除成功！");
		}catch(Exception ex){
			resp.put("message", "删除记录失败！");
		}
		return resp;
	}

}
