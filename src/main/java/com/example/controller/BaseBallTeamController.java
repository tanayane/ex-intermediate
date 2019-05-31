package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class BaseBallTeamController {
	
	@RequestMapping("")
	public String index() {
		
		return "teamlist";
	}
	
	@RequestMapping("/showDetail")
	public String showDetail(Integer id) {
		return "teamdetail";
	}

}
