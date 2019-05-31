package com.example.repository;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.ui.Model;

import com.example.domain.BaseBallTeam;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseBallTeamRepositoryTest {
	private String answer;
	
	@Autowired
	private BaseBallTeamRepository repository;
	
	@Autowired
	private Model model;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		List<BaseBallTeam> teamList=repository.findAll(model);
		//fail("Not yet implemented");
	}

}
