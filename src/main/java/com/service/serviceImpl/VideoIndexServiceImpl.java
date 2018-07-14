package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.VideoIndexDao;
import com.service.VideoIndexService;
import com.util.Count;
import com.util.OSSUtil;
import com.util.Page;
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
	//获取所有精品课程
	@Override
	public String queryBoutiqueVideoClick(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map= Page.page(map);
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryBoutiqueVideoClick(map);
		int count = videoIndexDao.queryBoutiqueVideoAllCount();
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryBoutiqueVideoAllCount success"));
	}
	//课程评分榜
	/*@Override
	public String queryCourseGrade() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCourseGrade();
		return JSON.toJSONString(list);
	}*/
	private int parseInt(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
