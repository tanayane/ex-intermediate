package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.BaseBallTeam;
import com.example.repository.BaseBallTeamRepository;

@Service
@Transactional
public class BaseBallTeamService {

	@Autowired
	private BaseBallTeamRepository repository;
	
	public List<BaseBallTeam> showList(){
		return repository.findAll();
	}
	
	public BaseBallTeam showDetail(Integer id) {
		return repository.load(id);
	}
}
