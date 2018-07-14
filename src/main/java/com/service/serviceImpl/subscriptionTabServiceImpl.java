package com.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.subscriptionTabDao;
import com.entity.subscriptionTab;
import com.service.subscriptionTabService;

@Service
public class subscriptionTabServiceImpl implements subscriptionTabService{
	@Autowired
	private subscriptionTabDao sTabDao;
	
	@Override
	public void insertSubTab(subscriptionTab td) {
		sTabDao.insertSubTab(td);
	}

}
