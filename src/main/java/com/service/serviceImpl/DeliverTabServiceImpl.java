package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.DeliverTabDao;
import com.entity.DeliverTab;
import com.service.DeliverTabService;
import com.util.Count;
import com.util.Page;
/**
 * 配送单信息Service层实体类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class DeliverTabServiceImpl implements DeliverTabService {
	@Autowired
	private DeliverTabDao deliverTabDao;//调用配送单Dao层接口
	private Logger logger = Logger.getLogger(DeliverTabServiceImpl.class);
	/**
	 * 添加配送单
	 */
	@Override
	public String addDeliverTab(String data) {
		logger.info("/addDeliverTab data: "+data);
		DeliverTab deliverTab = JSON.parseObject(data,DeliverTab.class);
		int flog = deliverTabDao.addDeliverTab(deliverTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询配送单
	 */
	@Override
	public String queryDeliverTab(String data) {
		logger.info("/queryDeliverTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = deliverTabDao.queryDeliverTab(hashMap);
		for(int i=0;i<list.size();i++) {
			list.get(i).put("change_tab", null);
		}
		int count = deliverTabDao.queryDeliverTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryDeliverTab success"));
	}
	/**
	 * 更新配送单
	 */
	@Override
	public String updateDeliverTab(String data) {
		logger.info("/updateDeliverTab data: "+data);
		DeliverTab deliverTab = JSON.parseObject(data,DeliverTab.class);
		if(null!=deliverTab.getDeli_status()&&deliverTab.getDeli_status().equals("接单")) {
			//更新订单状态
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("status", "待配送");
			map.put("deli_id",deliverTab.getDeli_id());
			deliverTabDao.updateOrder(map);
		}
		if(null!=deliverTab.getDeli_status()&&deliverTab.getDeli_status().equals("签收")) {
			//更新订单状态
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("status", "已收货");
			map.put("deli_id",deliverTab.getDeli_id());
			deliverTabDao.updateOrder(map);
		}
		int flog = deliverTabDao.updateDeliverTab(deliverTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新多条配送单签收状态
	 */
	public String updateSignDeliverTabAll(String data) {
		logger.info("/updateSignDeliverTabAll data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("deli_status","签收");
		map.put("status", "已收货");
		for(int i=0;i<list.size();i++) {
			map.put("deli_id", list.get(i));
			deliverTabDao.updateSignDeliverTabAll(map);//更新配送单信息
			deliverTabDao.updateOrder(map);
		}
		return JSON.toJSONString("success");
	}
	/**
	 * 删除配送单
	 */
	@Override
	public String deleteDeliverTab(String data) {
		logger.info("/deleteDeliverTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int deli_id = list.get(i);
			int flog = deliverTabDao.deleteDeliverTab(deli_id);
			if(flog<=0) {
				retlist.add(deli_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
