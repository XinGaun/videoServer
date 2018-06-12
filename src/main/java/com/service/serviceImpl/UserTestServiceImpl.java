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
	/**
	 * 查询评价信息
	 */
	@Override
	public String queryUserTestEvaluate(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map = Page.page(map);
		ArrayList<HashMap<String,Object>> list = userTestDao.queryUserTestEvaluate(map);
		int count = userTestDao.queryUserTestEvaluateCount(map);
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryUserTestEvaluate success"));
	}
	/**
	 * 添加评价信息
	 */
	@Override
	public String addUserTestEvaluate(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		int flog = userTestDao.addUserTestEvaluate(map);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除评价信息
	 */
	@Override
	public String deleteUserTestEvaluate(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		int flog = userTestDao.deleteUserTestEvaluate(map);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新评价信息
	 */
	@Override
	public String updateUserTestEvaluate(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		int flog = userTestDao.updateUserTestEvaluate(map);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
<<<<<<< HEAD
	/**
	 * 查询分类信息
	 */
	@Override
	public String queryUserTestEvaluatetypeName() {
		ArrayList<HashMap<String,Object>> list = userTestDao.queryUserTestEvaluatetypeName();
		return JSON.toJSONString(list);
	}
	/**
	 * 按难分类查询难度信息
	 */
	@Override
	public String queryUserTestEvaluateTestGrade(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list = userTestDao.queryUserTestEvaluateTestGrade(map);
		return JSON.toJSONString(list);
	}
	/**
	 * 随机查询答案信息
	 */
	@Override
	public String queryRandomUserTestAnswer(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list = userTestDao.queryRandomUserTest(map);
		for(int i=0;i<list.size();i++) {
			HashMap<String,Object> hashmap = new HashMap<String,Object>();
			hashmap.put("test_id", list.get(i).get("test_id"));
			ArrayList<HashMap<String,Object>> lists = userTestDao.queryRandomUserTestAnswer(hashmap);
			list.get(i).put("user_test_answer", lists);
		}
		return JSON.toJSONString(list);
	}
=======
>>>>>>> 2efa35b68a8fc3b28e91f2f89e6c016868fe4040

}
