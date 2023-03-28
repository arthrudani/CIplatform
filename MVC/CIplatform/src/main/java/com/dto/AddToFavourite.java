package com.dto;

import com.entities.mission;
import com.entities.user;

public class AddToFavourite {
	private user user_id;
	private mission mission_id;
	public AddToFavourite() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddToFavourite(user user_id, mission mission_id) {
		super();
		this.user_id = user_id;
		this.mission_id = mission_id;
	}
	public user getUser_id() {
		return user_id;
	}
	public void setUser_id(user user_id) {
		this.user_id = user_id;
	}
	public mission getMission_id() {
		return mission_id;
	}
	public void setMission_id(mission mission_id) {
		this.mission_id = mission_id;
	}
	@Override
	public String toString() {
		return "AddToFavourite [user_id=" + user_id + ", mission_id=" + mission_id + "]";
	}
	
}
