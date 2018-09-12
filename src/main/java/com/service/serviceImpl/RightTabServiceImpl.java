package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.RightTabDao;
import com.entity.RightTab;
import com.service.RightTabService;
import com.util.Count;

/**
 * 权限Service层实现类
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class RightTabServiceImpl implements RightTabService {
	@Autowired
	private RightTabDao rightTabDao;//调用权限Service层接口
	private Logger logger = Logger.getLogger(RightTabServiceImpl.class);
	/**
	 * 添加权限
	 */
	@Override
	public String addRightTab(String data) {
		logger.info("/addRightTab data: "+data);
		RightTab rightTab = JSON.parseObject(data,RightTab.class);
		int folg = rightTabDao.addRightTab(rightTab);
		if(folg>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询权限
	 */
	@Override
	public String queryRightTab(String data) {
		logger.info("/queryRightTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> arrayList = rightTabDao.queryRightGroup(hashmap);
		for(int i=0;i<arrayList.size();i++) {
			ArrayList<HashMap<String,Object>> list = rightTabDao.queryRightTab(arrayList.get(i));
			arrayList.get(i).put("list", list);
		}
		return JSON.toJSONString(Count.counts(arrayList,-1, hashmap, 200, "queryRightTab success"));
	}
	/**
	 * 更新权限
	 */
	@Override
	public String updateRightTab(String data) {
		logger.info("/updateRightTab data: "+data);
		RightTab rightTab = JSON.parseObject(data,RightTab.class);
		int flog = rightTabDao.updateRightTab(rightTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除权限
	 */
	@Transactional
	public String deleteRightTab(String data) {
		logger.info("/deleteRightTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int righ_id = list.get(i);
			int flog = rightTabDao.deleteRightTab(righ_id);
			if(flog<=0) {
				retlist.add(righ_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
