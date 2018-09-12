package com.service;
/**
 * 门店信息Service层接口
 * @author vip
 *
 */
public interface ShopTabService {
	/**
	 * 添加门店信息
	 * @param data
	 * @return
	 */
	public String addShopTab(String data);
	/**
	 * 查询门店信息
	 * @return
	 */
	public String queryShopTab(String data);
	/**
	 * 更新门店信息
	 * @param data
	 * @return
	 */
	public String updateShopTab(String data);
	/**
	 * 删除门店信息
	 * @param data
	 * @return
	 */
	public String deleteShopTab(String data);
}
