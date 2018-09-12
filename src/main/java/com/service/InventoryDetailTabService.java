package com.service;
/**
 * 库存明细表Service层接口
 * @author vip
 *
 */
public interface InventoryDetailTabService {
	/**
	 * 添加库存明细信息
	 * @param data
	 * @return
	 */
	public String addInventoryDetailTab(String data);
	/**
	 * 查询库存明细信息
	 * @param data
	 * @return
	 */
	public String queryInventoryDetailTab(String data);
	/**
	 * 修改库存明细信息
	 * @param data
	 * @return
	 */
	public String updateInventoryDetailTab(String data);
	/**
	 * 删除库存明细信息
	 * @param data
	 * @return
	 */
	public String deleteInventoryDetailTab(String data);
	/**
	 * 根据商品ID查询库存明细信息
	 * @param data
	 * @return
	 */
	public String queryDeliIdInventoryDetailTab(String data);
	/**
	 * 采购入库
	 * @return
	 */
	public String purchaseAccess(String data);

}
