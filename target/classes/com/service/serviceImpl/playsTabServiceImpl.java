package com.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.playsTabDao;
import com.entity.playsTab;
import com.service.playsTabService;

@Service
public class playsTabServiceImpl implements playsTabService{
	@Autowired
	private playsTabDao playsTabDao;
	
	@Override
	public void insertPlaysTab(playsTab t) {
		playsTabDao.insertPlaysTab(t);
	}

}
