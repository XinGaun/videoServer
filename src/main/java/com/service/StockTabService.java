package com.service;


/**
 * 库存量信息Service层接口
 * @author vip
 *
 */
public interface StockTabService {
	/**
	 * 添加库存量信息
	 * @param data
	 * @return
	 */
	public String addStockTab(String data);
	/**
	 * 查询库存量信息
	 * @param data
	 * @return
	 */
	public String queryStockTab(String data);
	/**
	 * 更新库存量信息
	 * @param data
	 * @return
	 */
	public String updateStockTab(String data);
	
}
