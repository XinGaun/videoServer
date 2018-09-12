package com.service;
/**
 * 缺货登记表Service层接口
 * @author vip
 *
 */
public interface WantTabService {
	/**
	 * 添加缺货登记表信息
	 * @param data
	 * @return
	 */
	public String addWantTab(String data);
	/**
	 * 查询缺货登记表信息
	 * @param data
	 * @return
	 */
	public String queryWantTab(String data);
	/**
	 * 更新缺货登记表信息
	 * @param data
	 * @return
	 */
	public String updateWantTab(String data);
	/**
	 * 删除缺货登记表信息
	 * @param data
	 * @return
	 */
	public String deleteWantTab(String data);
	/**
	 * 根据缺货登记ID生成采购需求
	 */
	public String generatePurchase(String data);
}
