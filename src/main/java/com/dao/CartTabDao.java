package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.CartTab;
/**
 * 购物车Dao层接口
 * @author vip
 *
 */
@Mapper
public interface CartTabDao {
	/**
	 * 添加购物车
	 * @param cartTab
	 * @return
	 */
	public int addCartTab(CartTab cartTab);
	/**
	 * 查询购物车
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCartTab(HashMap<String,Object> hashMap);
	/**
	 * 查询购物车总条数
	 * @param hashMap
	 * @return
	 */
	public int queryCartTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新购物车
	 * @param cartTab
	 * @return
	 */
	public int updateCartTab(CartTab cartTab);
	/**
	 * 删除购物车
	 * @param cart_id
	 * @return
	 */
	public int deleteCartTab(int cart_id);
}
