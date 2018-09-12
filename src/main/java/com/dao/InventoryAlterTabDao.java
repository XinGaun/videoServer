package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.InventoryAlterTab;
/**
 * 库存变更表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface InventoryAlterTabDao {
	/**
	 * 添加库存变更信息
	 * @param inventoryAlterTab
	 * @return
	 */
	public int addInventoryAlterTab(InventoryAlterTab inventoryAlterTab);
	/**
	 * 查询库存变更信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryInventoryAlterTab(HashMap<String,Object> hashMap);
	/**
	 * 查询库存变更信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryInventoryAlterTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新库存变更信息
	 * @param inventoryAlterTab
	 * @return
	 */
	public int updateInventoryAlterTab(InventoryAlterTab inventoryAlterTab);
	/**
	 * 删除库存变更信息
	 * @param inve_alter_id
	 * @return
	 */
	public int deleteInventoryAlterTab(int inve_alter_id);
}
