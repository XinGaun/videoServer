package com.service;


import java.util.ArrayList;
import java.util.HashMap;

import com.entity.UserTab;

public interface UserService {
	//注册用户
	public int addUser(UserTab ut);
	//注册登录时根据手机号查找是否有该用户
	public ArrayList<HashMap<String,Object>> queryUser(String user_phone);
	//登录
	public ArrayList<HashMap<String,Object>> selectUser(UserTab ut);
	//根据手机号更改密码-忘记密码
	public int updateUser(UserTab ut);
	//个人中心更改所有信息
	public int updatemessage(UserTab ut);
	//更改手机号
	public int updatephone(UserTab ut);

	//登录时查询是否首次登录
	public ArrayList<HashMap<String,Object>> isfirst(String user_phone);
	

}
