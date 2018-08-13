package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.OrderTabDao;
import com.service.OrderTabService;
import com.util.Outputsystem;
/**
 * 订单Service实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class OrderTabServiceImpl implements OrderTabService {
	@Autowired
	private OrderTabDao orderTabDao;//调用订单Dao层接口
	/**
	 * 添加订单信息
	 */
	@Override
	public String addOrderTab(HashMap<String,Object> hashMap) {
		hashMap.put("order_id",-1);
		int flog = orderTabDao.addOrderTab(hashMap);
		Outputsystem.sysTemOut(hashMap.get("order_id").toString());
		if(flog>0) {
			return "success";
		}
		return "error";
	}
	/**
	 * 查询订单信息
	 */
	@Override
	public int queryOrderTab(HashMap<String,Object> hashMap) {
		int flog =orderTabDao.queryOrderTab(hashMap);
		
		return flog;
	}
	/**
	 * 修改订单信息
	 */
	@Override
	public String updateOrderTab(HashMap<String,Object> hashMap) {
		int flog = orderTabDao.updateOrderTab(hashMap);
		if(flog>0) {
			return "success";
		} 
		return "error";
	}
	/**
	 * 删除订单信息
	 */
	@Transactional
	public String deleteOrderTab(String data) {
		ArrayList<String> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			int order_id = Integer.parseInt(list.get(i));
			int flog = orderTabDao.deleteOrderTab(order_id);
			if(flog<=0) {
				retlist.add(order_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 查询所有订单信息
	 */
	@Override
	public String queryOrderTabAll(String data) {
		//System.out.println(data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> orderList = orderTabDao.queryOrderTabAll(hashmap);
		int total = orderTabDao.queryOrderTabCount(hashmap);
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("data", orderList);
		result.put("limit", Integer.parseInt(hashmap.get("limit").toString()));
		result.put("total", total);
		result.put("page", Integer.parseInt(hashmap.get("page").toString()));
		
		//System.out.println(JSON.toJSONString(result));
		return JSON.toJSONString(result);
	}
	/**
	 * 查询订单是否存在
	 */
	@Override
	public ArrayList<HashMap<String, Object>> queryOrderExist(HashMap<String, Object> map) {
		
		return orderTabDao.queryOrderExist(map);
	}

}
