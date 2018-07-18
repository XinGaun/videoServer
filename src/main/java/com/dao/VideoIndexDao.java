package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface VideoIndexDao {
	//查询精品课程
	public ArrayList<HashMap<String,Object>> queryBoutiqueVideo(HashMap<String,Object> map);
	//推荐套餐
	public ArrayList<HashMap<String,Object>> queryCombo();
	//获取所有精品课程
	public ArrayList<HashMap<String,Object>> queryBoutiqueVideoClick(HashMap<String,Object> map);
	//查询所有课程总数
	public int queryBoutiqueVideoAllCount();
}
