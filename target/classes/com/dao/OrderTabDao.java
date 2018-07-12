package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 订单表Dao层接口
 * @author vip
 *
 */
public interface OrderTabDao {
	/**
	 * 添加订单信息
	 * @param hashMap
	 * @return
	 */
	public int addOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 查询订单信息
	 * @param hashMap
	 * @return
	 */
	public int queryOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 查询订单信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryOrderTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新订单信息
	 * @param hashMap
	 * @return
	 */
	public int updateOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 删除订单信息
	 * @param order_id
	 * @return
	 */
	public int deleteOrderTab(int order_id);
	/**
	 * 查询订单总数信息
	 * @param hashmap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryOrderTabAll(HashMap<String,Object> hashmap);
	/**
	 * 查询订单是否存在
	 */
	public ArrayList<HashMap<String,Object>> queryOrderExist(HashMap<String,Object> map);
}
