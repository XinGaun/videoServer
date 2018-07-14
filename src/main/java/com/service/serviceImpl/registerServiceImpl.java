package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.registerDao;
import com.entity.register;
import com.service.registerService;

@Service
public class registerServiceImpl implements registerService{
	@Autowired
	public registerDao registerDao;
	
	@Override
	public List<register> getRegister() {
		return registerDao.getRegister();
	}
}
