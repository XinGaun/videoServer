package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.ComeWarehouseTab;
/**
 * 出库单Dao层接口
 * @author vip
 *
 */
@Mapper
public interface ComeWarehouseTabDao {
	/**
	 * 添加出库单
	 * @param comeWarehouseTab
	 * @return
	 */
	public int addComeWarehouseTab(ComeWarehouseTab comeWarehouseTab);
	/**
	 * 查询出库单
	 * @param comeWarehouseTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryComeWarehouseTab(HashMap<String,Object> hashMap);
	/**
	 * 查询出库单总数
	 * @param hashMap
	 * @return
	 */
	public int queryComeWarehouseTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新出库单信息
	 * @param comeWarehouseTab
	 * @return
	 */
	public int updateComeWarehouseTab(ComeWarehouseTab comeWarehouseTab);
	/**
	 * 删除出库单信息
	 * @param come_ware_id
	 * @return
	 */
	public int deleteComeWarehouseTab(int come_ware_id);
	/**
	 * 添加出库单
	 */
	public int addComeWarehouseTabMap(HashMap<String,Object> map);
	/**
	 * 添加库存变更记录
	 */
	public int addinventoryAlterTab(HashMap<String,Object> map);
	/**
	 * 更新对应的库存明细表
	 */
	public int addinventoryDetailtab(HashMap<String,Object> map);
	/**
	 * 查询库存量表
	 */
	public HashMap<String,Object> querystockMap(HashMap<String,Object> map);
	/**
	 * 更新仓库的库存量信息
	 */
	public int updatestockMap(HashMap<String,Object> map);
	/**
	 * 添加目的仓库增加货物在途记录
	 */
	public int addmdinventoryDetailtab(HashMap<String,Object> map);
	/**
	 * 查询目的仓库库存量信息
	 * @param map
	 * @return
	 */
	public HashMap<String,Object> queryMdstockMap(HashMap<String,Object> map);
	/**
	 * 修改目的仓库库存量
	 * @param map
	 * @return
	 */
	public int updateMdstockMap(HashMap<String,Object> map);
	/**
	 * 查询订单信息
	 */
	public ArrayList<HashMap<String,Object>> queryOrderTab(HashMap<String,Object> map);
	/**
	 * 添加库存量信息
	 */
	public int addStockTab(HashMap<String,Object> map);
	/**
	 * 查询货物ID
	 */
	public ArrayList<HashMap<String,Object>> queryInventoryAlter(HashMap<String,Object> map);
	/**
	 * 更新库存明细标记
	 */
	public int updateDnventorydetailTab(HashMap<String,Object> map);
	/**
	 * 查询根据订单ID查询信息
	 */
	public HashMap<String,Object> queryOrderID(HashMap<String,Object> map);
	/**
	 * 更新配送单信息
	 */
	public int updateDeliver(HashMap<String,Object> map);
	/**
	 * 根据订单ID查询商品销售记录
	 */
	public ArrayList<HashMap<String,Object>> queryRecord(HashMap<String,Object> map);
	/**
	 * 根据ID查询退换货记录
	 */
	public HashMap<String,Object> queryChangeTab(HashMap<String,Object> map);
	/**
	 * 更新退换货状态
	 */
	public int updateChangeTab(HashMap<String,Object> map);
	
	
	/**
	 * 查询符合销售的货物ID
	 */
	public HashMap<String,Object> queryInventoryDetailTabCargoId(HashMap<String,Object> map);
	/**
	 * 添加货物ID到商品销售记录中
	 */
	public int updateSalesRecordTab(HashMap<String,Object> map);
	/**
	 * 根据商品销售记录查询商品销售记录信息
	 */
	public HashMap<String,Object> querySaleRecordTab(HashMap<String,Object> map);
	/**
	 * 退换货添加新的商品销售记录
	 */
	public int addSaleRecordTab(HashMap<String,Object> map);
	/**
	 * 退换货根据货物ID修改库存明细
	 */
	public int updateInventoryDetailTab(HashMap<String,Object> map);
	/**
	 * 退换货添加库存变更记录
	 */
	public int addInventoryAlterTabChange(HashMap<String,Object> map);
	/**
	 * 查询配送单信息
	 */
	public HashMap<String,Object> queryDeliverTab(HashMap<String,Object> map);
	/**
	 * 更新退换货单状态
	 */
	public int updateChangeTabStatus(HashMap<String,Object> map);
	/**
	 * 通过退换货id查询商品销售记录
	 */
	public ArrayList<HashMap<String,Object>> queryChanIdSaleRecordTab(HashMap<String,Object> map);
	/**
	 * 订单出库更新订单状态
	 * 
	 */
	public int updateOrder(HashMap<String,Object> map);
}
