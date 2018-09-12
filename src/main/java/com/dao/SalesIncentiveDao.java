package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

/**
 * 销售奖励配置Dao层接口
 * @author 87518
 *
 */
@Mapper
public interface SalesIncentiveDao {
	/**
	 * 添加销售团队类型
	 * @param map
	 * @return
	 */
	public int addSalesteamTypeTab(HashMap<String,Object> map);
	/**
	 * 查询销售团队类型
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySalesteamTypeTab(HashMap<String,Object> map);
	/**
	 * 更新销售团队类型
	 * @param map
	 * @return
	 */
	public int updateSalesteamTypeTab(HashMap<String,Object> map);
	/**
	 * 删除销售团队类型
	 * @param list
	 * @return
	 */
	public int deleteSalesteamTypeTab(ArrayList<Integer> list);
	/**
	 * 添加销售团队信息
	 */
	public int addSalesteamTab(HashMap<String,Object> map);
	/**
	 * 查询销售团队信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySalesteamTab(HashMap<String,Object> map);
	/**
	 * 更新销售团队信息
	 * @param map
	 * @return
	 */
	public int updateSalesteamTab(HashMap<String,Object> map);
	/**
	 * 删除团队信息
	 * @param list
	 * @return
	 */
	public int deleteSalesteamTab(ArrayList<Integer> list);
	/**
	 * 添加团队员工
	 * @return
	 */
	public int addSalesteamStaffMiddleTab(HashMap<String,Object> map);
	/**
	 * 删除团队员工
	 * @param map
	 * @return
	 */
	public int deleteSalesteamStaffMiddleTab(ArrayList<Integer> map);
	/**
	 * 查询团队员工
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySalesteamStaffMiddleTab(HashMap<String,Object> map);
	/**
	 * 添加品类提成配置信息
	 * @param map
	 * @return
	 */
	public int addCommissionsTab(HashMap<String,Object> map);
	/**
	 * 查询品类提成配置信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCommissionsTab(HashMap<String,Object> map);
	/**
	 * 修改品类提成配置信息
	 * @param map
	 * @return
	 */
	public int updateCommissionsTab(HashMap<String,Object> map);
	/**
	 * 删除品类提成配置信息
	 * @param list
	 * @return
	 */
	public int deleteCommissionsTab(ArrayList<Integer> list);
	/**
	 * 添加考核额度
	 * @param map
	 * @return
	 */
	public int addAssessTab(HashMap<String,Object> map);
	/**
	 * 查询考核额度表
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryAssessTab(HashMap<String,Object> map);
	/**
	 * 修改考核额度表
	 * @param map
	 * @return
	 */
	public int updateAssessTab(HashMap<String,Object> map);
	/**
	 * 删除考核额度表
	 * @param list
	 * @return
	 */
	public int deleteAssessTab(ArrayList<Integer> list);
}
