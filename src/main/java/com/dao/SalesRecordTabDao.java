package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.SalesRecordTab;
/**
 * 商品销售记录Dao层接口
 * @author vip
 *
 */
@Mapper
public interface SalesRecordTabDao {
	/**
	 * 添加商品销售记录
	 * @param recordTab
	 * @return
	 */
	public int addSalesRecordTab(HashMap<String,Object> map);
	/**
	 * 查询商品销售记录
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySalesRecordTab(HashMap<String,Object> hashMap);
	/**
	 * 查询商品销售记录总数
	 * @param hashMap
	 * @return
	 */
	public int querySalesRecordTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新商品销售记录
	 * @param recordTab
	 * @return
	 */
	public int updateSalesRecordTab(SalesRecordTab recordTab);
	/**
	 * 删除商品销售记录
	 * @param sale_id
	 * @return
	 */
	public int deleteSalesRecordTab(int sale_id);
}
