package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.entity.CommentTab;

public interface VideosDao {
	//查询所有课程信息
	public ArrayList<HashMap<String,Object>> querycoursesTabAll(HashMap<String,Object> hashMap);
	//查询所有课程信息总数
	public int querycoursesTabAllCount(HashMap<String,Object> hashMap);
	//查询视频页面推荐课程
	public ArrayList<HashMap<String,Object>> queryRecommend();
	//查询用户是否有过订单记录
	public int queryOrder(HashMap<String,Object> map);
	//查询视频评论信息
	public ArrayList<HashMap<String,Object>> queryComment(HashMap<String,Object> map);
	//查询视频评论信息总数
	public int queryCommentCount(HashMap<String,Object> map);
	//添加视频评论信息
	public int addComment(CommentTab cTab);
}
