package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.BaseBallTeam;

/**
 * 野球チームテーブルを操作するリポジトリ.
 * 
 * @author ayane.tanaka
 *
 */
@Repository
public class BaseBallTeamRepository {
	
	/**
	 * DBから受け取ったデータの格納.
	 */
	private final static RowMapper<BaseBallTeam> BASEBALLTEAM_ROW_MAPPER=(rs,i)->{
		BaseBallTeam team=new BaseBallTeam();
		team.setId(rs.getInt("id"));
		team.setLeagueName(rs.getString("league_name"));
		team.setTeamName(rs.getString("team_name"));
		team.setHeadquarters(rs.getString("headquarters"));
		team.setInauguration(rs.getString("inauguration"));
		team.setHistory(rs.getString("history"));
		return team;
	};

	
	@Autowired
	NamedParameterJdbcTemplate template;
	
	/**
	 * 野球チーム全件検索.
	 * 
	 * @return
	 */
	public List<BaseBallTeam> findAll(){
		String sql="select id,league_name,team_name,headquarters,inauguration,history from teams order by inauguration";
		List<BaseBallTeam> teamList=template.query(sql, BASEBALLTEAM_ROW_MAPPER);
		return teamList;
	}
	
	/**
	 * idで野球チーム情報を検索.
	 * 
	 * @param id 検索したい野球チームのid
	 * @return 検索した野球チーム情報
	 */
	public BaseBallTeam load(Integer id) {
		String sql="select id,league_name,team_name,headquarters,inauguration,history from teams where id=:id";
		SqlParameterSource param=new MapSqlParameterSource().addValue("id", id);
		BaseBallTeam team=template.queryForObject(sql, param, BASEBALLTEAM_ROW_MAPPER);
		return team;
	}
}
