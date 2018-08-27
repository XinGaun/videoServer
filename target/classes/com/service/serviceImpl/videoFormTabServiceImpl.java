package com.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.videoFormTabDao;
import com.entity.videoFormTab;
import com.service.videoFormTabService;

@Service
public class videoFormTabServiceImpl implements videoFormTabService{
	@Autowired
	private videoFormTabDao vDao;
	@Override
	public void updateTab(videoFormTab c) {
		vDao.updateTab(c);
	}
	@Override
	public ArrayList<videoFormTab> getVideoFormTabs() {
		return vDao.getVideoFormTabs();
	}
	@Override
	public void insertTab(videoFormTab c) {
		vDao.insertTab(c);
	}
	@Override
	public ArrayList<videoFormTab> searchTab(videoFormTab c) {
		// TODO Auto-generated method stub
		return vDao.searchTab(c);
	}
	@Override
	public ArrayList<videoFormTab> getTabById(int videoFormId) {
		// TODO Auto-generated method stub
		return vDao.getTabById(videoFormId);
	}
	@Override
	public void upStatusTabById(int videoFormId, int videoFormStatus) {
		// TODO Auto-generated method stub
		vDao.upStatusTabById(videoFormId, videoFormStatus);
	}

}
