package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.ShopTabDao;
import com.dao.WarehouseTabDao;
import com.entity.WarehouseTab;
import com.service.WarehouseTabService;
import com.util.Count;
import com.util.Page;

/**
 *  仓库Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class WarehouseTabServiceImpl implements WarehouseTabService{
	@Autowired
	private WarehouseTabDao warehouseTabDao;//调用仓库Dao层接口
	@Autowired
	private ShopTabDao shopTabDao;//调用门店Dao层接口
	private Logger logger = Logger.getLogger(WarehouseTabServiceImpl.class);
	/**
	 * 查询仓库信息
	 */
	@Override
	public String queryWarehouseTab(String data) {
		logger.info("/queryWarehouseTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> list = warehouseTabDao.queryWarehouseTab(hashmap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> shop = shopTabDao.queryShopTab(list.get(i));
			list.get(i).put("shop", shop);
			if(list.get(i).containsKey("ware_superior")) {
				HashMap<String,Object> hash = warehouseTabDao.queryWarehousetop(list.get(i));
				list.get(i).put("ware_superior_tab", hash);
			}
		}
		int count = warehouseTabDao.queryWarehouseTabCount(hashmap);
		//list = Count.count(list, count, hashmap);
		return JSON.toJSONString(Count.counts(list, count, hashmap,200,"queryWarehouseTab success"));
	}
	/**
	 * 添加仓库信息
	 */
	@Override
	public String addWarehouseTab(String data) {
		logger.info("/addWarehouseTab data: "+data);
		WarehouseTab warehouseTab = JSON.parseObject(data, WarehouseTab.class);
		int flog = warehouseTabDao.addWarehouseTab(warehouseTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新仓库信息
	 */
	@Override
	public String updateWarehouseTab(String data) {
		logger.info("/updateWarehouseTab data: "+data);
		WarehouseTab warehouseTab = JSON.parseObject(data, WarehouseTab.class);
		int flog = warehouseTabDao.updateWarehouseTab(warehouseTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除仓库信息
	 */
	@Transactional
	public String deleteWarehouseTab(String data) {
		logger.info("/deleteWarehouseTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int ware_id = list.get(i);
			int flog = warehouseTabDao.deleteWarehouseTab(ware_id);
			if(flog<=0) {
				retlist.add(ware_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	
}
