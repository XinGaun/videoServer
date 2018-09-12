package com.service;
/**
 * 出库单Service层接口
 * @author vip
 *
 */
public interface ComeWarehouseTabService {
	/**
	 * 添加出库单
	 * @param data
	 * @return
	 */
	public String addComeWarehouseTab(String data);
	/**
	 * 查询出库单
	 * @param data
	 * @return
	 */
	public String queryComeWarehouseTab(String data);
	/**
	 * 更新出库单
	 * @param data
	 * @return
	 */
	public String updateComeWarehouseTab(String data);
	/**
	 * 删除出库单
	 * @param data
	 * @return
	 */
	public String deleteComeWarehouseTab(String data);
	/**
	 * 出库
	 */
	public String departLibrary(String data);
	
}
