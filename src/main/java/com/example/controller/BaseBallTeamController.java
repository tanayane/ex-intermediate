package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseBallTeam;
import com.example.service.BaseBallTeamService;

@Controller
@RequestMapping("/")
public class BaseBallTeamController {

	@Autowired
	private BaseBallTeamService service;

	@RequestMapping("")
	public String index(Model model) {
		List<BaseBallTeam> teamList = service.showList();
		model.addAttribute("teamList", teamList);
		return "teamlist";
	}

	@RequestMapping("/showDetail")
	public String showDetail(Integer id,Model model) {
		BaseBallTeam team=service.showDetail(id);
		model.addAttribute("team",team);
		return "teamdetail";
	}
	

}
