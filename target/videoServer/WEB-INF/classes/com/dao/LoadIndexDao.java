package com.dao;
/**
 * loadInxdexDao层接口
 * @author 87518
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public interface LoadIndexDao {
	/*
	 * 查询课程分类信息
	 */
	public ArrayList<HashMap<String,Object>> queryCourseType(HashMap<String,Object> map);
	/**
	 * 查询推荐课程信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryRecommendCourseList(HashMap<String,Object> map);
	/**
	 * 查询推荐课程信息总数
	 */
	public int queryRecommendCourseListCount(HashMap<String,Object> map);
	/**
	 * 查询课程信息
	 */
	public ArrayList<HashMap<String,Object>> queryCourseList(HashMap<String,Object> map);
}
