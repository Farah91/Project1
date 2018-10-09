package com.student.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.student.demo.pojo.User;
import com.student.demo.service.LoginService;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class LoginController {
	
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
	    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	}
	
	
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="login.html")
	public String goToLoginPage() {
		
		return "login.jsp";
		
	}
	
	@RequestMapping(value="dologin.html",method=RequestMethod.POST)
	public String validateUser(Model model, @RequestParam("username") String username, @RequestParam("password") String password) {
		
		if(loginService.validateUser(username,password)) {
			
			User user = new User();
			
			List<User> userList = loginService.getUserList();
			
			model.addAttribute("userList", userList);
			
			model.addAttribute("user", user);
	
			
			return "dashboard.jsp";
		}else {
			return "login.jsp";
		}

}
	
	
	@RequestMapping(value="processUser.html",method=RequestMethod.POST)
	public String processUser(Model model, @ModelAttribute("user") User user) {
		
		
			loginService.saveUser(user);
			
			List<User> userList = loginService.getUserList();
			
			model.addAttribute("userList", userList);
			
			model.addAttribute("user", new User());
	
			
			return "dashboard.jsp";
		

}
	
	
	@RequestMapping(value="editUser.html",method=RequestMethod.GET)
	public String editUser(Model model, @RequestParam("id") Integer id) {
		
		
			User user = loginService.findUserById(id);
			
			
			
			List<User> userList = loginService.getUserList();
			
			model.addAttribute("userList", userList);
			
			model.addAttribute("user", user);
	
			
			return "dashboard.jsp";
	
	
	
	}	
	
	
}