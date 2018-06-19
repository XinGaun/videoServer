package com.service;

public interface VideosDaoService {
	//课程中心查询接口
	public String querycoursesTabAll(String data);
	//课程中心推荐课程
	public String queryRecommend();
	//查询用户是否购买过课程
	public String queryOrder(String data);
}
