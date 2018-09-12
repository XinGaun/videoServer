package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.ShopTab;
@Mapper
public interface ShopTabDao {
	/**
	 * 添加门店信息
	 * @param shopTab
	 * @return
	 */
	public int addShopTab(ShopTab shopTab);
	/**
	 * 查询门店信息
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryShopTab(HashMap<String,Object> hashMap);
	/**
	 * 查询门店信息总条数
	 */
	public int queryShopTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新门店信息
	 * @param shopTab
	 * @return
	 */
	public int updateShopTab(ShopTab shopTab);
	/**
	 * 删除门店信息
	 * @return
	 */
	public int deleteShopTab(int shop_id);
}
