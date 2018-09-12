package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.InventoryDetailTab;

@Mapper
public interface InventoryDetailTabDao {
	/**
	 * 添加仓库明细表信息
	 * @param detailTab
	 * @return
	 */
	public int addInventoryDetailTab(InventoryDetailTab detailTab);
	/**
	 * 查询仓库明细表信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryInventoryDetailTab(HashMap<String,Object> hashMap);
	/**
	 * 查询仓库明细表信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryInventoryDetailTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新仓库明细表信息
	 * @param detailTab
	 * @return
	 */
	public int updateInventoryDetailTab(InventoryDetailTab detailTab);
	/**
	 * 删除仓库明细表信息
	 * @param inve_id
	 * @return
	 */
	public int deleteInventoryDetailTab(int inve_id);
	/**
	 * 入库添加库存变更表
	 * @param hashMap
	 * @return
	 */
	public int addinventoryAlterTab(HashMap<String,Object> hashMap);
	/**
	 * 入库添加库存明细信息
	 */
	public int addRuKuInventoryDetailTab(HashMap<String,Object> hashMap);
	/**
	 * 采购入库添加库存明细信息
	 */
	public int addRuKuInventoryDetailTabs(HashMap<String,Object> hashMap);
	/**
	 * 查询库存量信息
	 */
	public ArrayList<HashMap<String,Object>> queryStockTab(HashMap<String,Object> hashMap);
	/**
	 * 查询原仓库库存量信息
	 */
	public ArrayList<HashMap<String,Object>> querySouStockTab(HashMap<String,Object> hashMap);
	/**
	 * 添加库存量信息
	 */
	public int addStockTab(HashMap<String,Object> hashMap);
	
	/**
	 * 更新库存量信息
	 */
	public int updateStockTab(HashMap<String,Object> hashMap);
	/**
	 * 查询采购单信息
	 */
	public HashMap<String,Object> queryPurchaseTab(HashMap<String,Object> hashMap);
	/**
	 * 查询采购需求信息
	 */
	public HashMap<String,Object> querypurchaseNeedTab(HashMap<String,Object> hashMap);
	/**
	 * 更新采购需求信息
	 */
	public int updatepurchaseNeedTab(HashMap<String,Object> hashMap);
	/**
	 * 更新采购单状态
	 */
	public int updatePurchaseTab(HashMap<String,Object> map);
	/**
	 * 查寻是否有缺货登记记录
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryregistration(HashMap<String,Object> map);
	/**
	 * 更新缺货登记记录
	 */
	public int updateregistration(HashMap<String,Object> map);
	/**
	 * 根据退换货ID查询商品销售记录信息
	 */
	public ArrayList<HashMap<String,Object>> querySalesRecordTab(HashMap<String,Object> map);
	/**
	 * 退换货ID查询配送单信息
	 */
	public HashMap<String,Object> queryDeliverTab(HashMap<String,Object> map);
}
