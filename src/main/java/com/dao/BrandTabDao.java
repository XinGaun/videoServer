package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.BrandTab;
/**
 * 
 * @author vip
 *
 */
@Mapper
public interface BrandTabDao {
	/**
	 * 添加品牌
	 * @param brandTab
	 * @return
	 */
	public int addBrandTab(BrandTab brandTab);
	/**
	 * 查询品牌
	 * @param brandTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryBrandTab(HashMap<String,Object> hashMap);
	/**
	 * 查询品牌总数
	 * @param brandTab
	 * @return
	 */
	public int queryBrandTabCount(HashMap<String,Object> hashMap);
	/**
	 * 删除品牌
	 * @param brandTab
	 * @return
	 */
	public int deleteBrandTab(int brand_id);
	/**
	 * 更新品牌
	 * @param brand_id
	 * @return
	 */
	public int updateBrandTab(BrandTab brandTab);
}
