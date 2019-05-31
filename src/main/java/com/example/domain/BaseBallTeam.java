package com.example.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * 野球チーム情報を表す.
 * 
 * @author ayane.tanaka
 *
 */
public class BaseBallTeam {
	/**	 球団名 */
	private String name;
	/**	 本拠地 */
	private String address;
	/**	 発足 */
	private LocalDate date;
	/**	 歴史 */
	private List<String> history;
	
	@Override
	public String toString() {
		return "BaseBallTeam [name=" + name + ", address=" + address + ", date=" + date + ", history=" + history + "]";
	}
	
	//get&set
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public List<String> getHistory() {
		return history;
	}
	public void setHistory(List<String> history) {
		this.history = history;
	}
	
	
}
