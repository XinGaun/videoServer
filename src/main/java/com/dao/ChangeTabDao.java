package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.ChangeTab;
/**
 * 退换货单表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface ChangeTabDao {
	/**
	 * 添加退换货单
	 * @param changeTab
	 * @return
	 */
	public int addChangeTab(ChangeTab changeTab);
	/**
	 * 查询退换货单
	 * @param changeTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryChangeTab(HashMap<String,Object> hashMap);
	/**
	 * 查询退换货单总数
	 * @param changeTab
	 * @return
	 */
	public int queryChangeTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新退换货单
	 * @param changeTab
	 * @return
	 */
	public int updateChangeTab(ChangeTab changeTab);
	/**
	 * 删除退换货单
	 * @param changeTab
	 * @return
	 */
	public int deleteChangeTab(int chan_id);
	/**
	 * 订单ID 查询退换货信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryChangeOrderId(HashMap<String,Object> map);
	/**
	 * 更新相关商品销售记录
	 */
	public int updateSalesRecordTab(HashMap<String,Object> Map);
	/**
	 * 根据退换货ID查询商品销售信息
	 */
	public ArrayList<HashMap<String,Object>> querySale(HashMap<String,Object> map);
	/**
	 * 通过商品ID查询商品销售记录
	 */
	public ArrayList<HashMap<String,Object>> querySaleOrdeID(HashMap<String,Object> map);
}
