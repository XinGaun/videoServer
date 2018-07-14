package com.service;

public interface VideoIndexService {
	//查询推荐课程
	public String queryBoutiqueVideo();
	//查询推荐套餐
	public String queryCombo();
	//查询所有的精品课程
	public String queryBoutiqueVideoClick(String data);

}
