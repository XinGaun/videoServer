package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.OrderTabDao;
import com.service.OrderTabService;
import com.util.Outputsystem;
/**
 * 订单Service实现类
 * @author vip
 *
 */
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
	@Override
	public String deleteOrderTab(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String queryOrderTabAll(String data) {
		System.out.println(data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> orderList = orderTabDao.queryOrderTabAll(hashmap);
		
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		HashMap<String,Object> hashmap2 = new HashMap<String,Object>();
		hashmap2.put("Id",1);
		hashmap2.put("Name","asda");
		hashmap2.put("Sex","asdssssa");
		list.add(hashmap2);
		HashMap<String,Object> has = new HashMap<>();
		has.put("data", orderList);
		has.put("limit", 10);
		has.put("total", orderList.size());
		has.put("page", 1);
		
		System.out.println(JSON.toJSONString(orderList));
		return JSON.toJSONString(has);
	}

}
