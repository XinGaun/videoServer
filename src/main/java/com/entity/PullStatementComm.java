package com.entity;

import java.util.ArrayList;

public class PullStatementComm {
	private String comm_model;
	private ArrayList<PullStatementSumList> sumList;
	public String getComm_model() {
		return comm_model;
	}
	public void setComm_model(String comm_model) {
		this.comm_model = comm_model;
	}
	public ArrayList<PullStatementSumList> getSumList() {
		return sumList;
	}
	public void setSumList(ArrayList<PullStatementSumList> sumList) {
		this.sumList = sumList;
	}
	
}
