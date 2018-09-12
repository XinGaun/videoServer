package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.PurchaseTab;
/**
 * 采购单Dao层接口
 * @author vip
 *
 */
@Mapper
public interface PurchaseTabDao {
	/**
	 * 添加采购单信息
	 * @param purchaseTab
	 * @return
	 */
	public int addPurchaseTab(HashMap<String,Object> purchaseTab);
	/**
	 * 查询采购单信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryPurchaseTab(HashMap<String,Object> hashMap);
	/**
	 * 查询采购单总数信息
	 * @param hashMap
	 * @return
	 */
	public int queryPurchaseTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新采购单信息
	 * @param purchaseTab
	 * @return
	 */
	public int updatePurchaseTab(PurchaseTab purchaseTab);
	/**
	 * 删除采购单信息
	 * @param purc_id
	 * @return
	 */
	public int deletePurchaseTab(int purc_id);
	/**
	 * 查询商品信息
	 */
	public HashMap<String,Object> queryCommodity(HashMap<String,Object> map);
	/**
	 * 查询门店信息
	 * 
	 */
	public HashMap<String,Object> queryShop(HashMap<String,Object> map);
}
