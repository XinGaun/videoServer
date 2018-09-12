package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.StaffLogTab;
/**
 * 员工日志Dao层接口
 * @author vip
 *
 */
@Mapper
public interface StaffLogTabDao {
	/**
	 * 添加员工日志信息
	 * @param logTab
	 * @return
	 */
	public int addStaffLogTab(StaffLogTab logTab);
	/**
	 * 查询员工日志信息
	 * @param logTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryStaffLogTab(HashMap<String,Object> hashMap);
	/**
	 * 查询员工日志信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryStaffLogTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新员工日志信息
	 * @param logTab
	 * @return
	 */
	public int updateStaffLogTab(StaffLogTab logTab);
	/**
	 * 删除员工日志信息
	 * @param logTab
	 * @return
	 */
	public int deleteStaffLogTab(int staff_log_id);
}
