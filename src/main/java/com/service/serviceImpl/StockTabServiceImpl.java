package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.CommodityTabDao;
import com.dao.StockTabDao;
import com.dao.WarehouseTabDao;
import com.entity.StockTab;
import com.service.StockTabService;
import com.util.Count;
import com.util.Page;
/**
 * 库存量表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class StockTabServiceImpl implements StockTabService {
	@Autowired
	private StockTabDao stockTabDao;//调用库存量表Dao层接口
	@Autowired
	private WarehouseTabDao warehouseTabDao;//调用仓库Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	private Logger logger = Logger.getLogger(StockTabServiceImpl.class);
	/**
	 * 添加库存量信息
	 */
	@Override
	public String addStockTab(String data) {
		logger.info("/addStockTab data: "+data);
		StockTab stockTab = JSON.parseObject(data, StockTab.class);
		int flog = stockTabDao.addStockTab(stockTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询库存量信息
	 */
	@Override
	public String queryStockTab(String data) {
		logger.info("/queryStockTab data: "+data);
		logger.info("/queryCategoryTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = stockTabDao.queryStockTab(hashMap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> wareMap = warehouseTabDao.queryWarehouseTab(list.get(i));
			list.get(i).put("comm_putaway_id", list.get(i).get("comm_id"));
			list.get(i).put("comm_id", null);
			ArrayList<HashMap<String,Object>> commMap = commodityTabDao.queryCommodityTab(list.get(i));
			list.get(i).put("warehouse", wareMap);
			list.get(i).put("Commodity", commMap);
		}
		int count = stockTabDao.queryStockTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"success"));
	}
	/**
	 * 更新库存量信息
	 */
	@Override
	public String updateStockTab(String data) {
		logger.info("/updateStockTab data: "+data);
		StockTab stockTab = JSON.parseObject(data, StockTab.class);
		int flog = stockTabDao.updateStockTab(stockTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}

}
