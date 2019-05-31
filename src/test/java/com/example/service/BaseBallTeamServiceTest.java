package com.example.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.domain.BaseBallTeam;

/**
 * BaseBallTeamServiceクラスをテストする.
 * 
 * @author ayane.tanaka
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BaseBallTeamServiceTest {

	@Autowired
	private BaseBallTeamService service;

	/**
	 * showListメソッドを検証する.
	 * 
	 * 野球チームを全件検索し、結果数から全件検索しているか判定する
	 */
	@Test
	public void testShowList() {
		System.out.println("野球チームを全件検索するテスト開始");
		List<BaseBallTeam> teamList = service.showList();
		assertThat("TC1:リストサイズが正しくありません", teamList.size(), is(6));

		// fail("Not yet implemented");
		System.out.println("野球チームを全件検索するテスト終了");

	}

	/**
	 * showDetailメソッドを検証する.
	 * 
	 * id=1の野球チームを検索し、各内容が正しいか検証する
	 * 
	 */
	@Test
	public void testShowDetail() {
		System.out.println("野球チームをidで検索するテスト開始");
		BaseBallTeam team = service.showDetail(1);
		assertThat("TC2:idが正しくありません", team.getId(), is(1));
		assertThat("TC3:リーグ名が正しくありません", team.getLeagueName(), is("セントラル・リーグ"));
		assertThat("TC4:球団名が正しくありません", team.getTeamName(), is("読売ジャイアンツ"));
		assertThat("TC5:本拠地が正しくありません", team.getHeadquarters(), is("東京ドーム（東京都・文京区）"));
		assertThat("TC6:発足が正しくありません", team.getInauguration(), is("1934年12月26日"));
		// assertThat("TC7:歴史が正しくありません",team.getHistory(),is("大日本東京野球倶楽部（1934年) \n↓\n東京巨人軍（1935年〜1946年） \n↓\n読売ジャイアンツ（1947年〜）"));

		// fail("Not yet implemented");
		System.out.println("野球チームをidで検索するテスト終了");

	}

}
