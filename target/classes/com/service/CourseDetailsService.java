package com.service;

public interface CourseDetailsService {
	public String queryCourseDetails(String data);
	public String queryVideoDetails(String data);
	public String queryqueryRecommendCourse();
	/**
	 * 查询学员评论
	 * @param data
	 * @return
	 */
	public String queryStudentComments(String data);
	/**
	 * �Ƿ��Ѿ��ղؿγ�
	 * @param data
	 * @return
	 */
	public String queryInitEnshrine(String data);
	/**
	 * 插入到收藏表
	 * @param data
	 * @return
	 */
	public String addCollection(String data);
	/**
	 * 根据课程ID查询教师信息
	 * @param data
	 * @return
	 */
	public String queryTeacherClass(String data);
}
