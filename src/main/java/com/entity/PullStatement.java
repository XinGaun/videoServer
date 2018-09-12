package com.entity;

import java.util.ArrayList;

public class PullStatement {
	private String cate_name;
	private ArrayList<PullStatementComm> commModelList;
	public String getCate_name() {
		return cate_name;
	}

	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}

	public ArrayList<PullStatementComm> getCommModelList() {
		return commModelList;
	}

	public void setCommModelList(ArrayList<PullStatementComm> commModelList) {
		this.commModelList = commModelList;
	}
	
	
}
