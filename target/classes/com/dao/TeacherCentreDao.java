package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface TeacherCentreDao {
	/**
	 * 查询教师详情
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryTeacherCentre(HashMap<String,Object> map);
	
	/**
	 * 查询教师教学视频信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryTeacherCentreVideo(HashMap<String,Object> hashMap);
	
	/**
	 * 查询所有视频信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryTeacherCentreVideoAllCount(HashMap<String,Object> hashMap);
}
