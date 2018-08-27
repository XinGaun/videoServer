package com.service;

public interface LoadIndexService {
	/**
	 * 查询课程分类
	 * @param data
	 * @return
	 */
	public String queryCourseType(String data);
	/**
	 * 查询初始化的推荐课程
	 */
	public String queryRecommendCourseList(String data);
}
