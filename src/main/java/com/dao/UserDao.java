package com.dao;

import java.util.ArrayList;
import java.util.HashMap;


import com.entity.UserTab;

public interface UserDao {
	public int addUser(UserTab ut);
	public ArrayList<HashMap<String,Object>> queryUser(String user_phone);
	public ArrayList<HashMap<String,Object>> selectUser(UserTab ut);
	public int updateUser(UserTab ut);
}
