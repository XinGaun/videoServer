package com.service;
/**
 * 商品销售记录表Service层接口
 * @author vip
 *
 */
public interface SalesRecordTabService {
	/**
	 * 添加商品销售记录
	 * @param data
	 * @return
	 */
	public String addSalesRecordTab(String data);
	/**
	 * 查询商品销售记录
	 * @param data
	 * @return
	 */
	public String querySalesRecordTab(String data);
	/**
	 * 更新商品销售记录
	 * @param data
	 * @return
	 */
	public String updateSalesRecordTab(String data);
	/**
	 * 删除商品销售记录
	 * @param data
	 * @return
	 */
	public String deleteSalesRecordTab(String data);
}
