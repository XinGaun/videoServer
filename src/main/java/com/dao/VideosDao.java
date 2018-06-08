package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface VideosDao {
	//查询所有课程信息
	public ArrayList<HashMap<String,Object>> querycoursesTabAll(HashMap<String,Object> hashMap);
	//查询所有课程信息总数
	public int querycoursesTabAllCount(HashMap<String,Object> hashMap);
<<<<<<< HEAD
	//查询视频页面推荐课程
	public ArrayList<HashMap<String,Object>> queryRecommend();
=======
>>>>>>> d08894e0d8b8c7e28ea3a0895ae74d050b7b3c77
}
