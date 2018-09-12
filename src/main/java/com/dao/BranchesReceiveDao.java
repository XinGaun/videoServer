package com.dao;

import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.BrandTab;
import com.entity.CategoryTab;
import com.entity.CommodityTab;
import com.entity.SpecificationsTab;
import com.entity.SupplierTab;

/**
 * 分公司接收推送信息Dao层
 * @author vip
 *
 */
@Mapper
public interface BranchesReceiveDao {
	/**
	 * 添加总实例推送商品信息
	 */
	public int addPushCommodity(CommodityTab commodityTab);
	/**
	 * 更新总实例推送商品信息
	 */
	public int updatePushCommodity(CommodityTab commodityTab);
	/**
	 * 删除商品总实例推送删除
	 */
	public int deletePushCommodity(int comm_putaway_id);
	/**
	 * 添加总实例推送品类信息
	 */
	public int addPushCategory(CategoryTab categoryTab);
	/*
	 * 更新总实例推送品类信息 
	 */
	public int updatePushCategory(CategoryTab categoryTab);
	/**
	 * 添加总实例推送的商品规格信息
	 */
	public int addPushSpecifications(HashMap<String,Object> map);
	/**
	 * 更新总实例推送的商品规格信息
	 */
	public int updatePushSpecifications(SpecificationsTab specificationsTab);
	/**
	 * 添加总实例推送的供应商信息
	 */
	public int addPushSupplier(SupplierTab supplierTab);
	/**
	 * 更新总实例推送的供应商信息
	 */
	public int updatePushSupplier(SupplierTab supplierTab);
	/**
	 * 删除总实例推送的供应商信息
	 */
	public int deletePushSupplier(int supp_id);
	/**
	 * 添加总实例推送的品牌信息
	 * @param brandTab
	 * @return
	 */
	public int addPushBrand(BrandTab brandTab);
	/**
	 * 更新总实例推送的品牌信息
	 */
	public int updatePushBrand(BrandTab brandTab);
	/**
	 * 删除总实例推送的品牌信息
	 * @param brand_id
	 * @return
	 */
	public int deletePushBrand(int brand_id);
}
