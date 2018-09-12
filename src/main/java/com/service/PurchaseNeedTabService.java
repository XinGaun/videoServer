package com.service;





/**
 * 采购需求单Service层接口
 * @author vip
 *
 */
public interface PurchaseNeedTabService {
	/**
	 * 添加采购需求
	 * @param data
	 * @return
	 */
	public String addPurchaseNeedTab(String data);
	/**
	 * 查询采购需求
	 * @param data
	 * @return
	 */
	public String queryPurchaseNeedTab(String data);
	/**
	 * 更新采购需求
	 * @param data
	 * @return
	 */
	public String updatePurchaseNeedTab(String data);
	/**
	 * 删除采购需求
	 * @param data
	 * @return
	 */
	public String deletePurchaseNeedTab(String data);

}
