package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.UserDaos;
import com.entity.UserTab;
import com.service.UserService;
@Service
public class UserServiceImpls implements UserService{
	@Autowired
	UserDaos aDao;
	@Override
	public int addUser(UserTab ut) {
		// TODO Auto-generated method stub
		//System.out.println("ut"+ut);
		//System.out.println(ut.getUser_name());
		return aDao.addUser(ut);
	}
	@Override
	public ArrayList<HashMap<String,Object>> queryUser(String user_phone) {
		// TODO Auto-generated method stub
		//System.out.println("a"+user_phone); 	
		return aDao.queryUser(user_phone);
	}
	@Override
	public ArrayList<HashMap<String,Object>> selectUser(UserTab ut) {
		// TODO Auto-generated method stub
		return aDao.selectUser(ut);
				
	}
	@Override
	public int updateUser(UserTab ut) {
		// TODO Auto-generated method stub
		System.out.println("ut"+ut);
		return aDao.updateUser(ut);
	}

}
