package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.Hotel;


/**
 * HotelSearchServiceクラスをテストする.
 * 
 * @author ayane.tanaka
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class HotelSearchServiceTest {

	@Autowired
	private HotelSearchService service;
	
	
	/**
	 * 全件検索をテストする.
	 * 
	 */
	@Test
	public void testSearchAll() {
		List<Hotel> hotelList=service.searchByLessThanPrice(Integer.MAX_VALUE);
		assertThat("TC1:結果数が一致しません",hotelList.size(),is(5));
		assertThat("TC2:最初のホテルidが一致しません",hotelList.get(0).getId(),is(2));
		Integer last= hotelList.size()-1;
		assertThat("TC3:最後のホテルidが一致しません",hotelList.get(last).getId(),is(3));
		//fail("Not yet implemented");
	}
	
	/**
	 * 入力値が0の場合をテストする.
	 */
	@Test
	public void testSearch0() {
		List<Hotel> hotelList=service.searchByLessThanPrice(0);
		assertThat("TC4:結果数が一致しません",hotelList.size(),is(0));
		//fail("Not yet implemented");
	}
	
	/**
	 * 入力値が9999の場合をテストする.
	 */
	@Test
	public void testSearch9999() {
		List<Hotel> hotelList=service.searchByLessThanPrice(9999);
		assertThat("TC5:結果数が一致しません",hotelList.size(),is(1));
		Hotel hotel=hotelList.get(0);
		assertThat("TC6:ホテルidが一致しません",hotel.getId(),is(3));
		assertThat("TC7:地域が一致しません",hotel.getAreaName(),is("首都圏"));
		assertThat("TC8:ホテル名が一致しません",hotel.getHotelName(),is("ホテルローズガーデン新宿"));
		//assertThat("TC9:住所が一致しません",hotel.getAddress(),is("東京都新宿区西新宿８－１－３"));
		assertThat("TC10:最寄駅が一致しません",hotel.getNearestStation(),is("西新宿駅"));
		assertThat("TC11:価格が一致しません",hotel.getPrice(),is(5000));
		assertThat("TC12:駐車場が一致しません",hotel.getParking(),is("あり"));
		
		//fail("Not yet implemented");
	}
	
	
	/**
	 * 入力値が10000の場合をテストする.
	 */
	@Test
	public void testSearch10000() {
		List<Hotel> hotelList=service.searchByLessThanPrice(10000);
		assertThat("TC13:結果数が一致しません",hotelList.size(),is(3));
		//fail("Not yet implemented");
	}

}
