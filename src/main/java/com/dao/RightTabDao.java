package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.RightTab;

/**
 * 权限表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface RightTabDao {
	/**
	 * 添加权限
	 * @param rightTab
	 * @return
	 */
	public int addRightTab(RightTab rightTab);
	/**
	 * 查询权限
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryRightTab(HashMap<String,Object> hashMap);
	/**
	 * 查询权限总数
	 * @param hashMap
	 * @return
	 */
	public int queryRightTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新权限
	 * @param rightTab
	 * @return
	 */
	public int updateRightTab(RightTab rightTab);
	/**
	 * 删除权限
	 * @param righ_id
	 * @return
	 */
	public int deleteRightTab(int righ_id);
	/**
	 * 查询组别
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryRightGroup(HashMap<String,Object> hashMap);
}
