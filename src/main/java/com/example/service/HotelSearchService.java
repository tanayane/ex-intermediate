package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.repository.HotelSearchRepository;

@Service
@Transactional
public class HotelSearchService {
	@Autowired
	private HotelSearchRepository repository;
	
	
}
