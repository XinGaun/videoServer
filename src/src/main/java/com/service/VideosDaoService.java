package com.service;

import java.util.HashMap;

public interface VideosDaoService {
	//课程中心查询接口
	public String querycoursesTabAll(String data);
	//课程中心推荐课程
	public String queryRecommend();
	//查询用户是否购买过课程
	public String queryOrder(String data);
	//查询视频评论记录
	public String queryComment(String data);
	//查询视频评论信息总数
	//public int queryCommentCount(HashMap<String,Object> map);
	//添加视频评论记录
	public int addComment(String data);
}
