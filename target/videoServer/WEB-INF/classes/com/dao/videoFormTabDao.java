package com.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.entity.videoFormTab;

public interface videoFormTabDao {
	public ArrayList<videoFormTab> getVideoFormTabs();
	public void updateTab(videoFormTab c);
	public void insertTab(videoFormTab c);
	public ArrayList<videoFormTab> searchTab(videoFormTab c);
	public ArrayList<videoFormTab> getTabById(int  videoFormId);
	public void upStatusTabById(@Param(value="video_form_id")  int videoFormId, @Param(value="video_form_status")  int videoFormStatus);
}
