package com.service;



/**
 * 配送地址Service层接口
 * @author vip
 *
 */
public interface DeliveryAddrTabService {
	/**
	 * 添加配置地址
	 * @param addrTab
	 * @return
	 */
	public String addDeliveryAddrTab(String data);
	/**
	 * 查询配置地址
	 * @param data
	 * @return
	 */
	public String queryDeliveryAddrTab(String data);
	/**
	 * 更新配置地址
	 * @param data
	 * @return
	 */
	public String updateDeliveryAddrTab(String data);
	/**
	 * 删除配置地址
	 * @param data
	 * @return
	 */
	public String deleteDeliveryAddrTab(String data);
	/**
	 * 同步19挺配置地址信息
	 */
	public String synchronizationAddr(String data);
	/**
	 * 增加买家地址信息
	 */
	public String addBuyersaddress(String data);
}
