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
	//查询评价信息
	public ArrayList<HashMap<String,Object>> queryUserTestEvaluate(HashMap<String,Object> map);
	//查询评价信息总数
	public int queryUserTestEvaluateCount(HashMap<String,Object> map);
	//添加评价信息
	public int addUserTestEvaluate(HashMap<String,Object> map);
	//删除评价信息
	public int deleteUserTestEvaluate(HashMap<String,Object> map);
	//更新评价信息
	public int updateUserTestEvaluate(HashMap<String,Object> map);
	//查询题目分类
	public ArrayList<HashMap<String,Object>> queryUserTestEvaluatetypeName();
	//按难分类查询难度信息
	public ArrayList<HashMap<String,Object>> queryUserTestEvaluateTestGrade(HashMap<String,Object> map);
	//随机抽取题目信息
	public ArrayList<HashMap<String,Object>> queryRandomUserTest(HashMap<String,Object> map);
	//根据题目ID查询答案信息
	public ArrayList<HashMap<String,Object>> queryRandomUserTestAnswer(HashMap<String,Object> map);
	//根据答题结果查询评语
	public HashMap<String,Object> queryAnswerEvaluate(HashMap<String,Object> map);
}
