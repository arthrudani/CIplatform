package com.dto;

import java.util.List;

public class Filters {
	private String searchedKeyword;
	private int country_id;
	private List<Integer> searchedcities;
	private List<Integer> searchedthemes;
	private List<Integer> searchedskills;
	
	public Filters() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Filters(String searchedKeyword, int country_id, List<Integer> searchedcities, List<Integer> searchedthemes,
			List<Integer> searchedskills) {
		super();
		this.searchedKeyword = searchedKeyword;
		this.country_id = country_id;
		this.searchedcities = searchedcities;
		this.searchedthemes = searchedthemes;
		this.searchedskills = searchedskills;
	}
	
	public String getSearchedKeyword() {
		return searchedKeyword;
	}
	public void setSearchedKeyword(String searchedKeyword) {
		this.searchedKeyword = searchedKeyword;
	}
	public int getCountry_id() {
		return country_id;
	}
	public void setCountry_id(int country_id) {
		this.country_id = country_id;
	}
	public List<Integer> getSearchedcities() {
		return searchedcities;
	}
	public void setSearchedcities(List<Integer> searchedcities) {
		this.searchedcities = searchedcities;
	}
	public List<Integer> getSearchedthemes() {
		return searchedthemes;
	}
	public void setSearchedthemes(List<Integer> searchedthemes) {
		this.searchedthemes = searchedthemes;
	}
	public List<Integer> getSearchedskills() {
		return searchedskills;
	}
	public void setSearchedskills(List<Integer> searchedskills) {
		this.searchedskills = searchedskills;
	}
	
	@Override
	public String toString() {
		return "Filters [searchedKeyword=" + searchedKeyword + ", country_id=" + country_id + ", searchedcities="
				+ searchedcities + ", searchedthemes=" + searchedthemes + ", searchedskills=" + searchedskills + "]";
	}
	
	
	
}
