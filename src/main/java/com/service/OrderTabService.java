package com.service;
/**
 * 订单表Service层接口
 * @author vip
 *
 */
public interface OrderTabService {
	/**
	 * 添加订单信息
	 * @param data
	 * @return
	 */
	public String addOrderTab(String data);
	/**
	 * 查询订单信息
	 * @param data
	 * @return
	 */
	public String queryOrderTab(String data);
	/**
	 * 更新订单信息
	 * @param data
	 * @return
	 */
	public String updateOrderTab(String data);
	/**
	 * 删除订单信息
	 * @param data
	 * @return
	 */
	public String deleteOrderTab(String data);
	/**
	 * 后端购物提交订单
	 */
	public String addOrderBack(String data);
	/**
	 * 删除未结算订单信息
	 */
	public String deleteOrderBack(String data);
	/**
	 * 后端商品结算
	 */
	public String settleOrder(String data);
	/**
	 * 商城前端查询用户个人订单详情
	 * @param data
	 * @return
	 */
	public String queryBuyerOrder(String data);
	/**
	 * 商城前端查询用户个人通过订单ID订单详情
	 * @param data
	 * @return
	 */
	public String queryBuyerOrderDetails(String data);
	
}
