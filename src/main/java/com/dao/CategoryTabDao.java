package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.CategoryTab;
/**
 * 品类Dao层接口
 * @author vip
 *
 */
@Mapper
public interface CategoryTabDao {
	/**
	 * 添加品类信息
	 * @param categoryTab
	 * @return
	 */
	public int addCategoryTab(CategoryTab categoryTab);
	/**
	 * 查询品类信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryCategoryTab(HashMap<String,Object> map);
	/**
	 * 查询品类信息总数
	 * @param map
	 * @return
	 */
	public int queryCategoryTabCount(HashMap<String,Object> map);
	/**
	 * 更新品类信息
	 * @param categoryTab
	 * @return
	 */
	public int updateCategoryTab(CategoryTab categoryTab);
	/**
	 * 删除品类信息
	 * @param cate_id
	 * @return
	 */
	public int deleteCategoryTab(int cate_id);
	/**
	 * 查询ID品类信息
	 */
	public ArrayList<HashMap<String,Object>> queryCateID(HashMap<String,Object> map);
}
