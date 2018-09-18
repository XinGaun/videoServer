package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.LoadIndexDao;
import com.service.LoadIndexService;
import com.util.Count;
import com.util.Page;
@Service
@SuppressWarnings("unchecked")
public class LoadIndexServiceImpl implements LoadIndexService {
	@Autowired
	private LoadIndexDao indexDao;
	@Override
	public String queryCourseType(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list = indexDao.queryCourseType(map);
		return JSON.toJSONString(list);
	}
	/**
	 * 查询初始化的推荐课程信息
	 */
	@Override
	public String queryRecommendCourseList(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map = Page.pages(map);
		ArrayList<HashMap<String,Object>> list = indexDao.queryRecommendCourseList(map);
		int count = indexDao.queryRecommendCourseListCount(map);
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryUserTest success"));
	}
	/**
	 * 用户查询课程信息
	 */
	@Override
	public String queryUseridCourseList(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map = Page.pages(map);
		ArrayList<HashMap<String,Object>> list = indexDao.queryUseridCourseList(map);
		int count = indexDao.queryUseridCourseCount(map);
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryUseridCourseList success"));
	}

}
