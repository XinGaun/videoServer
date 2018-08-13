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

}
