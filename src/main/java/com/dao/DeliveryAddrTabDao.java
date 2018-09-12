package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.BuyerTab;
import com.entity.DeliveryAddrTab;

/**
 * 配送地址Dao层接口
 * @author vip
 *
 */
@Mapper
public interface DeliveryAddrTabDao {
	/**
	 * 添加配送地址
	 * @param addrTab
	 * @return
	 */
	public int addDeliveryAddrTab(DeliveryAddrTab addrTab);
	/**
	 * 查询配送地址
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryDeliveryAddrTab(HashMap<String,Object> map);
	/**
	 * 查询配送地址总数
	 * @param map
	 * @return
	 */
	public int queryDeliveryAddrTabCount(HashMap<String,Object> map);
	/**
	 * 更新配送地址
	 * @param addrTab
	 * @return
	 */
	public int updateDeliveryAddrTab(DeliveryAddrTab addrTab);
	/**
	 * 删除配送地址
	 * @param deli_addr_id
	 * @return
	 */
	public int deleteDeliveryAddrTab(int deli_addr_id);
	/**
	 * 根据买家ID删除配置地址信息
	 * @param map
	 * @return
	 */
	public int deleteDeliveryAddrBuyeID(BuyerTab map);
}
