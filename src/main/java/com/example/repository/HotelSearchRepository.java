package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Hotel;

/**
 * ホテルテーブルを操作するリポジトリ.
 * 
 * @author ayane.tanaka
 *
 */
@Repository
public class HotelSearchRepository {

	/**
	 * 検索したホテル情報を格納する.
	 * 
	 */
	private final static RowMapper<Hotel> HOTEL_ROW_MAPPER = (rs, i) -> {
		Hotel hotel = new Hotel();
		hotel.setId(rs.getInt("id"));
		hotel.setAreaName(rs.getString("area_name"));
		hotel.setHotelName(rs.getString("hotel_name"));
		hotel.setAddress(rs.getString("address"));
		hotel.setNearestStation(rs.getString("nearest_station"));
		hotel.setPrice(rs.getInt("price"));
		hotel.setParking(rs.getString("parking"));
		return hotel;
	};

	@Autowired
	private NamedParameterJdbcTemplate templete;

	/**
	 * 価格が指定額以下のホテルを検索. 
	 * 
	 * @param price 指定された価格
	 * @return 指定された価格以下のホテルのリスト
	 */
	public List<Hotel> searchByLessThanPrice(Integer price) {
		String sql = "select id,area_name,hotel_name,address,nearest_station,price,parking from hotels where price<=:price order by price desc";
		SqlParameterSource param = new MapSqlParameterSource().addValue("price", price);
		List<Hotel> hotelList = templete.query(sql, param, HOTEL_ROW_MAPPER);
		return hotelList;
	}

}
