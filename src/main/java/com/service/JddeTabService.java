package com.service;


/**
 * 配送单位Service层接口
 * @author vip
 *
 */
public interface JddeTabService {
	/**
	 * 添加配送单位
	 * @param jddeTab
	 * @return
	 */
	public String addJddeTab(String data);
	/**
	 * 查询配送单位
	 * @param data
	 * @return
	 */
	public String queryJddeTab(String data);
	/**
	 * 更新配送单位
	 * @param data
	 * @return
	 */
	public String updateJddeTab(String data);
	/**
	 * 删除配送单位信息
	 * @param data
	 * @return
	 */
	public String deleteJddeTab(String data);
}
