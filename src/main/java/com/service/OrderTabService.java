package com.service;

import java.util.ArrayList;
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
	public HashMap<String,Object> queryOrderTab(HashMap<String,Object> hashMap);
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
	/**
	 * 查询订单信息
	 * @param data
	 * @return
	 */
	public String queryOrderTabAll(String data);
	/**
	 * 查询订单是否存在
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryOrderExist(HashMap<String,Object> map);
}
