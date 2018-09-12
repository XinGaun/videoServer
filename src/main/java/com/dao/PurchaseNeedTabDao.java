package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.PurchaseNeedTab;
/**
 * 采购需求表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface PurchaseNeedTabDao {
	/**
	 * 添加采购需求信息
	 * @param purchaseNeedTab
	 * @return
	 */
	public int addPurchaseNeedTab(PurchaseNeedTab purchaseNeedTab);
	/**
	 * 查询采购需求信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryPurchaseNeedTab(HashMap<String,Object> hashMap);
	/**
	 * 查询采购需求总数
	 * @param hashMap
	 * @return
	 */
	public int queryPurchaseNeedTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新采购需求信息
	 * @param purchaseNeedTab
	 * @return
	 */
	public int updatePurchaseNeedTab(PurchaseNeedTab purchaseNeedTab);
	/**
	 * 删除采购需求信息
	 * @param purc_need_id
	 * @return
	 */
	public int deletePurchaseNeedTab(int purc_need_id);
}
