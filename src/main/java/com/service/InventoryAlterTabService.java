package com.service;


/**
 * 库存变更表Service层接口
 * @author vip
 *
 */
public interface InventoryAlterTabService {
	/**
	 * 添加库存变更信息
	 * @param data
	 * @return
	 */
	public String addInventoryAlterTab(String data);
	/**
	 * 查询库存变更信息
	 * @param data
	 * @return
	 */
	public String queryInventoryAlterTab(String data);
	/**
	 * 更新库存变更信息
	 * @param data
	 * @return
	 */
	public String updateInventoryAlterTab(String data);
	/**
	 * 删除库存变更信息
	 * @param data
	 * @return
	 */
	public String deleteInventoryAlterTab(String data);
}
