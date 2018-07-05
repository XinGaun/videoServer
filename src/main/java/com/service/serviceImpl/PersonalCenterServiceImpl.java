package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.PersonalCenterDao;
import com.service.PersonalCenterService;
import com.util.Count;

@Service
@SuppressWarnings("unchecked")
public class PersonalCenterServiceImpl implements PersonalCenterService{
	@Autowired
	private PersonalCenterDao personalCenterDao;
	/**
	 * 查询收藏课程
	 */
	@Override
	public String queryPersonalCenter(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> arrayList = personalCenterDao.queryPersonalCenter(map);
		int count = personalCenterDao.queryPersonalCenterAllCount(map);
		return JSON.toJSONString(Count.counts(arrayList, count, map, 200, "queryPersonalCenter success"));
	}
	/**
	 * 删除收藏课程
	 */
	@Override
	public String deleteSubscription(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		int flog = personalCenterDao.deleteSubscription(map);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询推荐课程
	 */
	@Override
	public String queryRecommend() {
		ArrayList<HashMap<String,Object>> list = personalCenterDao.queryRecommend();
		return JSON.toJSONString(list);
	}
	/**
	 * 查询订单详情
	 */
	@Override
	public String queryOrderInformation(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> arrayList = personalCenterDao.queryOrderInformation(map);
		int count = personalCenterDao.queryOrderInformationAllCount(map);
		return JSON.toJSONString(Count.counts(arrayList, count, map, 200, "queryOrderInformation success"));
	}

}
