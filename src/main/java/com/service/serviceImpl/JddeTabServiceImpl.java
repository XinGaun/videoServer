package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.JddeTabDao;
import com.entity.JddeTab;
import com.service.JddeTabService;
import com.util.Count;
import com.util.Page;
/**
 * 配送单位Service层接口
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class JddeTabServiceImpl implements JddeTabService {
	@Autowired
	private JddeTabDao jddeTabDao;//调用配送单位Dao层接口
	private Logger logger = Logger.getLogger(JddeTabServiceImpl.class);
	/**
	 * 添加配送单位
	 */
	@Override
	public String addJddeTab(String data) {
		logger.info("/addJddeTab data: "+data);
		JddeTab jddeTab = JSON.parseObject(data, JddeTab.class);
		int flog =jddeTabDao.addJddeTab(jddeTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询配送单位
	 */
	@Override
	public String queryJddeTab(String data) {
		logger.info("/queryJddeTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = jddeTabDao.queryJddeTab(hashMap);
		int count = jddeTabDao.queryJddeTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryJddeTab success"));
	}
	/**
	 * 更新配送单位
	 */
	@Override
	public String updateJddeTab(String data) {
		logger.info("/updateJddeTab data: "+data);
		JddeTab jddeTab = JSON.parseObject(data, JddeTab.class);
		int flog =jddeTabDao.updateJddeTab(jddeTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除配送单位信息
	 */
	@Transactional
	public String deleteJddeTab(String data) {
		logger.info("/deleteJddeTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int jdde_id = list.get(i);
			int flog = jddeTabDao.deleteJddeTab(jdde_id);
			if(flog<=0) {
				retlist.add(jdde_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
