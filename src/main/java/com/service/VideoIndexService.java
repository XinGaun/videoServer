package com.service;

public interface VideoIndexService {
	//查询推荐课程
	public String queryBoutiqueVideo();
	//查询推荐套餐
	public String queryCombo();
	//查询课程点击榜
	public String queryCourseClick();
	//查询课程评分榜
	public String queryCourseGrade();
}
