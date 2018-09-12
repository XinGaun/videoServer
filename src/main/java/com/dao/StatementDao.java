package com.dao;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;



@Mapper
public interface StatementDao {
	/**
	 * 查询报表类目信息
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCategoryList(HashMap<String,Object> map);
	/**
	 * 查询对应品类对应商品名称和数量
	 */
	public ArrayList<HashMap<String,Object>> queryCommoditySales(HashMap<String,Object> map);
	/**
	 * 查询商品型号
	 */
	public ArrayList<HashMap<String,Object>> queryCommodityModel(HashMap<String,Object> map);
	/**
	 * 查询进货信息
	 */
	public ArrayList<HashMap<String,Object>> queryPurchaseList(HashMap<String,Object> map);
	/**
	 * 查询库存量信息
	 */
	public HashMap<String,Object> queryStockList(HashMap<String,Object> map);
	/**
	 * 总实例查询销售信息
	 */
	public ArrayList<HashMap<String,Object>> queryPullStatements(HashMap<String,Object> map);
	
	/**
	 * 总实例查询品类信息
	 */
	public ArrayList<HashMap<String,Object>> queryPullStatementsCate(HashMap<String,Object> map);
	/**
	 * 查询商品销量信息
	 */
	public ArrayList<HashMap<String,Object>> queryPullCateModeSalelList(HashMap<String,Object> map);
	/**
	 * 总实例查询子实例库存信息
	 */
	public HashMap<String,Object> queryPullStockList(HashMap<String,Object> map);
	/**
	 * 分实例查询自己进货记录
	 */
	public ArrayList<HashMap<String,Object>> queryPurchasesList(HashMap<String,Object> map);
	/**
	 * 子实例提供给总实例查询商品销售记录
	 */
	public ArrayList<HashMap<String,Object>> queryOfferSalesRecordList(HashMap<String,Object> map);
	/**
	 * 自实例查询入库记录信息
	 */
	public int queryPurchasePutCount(HashMap<String,Object> map);
	/**
	 * 自实例查询出库数量
	 */
	public int queryStockRemovalCount(HashMap<String,Object> map);
	/**
	 * 自实例根据商品型号查询库存信息
	 */
	public HashMap<String,Object> queryModelStockList(HashMap<String,Object> map);
}
