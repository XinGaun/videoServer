package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.UserTestDao;
import com.service.UserTestService;
import com.util.Count;
import com.util.Page;
@Service
@SuppressWarnings("unchecked")
public class UserTestServiceImpl implements UserTestService {
	@Autowired
	private UserTestDao userTestDao;
	/**
	 * 添加题目信息
	 */
	@Transactional
	public String addUserTest(String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap.put("test_id","-1");
		int flogtest = userTestDao.addUserTest(hashMap);
		ArrayList<String> listMap = JSON.parseObject(hashMap.get("user_test_answer").toString(), ArrayList.class);
		int floganswer = 0;
		for(int i=0;i<listMap.size();i++) {
			HashMap<String,Object> minMap = JSON.parseObject(JSON.toJSONString(listMap.get(i)),HashMap.class);
			minMap.put("test_id",hashMap.get("test_id"));
			int result = userTestDao.addUserTestAnswer(minMap);
			floganswer = floganswer+result;
		}
		if(floganswer==4&&flogtest==1) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询题目信息
	 */
	@Override
	public String queryUserTest(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map = Page.page(map);
		ArrayList<HashMap<String,Object>> list = userTestDao.queryUserTest(map);
		int count = userTestDao.queryUserTestCount(map);
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryUserTest success"));
	}
	/**
	 * 查询答案信息
	 */
	@Override
	public String queryUserTestAnswer(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list = userTestDao.queryUserTestAnswer(map);
		return JSON.toJSONString(list);
	}
	/**
	 * 更新题目信息
	 */
	@Transactional
	public String updateUserTest(String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		int flogtest = userTestDao.updateUserTest(hashMap);
		userTestDao.deteleTestAnswer(hashMap);
		ArrayList<String> listMap = JSON.parseObject(hashMap.get("user_test_answer").toString(), ArrayList.class);
		int floganswer = 0;
		for(int i=0;i<listMap.size();i++) {
			HashMap<String,Object> minMap = JSON.parseObject(JSON.toJSONString(listMap.get(i)),HashMap.class);
			minMap.put("test_id",hashMap.get("test_id"));
			int result = userTestDao.addUserTestAnswer(minMap);
			floganswer = floganswer+result;
		}
		if(floganswer==4&&flogtest==1) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除题目信息
	 */
	@Transactional
	public String deteleUserTest(String data) {
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		int flog = userTestDao.deteleUserTest(hashMap);
		int flag = userTestDao.deteleTestAnswer(hashMap);
		if(flog>0&&flag>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}

}
