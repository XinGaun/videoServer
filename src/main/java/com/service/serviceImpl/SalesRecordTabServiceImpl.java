package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CommodityTabDao;
import com.dao.OrderTabDao;
import com.dao.SalesRecordTabDao;
import com.entity.SalesRecordTab;
import com.service.SalesRecordTabService;
import com.util.Count;
import com.util.Page;
/**
 * 商品销售记录表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class SalesRecordTabServiceImpl implements SalesRecordTabService {
	@Autowired
	private SalesRecordTabDao recordTabDao;//调用商品销售记录Dao层接口
	@Autowired
	private OrderTabDao orderTabDao;//调用订单Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	private Logger logger = Logger.getLogger(SalesRecordTabServiceImpl.class);
	/**
	 * 添加商品销售记录
	 */
	@Override
	public String addSalesRecordTab(String data) {
		logger.info("/addSalesRecordTab data: "+data);
		HashMap<String,Object> salesRecordTab = JSON.parseObject(data, HashMap.class);
		int flog = recordTabDao.addSalesRecordTab(salesRecordTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询商品销售记录
	 */
	@Override
	public String querySalesRecordTab(String data) {
		logger.info("/querySalesRecordTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> arrayList = recordTabDao.querySalesRecordTab(hashmap);
		for(int i=0;i<arrayList.size();i++) {
			ArrayList<HashMap<String,Object>> order = orderTabDao.queryOrderTab(arrayList.get(i));
			arrayList.get(i).put("comm_putaway_id",arrayList.get(i).get("comm_id"));
			arrayList.get(i).put("comm_id", null);
			ArrayList<HashMap<String,Object>> commodity = commodityTabDao.queryCommodityTab(arrayList.get(i));
			arrayList.get(i).put("order", order);
			arrayList.get(i).put("commodity", commodity);
		}
		int count = recordTabDao.querySalesRecordTabCount(hashmap);
		//arrayList = Count.count(arrayList, count, hashmap);
		return JSON.toJSONString(Count.counts(arrayList, count, hashmap,200,"querySalesRecordTab success"));
	}
	/**
	 * 修改商品销售记录
	 */
	@Override
	public String updateSalesRecordTab(String data) {
		logger.info("/updateSalesRecordTab data: "+data);
		SalesRecordTab salesRecordTab = JSON.parseObject(data, SalesRecordTab.class);
		int flog = recordTabDao.updateSalesRecordTab(salesRecordTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除商品销售记录
	 */
	@Transactional
	public String deleteSalesRecordTab(String data) {
		logger.info("/deleteSalesRecordTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int sale_id = list.get(i);
			int flog = recordTabDao.deleteSalesRecordTab(sale_id);
			if(flog<=0) {
				retlist.add(sale_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
