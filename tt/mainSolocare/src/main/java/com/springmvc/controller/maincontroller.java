package com.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = {"/"})
public class maincontroller {
	@GetMapping
	public String welcome(){
		return "welcome";
	}

	@GetMapping("/home")
	public String home()
	{
		return "main";
	}
}
