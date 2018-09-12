package com.service;
/**
 * 买家信息Service层接口
 * @author vip
 *
 */
public interface BuyerTabService {
	/**
	 * 添加买家信息
	 * @param data
	 * @return
	 */
	public String addBuyerTab(String data);
	/**
	 * 查询买家信息
	 * @param data
	 * @return
	 */
	public String queryBuyerTab(String data);
	/**
	 * 更新买家信息
	 * @param data
	 * @return
	 */
	public String updateBuyerTab(String data);
	/**
	 * 删除买家信息
	 * @param date
	 * @return
	 */
	public String deleteBuyerTab(String data);
}
