package com.it.controller;

import java.util.Comparator;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.it.service.AuthService;

@Controller
public class LoginController {
	
	
	@Autowired
	private AuthService authService;
	
	@GetMapping("/greet")
	public String showPage() {
		return "jadoo/welcome"; //  /welcome.jsp
	}
	

	@GetMapping("/auth")
	public String showLoginPage() {
		return "jadoo/login"; //  /welcome.jsp
	}
	
	//<form action="auth" method="post">
	@PostMapping("/auth")
	public String postLogin(HttpServletRequest req) {
		String username=req.getParameter("username");
		String password=req.getParameter("password");
		if(authService.validateUser(username, password)) {
			req.setAttribute("message","Welcome mr. "+username);
			return "home";
		}
		req.setAttribute("message","I am sorry your username and password are not correct!");
		return "jadoo/login"; //  /welcome.jsp
	}


}
