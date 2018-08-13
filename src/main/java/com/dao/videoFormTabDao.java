package com.dao;

import java.util.ArrayList;

import com.entity.videoFormTab;

public interface videoFormTabDao {
	public ArrayList<videoFormTab> getVideoFormTabs();
	public void updateTab(videoFormTab c);
	public void insertTab(videoFormTab c);
}
