package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.RoleTab;
/**
 * 角色Dao层接口
 * @author vip
 *
 */
@Mapper
public interface RoleTabDao {
	/**
	 * 添加角色
	 * @param roleTab
	 * @return
	 */
	public int addRoleTab(RoleTab roleTab);
	/**
	 * 查询角色
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryaddRole(HashMap<String,Object> map);
	/**
	 * 查询角色总数
	 * @param map
	 * @return
	 */
	public int queryaddRoleCount(HashMap<String,Object> map);
	/**
	 * 修改角色
	 * @param roleTab
	 * @return
	 */
	public int updateRole(RoleTab roleTab);
	/**
	 * 删除角色
	 */
	public int deleteRole(int role_id);
}
