package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.opinionDao;
import com.service.opinionService;

@Service
public class opinionServerImpl implements opinionService{
	@Autowired
	private opinionDao opiniondao;
	
	/**
	 * 查询所有
	 */
	@Override
	public String queryOpinionAll(String data) {
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> opinionList = opiniondao.queryOpinionAll(hashmap);
		int total = opiniondao.queryOpinionTabCount(hashmap);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("data", opinionList);
		result.put("limit", Integer.parseInt(hashmap.get("limit").toString()));
		result.put("total", total);
		result.put("page", Integer.parseInt(hashmap.get("page").toString()));
		return JSON.toJSONString(result);
	}
	
	/**
	 * 删除订单信息
	 */
	@Transactional
	public String deleteOpinionTab(String data) {
		ArrayList<String> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			int opinion_id = Integer.parseInt(list.get(i));
			int flog = opiniondao.deleteOpinionTab(opinion_id);
			if(flog<=0) {
				retlist.add(opinion_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
