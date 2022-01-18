package com.june.revisiontool.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("") 
	public String home(HttpSession session) {
		//session.setAttribute(null, session);
		return "home";
	}
	
}
