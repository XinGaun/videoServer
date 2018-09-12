package com.service;
/**
 * 总实例推送信息Service层接口
 * @author vip
 *
 */
public interface BranchesReceiveService {
	/**
	 * 添加推送的商品信息
	 * @param data
	 * @return
	 */
	public String addPushCommodity(String data);
	/**
	 * 更新推送商品的信息
	 * @param data
	 * @return
	 */
	public String updatePushCommodity(String data);
	/**
	 * 删除推送商品的信息
	 * @param data
	 * @return
	 */
	public String deletePushCommodity(String data);
	/**
	 * 添加总实例推送品类信息
	 * @param data
	 * @return
	 */
	public String addPushCategory(String data);
	/**
	 * 更新总实例推送品类信息 
	 */
	public String updatePushCategory(String data);
	/**
	 * 添加总实例推送的商品规格信息
	 * @param data
	 * @return
	 */
	public String addPushSpecifications(String data);
	/**
	 * 更新总实例推送的商品规格信息
	 * @param data
	 * @return
	 */
	public String updatePushSpecifications(String data);
	/**
	 * 添加总实例推送的供应商信息
	 * @param data
	 * @return
	 */
	public String addPushSupplier(String data);
	/**
	 * 更新总实例推送的供应商信息
	 * @param data
	 * @return
	 */
	public String updatePushSupplier(String data);
	/**
	 * 添加总实例推送的品牌信息
	 * @param data
	 * @return
	 */
	public String addPushBrand(String data);
	/**
	 * 更新总实例推送的品牌信息
	 * @param data
	 * @return
	 */
	public String updatePushBrand(String data);

}
