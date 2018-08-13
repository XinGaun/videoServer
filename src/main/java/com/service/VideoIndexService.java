package com.service;

public interface VideoIndexService {
	//查询推荐课程
	public String queryBoutiqueVideo(String data);
	//查询推荐套餐
	public String queryCombo();
	//查询搜索内容
	public String queryComboSearch(String data);
	//查询所有的精品课程
	public String queryBoutiqueVideoClick(String data);

}
