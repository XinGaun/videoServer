package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserTestDao {
	//添加题目信息
	public int addUserTest(HashMap<String,Object> map);
	//添加答案信息
	public int addUserTestAnswer(HashMap<String,Object> map);
	//查询题目信息
	public ArrayList<HashMap<String,Object>> queryUserTest(HashMap<String,Object> map);
	//查询题目信息总数
	public int queryUserTestCount(HashMap<String,Object> map);
	//查询相关答案信息
	public ArrayList<HashMap<String,Object>> queryUserTestAnswer(HashMap<String,Object> map);
	//修改题目信息
	public int updateUserTest(HashMap<String,Object> map);
	//删除答案信息
	public int deteleTestAnswer(HashMap<String,Object> map);
	//删除题目信息
	public int deteleUserTest(HashMap<String,Object> map);
}
