package com.service;
/**
 * 购物车Service层接口
 * @author vip
 *
 */
public interface CartTabService {
	/**
	 * 添加购物车
	 * @param data
	 * @return
	 */
	public String addCartTab(String data);
	/**
	 * 查询购物车
	 * @param data
	 * @return
	 */
	public String queryCartTab(String data);
	/**
	 * 更新购物车
	 * @param data
	 * @return
	 */
	public String updateCartTab(String data);
	/**
	 * 删除购物车
	 * @param data
	 * @return
	 */
	public String deleteCartTab(String data);
}
