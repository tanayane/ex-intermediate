package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseBallTeam;
import com.example.repository.BaseBallTeamRepository;

/**
 * 野球チームのテーブルを操作するサービス.
 * 
 * @author ayane.tanaka
 *
 */
@Service
@Transactional
public class BaseBallTeamService {

	@Autowired
	private BaseBallTeamRepository repository;
	
	/**
	 * 野球チームを全件検索する.
	 * 
	 * @return 野球チームのリスト
	 */
	public List<BaseBallTeam> showList(){
		return repository.findAll();
	}
	
	/**
	 * 指定されたidの野球チームデータを検索.
	 * 
	 * @param id 検索する野球チームのid
	 * @return 検索した野球チームのデータZZ
	 */
	public BaseBallTeam showDetail(Integer id) {
		return repository.load(id);
	}
}
