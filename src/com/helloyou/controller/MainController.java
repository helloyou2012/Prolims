package com.helloyou.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.helloyou.model.Staff;
import com.helloyou.model.Syslog;
import com.helloyou.service.StaffService;
import com.helloyou.service.SyslogService;
import com.helloyou.util.Constants;

@Controller
// 将Model中属性名为Constants.USER_INFO_SESSION的属性放到Session属性列表中，以便这个属性可以跨请求访问
@SessionAttributes(Constants.USER_INFO_SESSION)
public class MainController {
	
	@Autowired
	private StaffService staffService;
	@Autowired
	private SyslogService syslogService;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String dashboard(Model model) {
		model.addAttribute("dashboard", "active");
		return "dashboard";
	}
	
	@RequestMapping(value = "/exit", method = RequestMethod.GET)
	public String exit(SessionStatus status, HttpSession session) {
		status.setComplete();
		session.removeAttribute(Constants.USER_INFO_SESSION);
		return "index";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String adminLogin(@RequestParam("username") String username,
			@RequestParam("password") String password, Model model) {
		
		Staff user = staffService.findByNameAndPasswd(username, password);
		if (user == null) {
			model.addAttribute("message", "用户名和密码不匹配！");
			return "index";
		} else {
			// USER_INFO_SESSION的属性放到Session属性列表中
			model.addAttribute(Constants.USER_INFO_SESSION, user);
			syslogService.create(Syslog.GREEN, user, "[POST] login");
			return "redirect:dashboard";
		}
		
	}

}
