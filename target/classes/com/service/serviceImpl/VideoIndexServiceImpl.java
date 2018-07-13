package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.VideoIndexDao;
import com.service.VideoIndexService;
@Service
public class VideoIndexServiceImpl implements VideoIndexService {
	@Autowired
	private VideoIndexDao videoIndexDao;
	//查询推荐课程
	@Override
	public String queryBoutiqueVideo() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryBoutiqueVideo();
		return JSON.toJSONString(list);
	}
	//查询推荐套餐
	@Override
	public String queryCombo() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCombo();
		return JSON.toJSONString(list);
	}
	//课程点击榜
	@Override
	public String queryCourseClick() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCourseClick();
		return JSON.toJSONString(list);
	}
	//课程评分榜
	@Override
	public String queryCourseGrade() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCourseGrade();
		return JSON.toJSONString(list);
	}

}
