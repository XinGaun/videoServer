package com.service;
/**
 * 仓库信息Service层接口
 * @author vip
 *
 */
public interface WarehouseTabService {
	/**
	 * 查询仓库信息
	 * @param data
	 * @return
	 */
	public String queryWarehouseTab(String data);
	/**
	 * 添加仓库信息
	 * @param data
	 * @return
	 */
	public String addWarehouseTab(String data);
	/**
	 * 更新仓库信息
	 * @param data
	 * @return
	 */
	public String updateWarehouseTab(String data);
	/**
	 * 删除仓库信息
	 * @param data
	 * @return
	 */
	public String deleteWarehouseTab(String data);
}
