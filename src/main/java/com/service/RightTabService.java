package com.service;



/**
 * 权限Service层接口
 * @author vip
 *
 */
public interface RightTabService {
	/**
	 * 添加权限
	 * @param rightTab
	 * @return
	 */
	public String addRightTab(String data);
	/**
	 * 查询权限
	 * @param hashMap
	 * @return
	 */
	public String queryRightTab(String data);
	/**
	 * 更新权限
	 * @param rightTab
	 * @return
	 */
	public String updateRightTab(String data);
	/**
	 * 删除权限
	 * @param righ_id
	 * @return
	 */
	public String deleteRightTab(String data);
}
