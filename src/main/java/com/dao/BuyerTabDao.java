package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.BuyerTab;
/**
 * 买家信息Dao层接口
 * @author vip
 *
 */
@Mapper
public interface BuyerTabDao {
	/**
	 * 添加买家信息
	 * @param buyerTab
	 * @return
	 */
	public int addBuyerTab(BuyerTab buyerTab);
	/**
	 * 查询买家信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryBuyerTab(HashMap<String,Object> map);
	/**
	 * 查询买家信息总数
	 * @param map
	 * @return
	 */
	public int queryBuyerTabCount(HashMap<String,Object> map);
	/**
	 * 更新买家信息
	 * @return
	 */
	public int updateBuyerTab(BuyerTab buyerTab);
	/**
	 * 删除买家信息
	 * @param buye_id
	 * @return
	 */
	public int deleteBuyerTab(int buye_id);
}
