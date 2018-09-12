package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.CommodityTab;
/**
 * 商品信息Dao层接口
 * @author vip
 *
 */
@Mapper
public interface CommodityTabDao {
	/**
	 * 添加商品信息
	 * @param commodityTab
	 * @return
	 */
	public int addCommodityTab(CommodityTab commodityTab);
	/**
	 * 查询商品信息
	 * @param hashmap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCommodityTab(HashMap<String,Object> hashmap);
	/**
	 * 查询商品信息总数
	 * @param hashmap
	 * @return
	 */
	public int queryCommodityTabCount(HashMap<String,Object> hashmap);
	/**
	 * 更新商品信息
	 * @param commodityTab
	 * @return
	 */
	public int updateCommodityTab(CommodityTab commodityTab);
	/**
	 * 删除上架信息
	 * @param comm_putaway_id
	 * @return
	 */
	public int deleteCommodityTab(int comm_putaway_id);
	/**
	 * 根据商品名称ID模糊搜索
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCommName(HashMap<String,Object> hashMap);
	/**
	 * 前端查询商品信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> quertFrontCommodityTab(HashMap<String,Object> hashMap);
	/**
	 * 前端查询商品总条数
	 */
	public int quertFrontCommodityTabCount(HashMap<String,Object> hashMap);
	/**
	 * 后端查询商品信息
	 */
	public ArrayList<HashMap<String,Object>> queryCommodityTabBack(HashMap<String,Object> map);
	/**
	 * 后端查询商品信息总数
	 */
	public int queryCommodityTabBackCount(HashMap<String,Object> map);
	/**
	 * 查询品类ID信息
	 */
	public ArrayList<Integer> queryCategoryID(HashMap<String,Object> map);
	/**
	 * 查询库存量信息
	 */
	public Integer querystockTab(HashMap<String,Object> map);
	/**
	 * 总实例添加商品时查询添加的商品ID
	 */
	public HashMap<String,Object> queryPushCommodityID(int comm_putaway_id);
}
