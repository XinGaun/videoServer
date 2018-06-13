package com.entity;

import java.util.Date;

public class opinion {
	private Integer opinion_id;
	private String user_name;
	private Integer user_id;
	private String opinion_text;
	private Date opinion_date;
	
	
	public Integer getOpinion_id() {
		return opinion_id;
	}
	public void setOpinion_id(Integer opinion_id) {
		this.opinion_id = opinion_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOpinion_text() {
		return opinion_text;
	}
	public void setOpinion_text(String opinion_text) {
		this.opinion_text = opinion_text;
	}
	public Date getOpinion_date() {
		return opinion_date;
	}
	public void setOpinion_date(Date opinion_date) {
		this.opinion_date = opinion_date;
	}
	
}
