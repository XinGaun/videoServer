package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface VideoIndexDao {
	//查询精品课程
	public ArrayList<HashMap<String,Object>> queryBoutiqueVideo();
	//推荐套餐
	public ArrayList<HashMap<String,Object>> queryCombo();
	//获取课程点击榜
	public ArrayList<HashMap<String,Object>> queryCourseClick();
	//获取课程评分榜
	public ArrayList<HashMap<String,Object>> queryCourseGrade();
}
