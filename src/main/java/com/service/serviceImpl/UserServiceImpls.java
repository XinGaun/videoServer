package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDaos;
import com.entity.UserTab;
import com.service.UserService;
@Service
public class UserServiceImpls implements UserService{
	@Autowired
	UserDaos aDao;
	//注册用户
	@Override
	public int addUser(UserTab ut) {
		// TODO Auto-generated method stub
		//System.out.println("ut"+ut);
		//System.out.println(ut.getUser_name());
		return aDao.addUser(ut);
	}
	//注册登录时根据手机号查找是否有该用户
	@Override
	public ArrayList<HashMap<String,Object>> queryUser(String user_phone) {
		// TODO Auto-generated method stub
		//System.out.println("a"+user_phone); 	
		return aDao.queryUser(user_phone);
	}
	//登录
	@Override
	public ArrayList<HashMap<String,Object>> selectUser(UserTab ut) {
		// TODO Auto-generated method stub
		return aDao.selectUser(ut);
				
	}
	//根据手机号更改密码-忘记密码
	@Override
	public int updateUser(UserTab ut) {
		// TODO Auto-generated method stub
		System.out.println("ut"+ut);
		return aDao.updateUser(ut);
	}
	//个人中心更改所有信息
	@Override
	public int updatemessage(UserTab ut) {
		// TODO Auto-generated method stub
		return aDao.updatemessage(ut);
	}
	@Override
	public int updatephone(UserTab ut) {
		// TODO Auto-generated method stub
		return aDao.updatephone(ut);
	}
	

}
