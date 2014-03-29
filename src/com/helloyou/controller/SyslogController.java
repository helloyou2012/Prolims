package com.helloyou.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.helloyou.model.Syslog;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Paginator;
import com.helloyou.util.PaginatorImpl;
import com.helloyou.vo.DataTableVO;

@Controller
public class SyslogController {
	@Autowired
	private SyslogService syslogService;
	
	@RequestMapping(value="/syslog_list", method = RequestMethod.POST)
	public @ResponseBody 
	Map<String, Object> list(@ModelAttribute DataTableVO vo){
		int page=vo.getiDisplayStart()/vo.getiDisplayLength()+1;
		Paginator paginator = new PaginatorImpl(page, vo.getiDisplayLength());
		List<Syslog> syslog = syslogService.getAll(paginator, vo.getiSortCol_0(), vo.getsSortDir_0(), vo.getsSearch());
		
		Map<String, Object> result = new HashMap<String, Object>();
		result.put("iTotalRecords", paginator.getTotal());
		result.put("iTotalDisplayRecords", paginator.getTotal());
		result.put("aaData", syslog);
		result.put("sEcho", vo.getsEcho());
		return result;
	}
	@RequestMapping(value="/syslog_list", method = RequestMethod.GET)
	public String list(Model model){
		model.addAttribute("syslog_list", "active");
		model.addAttribute("main_nav", "日志管理");
		model.addAttribute("sub_nav", "日志列表");
		
		model.addAttribute("ajax_url", "syslog_list");
		model.addAttribute("edit_url", "#");
		model.addAttribute("delete_url", "syslog_delete");
		
		String[] columns_key={"id", "time", "level", "staff.username", "remark"};
		String[] columns_value={"编号","日期","等级","操作人","详细信息"};
		model.addAttribute("columns_key", columns_key);
		model.addAttribute("columns_value", columns_value);
		
		return "common_list";
	}
	
	@RequestMapping(value="/syslog_delete", method = RequestMethod.POST)
	public @ResponseBody
	Map<String, String> delete(
			@RequestParam(value="id") Long id){
		Map<String,String> resp=new HashMap<String, String>();
		try{
			syslogService.delete(id);
			resp.put("message", "记录删除成功！");
		}catch(Exception ex){
			resp.put("message", "删除记录失败！");
		}
		return resp;
	}

}
