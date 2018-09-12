package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

/**
 * 分公司Dao层接口
 * @author vip
 *
 */
@Mapper
public interface BranchTabDao {
	/**
	 * 添加分公司信息
	 * @param map
	 * @return
	 */
	public int addBranchTab(HashMap<String,Object> map);
	/**
	 * 查询分公司信息
	 */
	public ArrayList<HashMap<String,Object>> queryBranchTab(HashMap<String,Object> map);
	/**
	 * 更新分公司信息
	 */
	public int updateBranchTab(HashMap<String,Object> map);
	/**
	 * 删除分公司信息
	 */
	public int deleteBranchTab(int branch_id);
}
