package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.BaseBallTeam;
import com.example.service.BaseBallTeamService;

/**
 * 野球チーム一覧の表示とチーム詳細を行う.
 * 
 * @author ayane.tanaka
 *
 */
@Controller
@RequestMapping("/")
public class BaseBallTeamController {

	@Autowired
	private BaseBallTeamService service;

	/**
	 * 野球チーム一覧を表示.
	 * 
	 * @param model リクエストスコープ
	 * @return　チーム一覧の表示画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		List<BaseBallTeam> teamList = service.showList();
		model.addAttribute("teamList", teamList);
		return "teamlist";
	}

	/**
	 * 指定されたidの野球チーム詳細を表示.
	 * 
	 * @param id 表示したい野球チームのid
	 * @param model リクエストスコープ
	 * @return　チーム詳細の表示画面
	 */
	@RequestMapping("/showDetail")
	public String showDetail(Integer id,Model model) {
		BaseBallTeam team=service.showDetail(id);
		model.addAttribute("team",team);
		return "teamdetail";
	}
	

}
