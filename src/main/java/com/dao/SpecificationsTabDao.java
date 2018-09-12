package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.SpecificationsTab;
/**
 * 商品规格Dao层接口
 * @author vip
 *
 */
@Mapper
public interface SpecificationsTabDao {
	/**
	 * 添加商品规格
	 * @param specificationsTab
	 * @return
	 */
	public int addSpecificationsTab(HashMap<String,Object> specificationsTab);
	/**
	 * 查询商品规格
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> querySpecificationsTab(HashMap<String,Object> hashMap);
	/**
	 * 查询商品规格总数
	 * @param hashMap
	 * @return
	 */
	public int querySpecificationsTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新商品规格
	 * @param specificationsTab
	 * @return
	 */
	public int updateSpecificationsTab(SpecificationsTab specificationsTab);
	/**
	 * 删除商品规格
	 * @param spec_id
	 * @return
	 */
	public int deleteSpecificationsTab(int spec_id);
}
