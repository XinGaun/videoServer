package com.service;

import java.util.ArrayList;

import com.entity.videoFormTab;

public interface videoFormTabService {
	public ArrayList<videoFormTab> getVideoFormTabs();
	public void updateTab(videoFormTab c);
	public void insertTab(videoFormTab c);
}
