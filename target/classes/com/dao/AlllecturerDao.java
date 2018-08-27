package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface AlllecturerDao {
	//查询教师信息
	public ArrayList<HashMap<String,Object>> queryTeacherInformation(HashMap<String,Object> hashMap);
	//查询所有课程信息总数
	public int querycoursesTabAllCount(HashMap<String,Object> hashMap);
}
