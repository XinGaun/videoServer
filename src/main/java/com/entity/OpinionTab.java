package com.entity;

import java.util.Date;

public class OpinionTab {
	int opinionId ;
	int userId  ;
	String opinionText ;
	Date opinionDate ;
	public int getOpinionId() {
		return opinionId;
	}
	public void setOpinionId(int opinionId) {
		this.opinionId = opinionId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getOpinionText() {
		return opinionText;
	}
	public void setOpinionText(String opinionText) {
		this.opinionText = opinionText;
	}
	public Date getOpinionDate() {
		return opinionDate;
	}
	public void setOpinionDate(Date opinionDate) {
		this.opinionDate = opinionDate;
	}
	
}
