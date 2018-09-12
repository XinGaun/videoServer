package com.service;
/**
 * 配送单表Service层接口
 * @author vip
 *
 */
public interface DeliverTabService {
	/**
	 * 添加配送单
	 * @param data
	 * @return
	 */
	public String addDeliverTab(String data);
	/**
	 * 查询配送单
	 * @param data
	 * @return
	 */
	public String queryDeliverTab(String data);
	/**
	 * 更新配送单
	 * @param data
	 * @return
	 */
	public String updateDeliverTab(String data);
	/**
	 * 更新多条配送单签收状态
	 */
	public String updateSignDeliverTabAll(String data) ;
	/**
	 * 删除配送单
	 * @param data
	 * @return
	 */
	public String deleteDeliverTab(String data);
}
