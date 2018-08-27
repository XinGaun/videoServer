package com.service;

import java.util.ArrayList;

import com.entity.videoFormTab;

public interface videoFormTabService {
	public ArrayList<videoFormTab> getVideoFormTabs();
	public void updateTab(videoFormTab c);
	public void insertTab(videoFormTab c);
	public ArrayList<videoFormTab> searchTab(videoFormTab c);
	public ArrayList<videoFormTab> getTabById(int  videoFormId);
	public void upStatusTabById(int  videoFormId,int  videoFormStatus);
}
