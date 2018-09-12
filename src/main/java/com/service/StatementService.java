package com.service;

import java.util.HashMap;

/**
 * 报表Service层接口
 * @author 87518
 *
 */
public interface StatementService {
	/**
	 * 查询报表信息
	 * @param data
	 * @return
	 */
	public String queryStatement(String data);
	/**
	 * 查询库存量信息
	 */
	public String queryStockList();
	/**
	 * 总实例查询分实例信息报表信息
	 */
	public String queryPullStatementListCate(String data);
	/**
	 * 总实例查询分实力品类商品型号信息
	 */
	public String queryPullCateModelList();
	/**
	 * 总实例查询分实例销量信息
	 * @return
	 */
	public String queryPullCateModeSalelList(String data);
	/**
	 * 总实例调用分实例获取销量信息
	 */
	public String queryFenShiLiSaleList(String data);
	/**
	 * 总实例调用分实例获取库存信息
	 */
	public String queryPullStockList(String data);
	/**
	 * 总实例查询分实力
	 */
	public String queryStockLists(String data);
	/**
	 * 分实例查询自己进货记录
	 * @param data
	 * @return
	 */
	public String queryPurchasesList(String data);
	/**
	 * 自实例查询自己品类商品型号信息
	 */
	public String queryCategoryModel();
	/**
	 * 子实例提供给总实例查询商品销售记录
	 */
	public String queryOfferSalesRecordList(String data);
	/**
	 * 总实例查询子实例商品销售记录
	 */
	public String queryInstanceSalesRecord(String data);
	/**
	 * 自实例提供给总实例查询库存信息报表
	 */
	public String queryInstanceStockList(String data);
	/**
	 * 总实例查询自实例库存信息报表
	 */
	public String queryTotalInstanceStock(String data);
}
