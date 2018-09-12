package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.WarehouseTab;
/**
 * 仓库Dao层接口
 * @author vip
 *
 */
@Mapper
public interface WarehouseTabDao {
	/**
	 * 添加仓库
	 * @param warehouseTab
	 * @return
	 */
	public int addWarehouseTab(WarehouseTab warehouseTab);
	/**
	 * 查询仓库
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryWarehouseTab(HashMap<String,Object> map);
	/**
	 * 查询仓库总数
	 * @param map
	 * @return
	 */
	public int queryWarehouseTabCount(HashMap<String,Object> map);
	/**
	 * 更新仓库
	 * @param warehouseTab
	 * @return
	 */
	public int updateWarehouseTab(WarehouseTab warehouseTab);
	/**
	 * 删除仓库
	 * @param ware_id
	 * @return
	 */
	public int deleteWarehouseTab(int ware_id);
	/**
	 * 查询父类仓库信息
	 */
	public HashMap<String,Object> queryWarehousetop(HashMap<String,Object> map);
}
