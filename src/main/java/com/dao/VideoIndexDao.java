package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface VideoIndexDao {
	//查询精品课程
	public ArrayList<HashMap<String,Object>> queryBoutiqueVideo(HashMap<String,Object> map);
	//推荐套餐
	public ArrayList<HashMap<String,Object>> queryCombo();
	//搜索查询
	public ArrayList<HashMap<String,Object>> queryComboSearch(HashMap<String,Object> map);
	//获取所有精品课程
	public ArrayList<HashMap<String,Object>> queryBoutiqueVideoClick(HashMap<String,Object> map);
	//查询所有课程总数
	public int queryBoutiqueVideoAllCount();
	//根据ID查询购买人数
	public HashMap<String, Object> queryBoutiqueIntRs(int map);
}
