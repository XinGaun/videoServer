package com.service.serviceImpl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.AabDao;
import com.entity.Aab;
import com.service.AabService;
@Service
public class AabServiceImpl implements AabService {
	@Autowired
	private AabDao aabDao;
	@Override
	public String queryAab() {
		// TODO Auto-generated method stub
		ArrayList<Aab> arrayList = aabDao.queryAab();
		return JSON.toJSONString(arrayList);
	}

}
