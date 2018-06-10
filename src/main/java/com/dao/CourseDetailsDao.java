package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface CourseDetailsDao {
	public ArrayList<HashMap<String,Object>> queryCourseDetails(HashMap<String,Object> map);
	public HashMap<String,Object> queryVideoDetails(int video_id);
	public  ArrayList<HashMap<String,Object>> queryRecommendCourse();
}
