package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.StaffTab;
/**
 * 员工信息Dao层接口
 * @author vip
 *
 */
@Mapper
public interface StaffTabDao {
	/**
	 * 添加员工信息
	 * @param staffTab
	 * @return
	 */
	public int addStaffTab(StaffTab staffTab);
	/**
	 * 查询员工信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryStaffTab(HashMap<String,Object> hashMap);
	/**
	 * 查询员工信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryStaffTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新员工信息
	 * @param staffTab
	 * @return
	 */
	public int updateStaffTab(StaffTab staffTab);
	/**
	 * 删除员工信息
	 * @param staf_id
	 * @return
	 */
	public int deleteStaffTab(Integer staf_id);
}
