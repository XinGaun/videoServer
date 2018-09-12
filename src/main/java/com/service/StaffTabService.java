package com.service;
/**
 * 员工信息Service层接口
 * @author vip
 *
 */
public interface StaffTabService {
	/**
	 * 添加员工信息
	 * @param data
	 * @return
	 */
	public String addStaffTab(String data);
	/**
	 * 查询员工信息
	 * @param data
	 * @return
	 */
	public String queryStaffTab(String data);
	/**
	 * 更新员工信息
	 * @param data
	 * @return
	 */
	public String updateStaffTab(String data);
	/**
	 * 删除员工信息
	 * @param data
	 * @return
	 */
	public String deleteStaffTab(String data);
	/**
	 * 验证登录信息
	 */
	public String loginStaff(String data);
}
