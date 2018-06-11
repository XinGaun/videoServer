package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface VideosDao {
	//查询所有课程信息
	public ArrayList<HashMap<String,Object>> querycoursesTabAll(HashMap<String,Object> hashMap);
	//查询所有课程信息总数
	public int querycoursesTabAllCount(HashMap<String,Object> hashMap);
	//查询视频页面推荐课程
	public ArrayList<HashMap<String,Object>> queryRecommend();
}
