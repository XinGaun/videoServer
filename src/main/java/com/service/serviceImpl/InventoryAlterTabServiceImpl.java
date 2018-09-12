package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.InventoryAlterTabDao;
import com.entity.InventoryAlterTab;
import com.service.InventoryAlterTabService;
import com.util.Count;
import com.util.Page;
/**
 * 库存变更表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class InventoryAlterTabServiceImpl implements InventoryAlterTabService {
	@Autowired
	private InventoryAlterTabDao inventoryAlterTabDao;//调用库存变更Dao层接口
	private Logger logger = Logger.getLogger(InventoryAlterTabServiceImpl.class);
	/**
	 * 添加库存变更信息
	 */
	@Override
	public String addInventoryAlterTab(String data) {
		logger.info("/addInventoryAlterTab data: "+data);
		InventoryAlterTab inventoryAlterTab = JSON.parseObject(data, InventoryAlterTab.class);
		int flog = inventoryAlterTabDao.addInventoryAlterTab(inventoryAlterTab);
		if(flog > 0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询库存变更信息
	 */
	@Override
	public String queryInventoryAlterTab(String data) {
		logger.info("/queryInventoryAlterTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = inventoryAlterTabDao.queryInventoryAlterTab(hashMap);
		int count = inventoryAlterTabDao.queryInventoryAlterTabCount(hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryInventoryAlterTab success"));
	}
	/**
	 * 更新库存变更信息
	 */
	@Override
	public String updateInventoryAlterTab(String data) {
		logger.info("/updateInventoryAlterTab data: "+data);
		InventoryAlterTab inventoryAlterTab = JSON.parseObject(data, InventoryAlterTab.class);
		int flog = inventoryAlterTabDao.updateInventoryAlterTab(inventoryAlterTab);
		if(flog > 0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除库存变更信息
	 */
	@Transactional
	public String deleteInventoryAlterTab(String data) {
		logger.info("/deleteInventoryAlterTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int inve_alter_id = list.get(i);
			int flog = inventoryAlterTabDao.deleteInventoryAlterTab(inve_alter_id);
			if(flog<=0) {
				retlist.add(inve_alter_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
