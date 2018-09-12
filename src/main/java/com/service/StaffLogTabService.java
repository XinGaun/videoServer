package com.service;


/**
 * 员工日志Service层接口
 * @author vip
 *
 */
public interface StaffLogTabService {
	/**
	 * 添加员工日志
	 * @param data
	 * @return
	 */
	public String addStaffLogTab(String data);
	/**
	 * 查询员工日志
	 * @param data
	 * @return
	 */
	public String queryStaffLogTab(String data);
	/**
	 * 更新员工日志
	 * @param data
	 * @return
	 */
	public String updateStaffLogTab(String data);
	/**
	 * 删除员工日志
	 * @param data
	 * @return
	 */
	public String deleteStaffLogTab(String data);
}
