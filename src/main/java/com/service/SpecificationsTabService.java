package com.service;
/**
 * 商品规格Service层接口
 * @author vip
 *
 */
public interface SpecificationsTabService {
	/**
	 * 添加商品规格信息
	 * @param data
	 * @return
	 */
	public String addSpecificationsTab(String data);
	/**
	 * 查询商品规格信息
	 * @param data
	 * @return
	 */
	public String querySpecificationsTab(String data);
	/**
	 * 更新商品规格信息
	 * @param data
	 * @return
	 */
	public String updateSpecificationsTab(String data);
	/**
	 * 删除商品规格信息
	 * @param date
	 * @return
	 */
	public String deleteSpecificationsTab(String data);
	/**
	 * 总实例添加商品规格
	 * @param data
	 * @return
	 */
	public String addPushSpecificationsTab(String data);
	/**
	 * 总实例更新商品规格
	 */
	public String updatePushSpecificationsTab(String data);
}
