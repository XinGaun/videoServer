package com.service;
/**
 * 采购单Service层接口
 * @author vip
 *
 */
public interface PurchaseTabService {
	/**
	 * 添加采购单
	 * @param data
	 * @return
	 */
	public String addPurchaseTab(String data);
	/**
	 * 查询采购单
	 * @param data
	 * @return
	 */
	public String queryPurchaseTab(String data);
	/**
	 * 更新采购单
	 * @param data
	 * @return
	 */
	public String updatePurchaseTab(String data);
	/**
	 * 删除采购单
	 * @param data
	 * @return
	 */
	public String deletePurchaseTab(String data);
}
