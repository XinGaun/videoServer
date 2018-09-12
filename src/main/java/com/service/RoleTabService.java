package com.service;
/**
 * 角色Service层接口
 * @author vip
 *
 */
public interface RoleTabService {
	/**
	 * 添加角色
	 * @param data
	 * @return
	 */
	public String addRoleTab(String data);
	/**
	 * 查询角色
	 * @param data
	 * @return
	 */
	public String queryRoleTab(String data);
	/**
	 * 修改角色
	 * @param data
	 * @return
	 */
	public String updateRoleTab(String data);
	/**
	 * 删除角色
	 * @param data
	 * @return
	 */
	public String deleteRoleTab(String data);
}
