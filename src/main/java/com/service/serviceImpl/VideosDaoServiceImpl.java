package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.VideosDao;
import com.service.VideosDaoService;
import com.util.Count;
import com.util.Page;
@SuppressWarnings("unchecked")
@Service
public class VideosDaoServiceImpl implements VideosDaoService {
	@Autowired
	private VideosDao videosDao;
	@Override
	public String querycoursesTabAll(String data) {
		HashMap<String,Object> hashmap = JSON.parseObject(data,HashMap.class);
		hashmap= Page.page(hashmap);
		ArrayList<HashMap<String,Object>> list = videosDao.querycoursesTabAll(hashmap);
		int count = videosDao.querycoursesTabAllCount(hashmap);
		//System.out.println(count);
		return JSON.toJSONString(Count.counts(list, count, hashmap,200,"querycoursesTabAll success"));
	}

}
