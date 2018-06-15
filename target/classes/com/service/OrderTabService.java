package com.service;

import java.util.HashMap;

/**
 * 订单Service层接口
 * @author vip
 *
 */
public interface OrderTabService {
	/**
	 *  添加订单
	 * @param data
	 * @return
	 */
	public String addOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 查询订单
	 * @param data
	 * @return
	 */
	public int queryOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 更新订单
	 * @param data
	 * @return
	 */
	public String updateOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 删除订单
	 * @param data
	 * @return
	 */
	public String deleteOrderTab(String data);
	public String queryOrderTabAll(String data);
}
