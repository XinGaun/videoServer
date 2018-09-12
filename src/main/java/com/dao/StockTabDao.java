package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.StockTab;
/**
 * 库存量表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface StockTabDao {
	/**
	 * 添加库存量信息
	 * @param stockTab
	 * @return
	 */
	public int addStockTab(StockTab stockTab);
	/**
	 * 查询库存量信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryStockTab(HashMap<String,Object> hashMap);
	/**
	 * 查询库存信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryStockTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新库存量信息
	 * @param stockTab
	 * @return
	 */
	public int updateStockTab(StockTab stockTab);

}
