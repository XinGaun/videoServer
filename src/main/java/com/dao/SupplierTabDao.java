package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.SupplierTab;
/**
 * 厂商信息Dao层接口
 * @author vip
 *
 */
@Mapper
public interface SupplierTabDao {
	/**
	 * 添加厂商信息
	 * @param shopTab
	 * @return
	 */
	public int addSupplierTab(SupplierTab supplierTab);
	/**
	 * 查询厂商信息
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySupplierTab(HashMap<String,Object> hashMap);
	/**
	 * 查询厂商信息总条数
	 */
	public int querySupplierTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新厂商信息
	 * @param shopTab
	 * @return
	 */
	public int updateSupplierTab(SupplierTab supplierTab);
	/**
	 * 删除厂商信息
	 * @return
	 */
	public int deleteSupplierTab(int supp_id);
}
