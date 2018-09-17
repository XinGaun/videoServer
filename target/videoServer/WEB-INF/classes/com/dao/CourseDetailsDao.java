package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface CourseDetailsDao {
	public ArrayList<HashMap<String,Object>> queryCourseDetails(HashMap<String,Object> map);
	//�Ƿ����ղؿγ�
	public ArrayList<HashMap<String,Object>> queryInitEnshrine(HashMap<String,Object> map);
	public HashMap<String,Object> queryVideoDetails(int video_id);
	public  ArrayList<HashMap<String,Object>> queryRecommendCourse();
	/**
	 * 查询学员评论
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryStudentComments(HashMap<String,Object> map);
	/**
	 * 查询学员评论总数
	 * @param hashMap
	 * @return
	 */
	public int queryStudentCommentsAllCount(HashMap<String,Object> hashMap);
	/**
	 * 插入到收藏表
	 * @param map
	 * @return
	 */
	public Integer addCollection(HashMap<String,Object> map);
	/**
	 * 根据课程ID查询教师信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryTeacherClass(HashMap<String,Object> map);
}
