package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.FinancialTabDao;
import com.entity.FinancialTab;
import com.service.FinancialTabService;
import com.util.Count;
import com.util.Page;
/**
 * 财务记录Service层接口
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class FinancialTabServiceImpl implements FinancialTabService {
	@Autowired
	private FinancialTabDao financialTabDao;//调用财务记录Dao层接口
	private Logger logger = Logger.getLogger(FinancialTabServiceImpl.class);
	/**
	 * 添加财务记录
	 */
	@Override
	public String addFinancialTab(String data) {
		logger.info("/addFinancialTab data: "+data);
		FinancialTab financialTab = JSON.parseObject(data, FinancialTab.class);
		int flog = financialTabDao.addFinancialTab(financialTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询财务记录
	 */
	@Override
	public String queryFinancialTab(String data) {
		logger.info("/queryFinancialTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> arrayList = financialTabDao.queryFinancialTab(hashmap);
		int count = financialTabDao.queryFinancialTabCount(hashmap);
		arrayList = Count.count(arrayList, count, hashmap);
		return JSON.toJSONString(Count.counts(arrayList, count, hashmap,200,"success"));
	}
	/**
	 * 更新财务记录
	 */
	@Override
	public String updateFinancialTab(String data) {
		logger.info("/updateFinancialTab data: "+data);
		FinancialTab financialTab = JSON.parseObject(data, FinancialTab.class);
		int flog = financialTabDao.updateFinancialTab(financialTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除财务记录
	 */
	@Transactional
	public String deleteFinancialTab(String data) {
		logger.info("/deleteFinancialTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int fina_id = list.get(i);
			int flog = financialTabDao.deleteFinancialTab(fina_id);
			if(flog<=0) {
				retlist.add(fina_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
