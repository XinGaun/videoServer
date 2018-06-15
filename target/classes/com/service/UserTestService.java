package com.service;

public interface UserTestService {
	// 添加题目信息
	public String addUserTest(String data);
	//查询题目信息
	public String queryUserTest(String data);
	//查询答案详情信息
	public String queryUserTestAnswer(String data);
	//修改题目信息
	public String updateUserTest(String data);
	//删除题目信息
	public String deteleUserTest(String data);
	//查询评价信息
	public String queryUserTestEvaluate(String data);
	//添加评价信息
	public String addUserTestEvaluate(String data);
	//删除评价信息
	public String deleteUserTestEvaluate(String data);
	//更新评价信息
	public String updateUserTestEvaluate(String data);
}