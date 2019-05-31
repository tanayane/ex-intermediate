package com.example.form;

import javax.validation.constraints.Digits;

import org.hibernate.validator.constraints.Range;


/**
 * ホテル価格の最大額を受け取るフォーム.
 * 
 * @author ayane.tanaka
 *
 */
public class HotelSearchForm {
    /**
     　* 送信されたホテル価格の最大額
     */
    @Range(min=0,max=Integer.MAX_VALUE,message="正の整数を入力してください")
    @Digits(integer=10,fraction=0,message="正の整数を入力してください")
	private Integer maxprice;

    
    
	@Override
	public String toString() {
		return "HotelSearchForm [maxprice=" + maxprice + "]";
	}

	public Integer getMaxprice() {
		return maxprice;
	}

	public void setMaxprice(Integer maxprice) {
		this.maxprice = maxprice;
	}
}
