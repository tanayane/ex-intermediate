package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Hotel;
import com.example.form.HotelSearchForm;
import com.example.service.HotelSearchService;

/**
 * ホテルを入力された価格以下で検索する.
 * 
 * @author ayane.tanaka
 *
 */
@Controller
@RequestMapping("ex-02")
public class HotelSearchController {

	@Autowired
	private HotelSearchService service;

	/**
	 * フォーム準備を行う.
	 * 
	 * @return ホテルの最大価格を入力するフォーム
	 */
	@ModelAttribute
	public HotelSearchForm setUpForm() {
		return new HotelSearchForm();
	}

	/**
	 * ホテル検索画面を表示.
	 * 
	 * @return ホテル検索画面
	 */
	@RequestMapping("")
	public String index(Model model) {
		return "hotelsearch";
	}

	/**
	 * ホテル検索を行い画面に表示.
	 * 
	 * @param form 入力されたホテル価格の最大値のフォーム
	 * @param      result エラーチェック
	 * @param      model リクエストスコープ
	 * @return ホテル検索結果画面
	 */
	@RequestMapping("/search")
	public String search(@Validated HotelSearchForm form, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return index(model);
		}
		List<Hotel> hotelList = new ArrayList<>();
		if (form.getMaxprice() == null) {
			hotelList = service.searchByLessThanPrice(Integer.MAX_VALUE);
		}else{
			hotelList = service.searchByLessThanPrice(form.getMaxprice());	
		}
		model.addAttribute("hotelList", hotelList);
		return "hotelsearch";
	}

}
