package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.DeliverTab;
/**
 * 配送单表Dao层实体类
 * @author vip
 *
 */
@Mapper
public interface DeliverTabDao {
	/**
	 * 添加配送单表信息
	 * @param deliverTab
	 * @return
	 */
	public int addDeliverTab(DeliverTab deliverTab);
	/**
	 * 查询配送单表信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryDeliverTab(HashMap<String,Object> hashMap);
	/**
	 * 查询配送单表总数
	 * @param hashMap
	 * @return
	 */
	public int queryDeliverTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新配送单表总数
	 * @param deliverTab
	 * @return
	 */
	public int updateDeliverTab(DeliverTab deliverTab);
	/**
	 * 更新配送单表总数
	 * @param deliverTab
	 * @return
	 */
	public int updateSignDeliverTabAll(HashMap<String,Object> hashMap);
	/**
	 * 删除配送单信息
	 * @param deli_id
	 * @return
	 */
	public int deleteDeliverTab(int deli_id);
	/**
	 * 更新订单状态
	 */
	public int updateOrder(HashMap<String,Object> hashMap);
	
}
