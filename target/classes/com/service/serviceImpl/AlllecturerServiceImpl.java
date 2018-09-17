package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.AlllecturerDao;
import com.service.AlllecturerService;
import com.util.Count;
import com.util.Page;

@Service
public class AlllecturerServiceImpl implements AlllecturerService {
	@Autowired
	private AlllecturerDao alllecturerDao;
	
	/**
	 * index查询教师信息
	 * @param data
	 * @return
	 */
	@Override
	public String queryTeacherInformation(String data) {
		HashMap<String,Object> hashmap = JSON.parseObject(data,HashMap.class);
		hashmap= Page.page(hashmap);
		ArrayList<HashMap<String,Object>> list = alllecturerDao.queryTeacherInformation(hashmap);
		int count = alllecturerDao.querycoursesTabAllCount(hashmap);
		System.out.println(count);
		return JSON.toJSONString(Count.counts(list, count, hashmap,200,"querycoursesTabAll success"));
	}

}
