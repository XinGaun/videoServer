package com.service;
/**
 * 品类信息Service层接口
 * @author vip
 *
 */
public interface CategoryTabService {
	/**
	 * 添加品类表
	 * @param data
	 * @return
	 */
	public String addCategoryTab(String data);
	/**
	 * 查询品类表
	 * @param data
	 * @return
	 */
	public String queryCategoryTab(String data);
	/**
	 * 更新品类表
	 * @param data
	 * @return
	 */
	public String updateCategoryTab(String data);
	/**
	 * 删除品类表
	 * @param data
	 * @return
	 */
	public String deleteCategoryTab(String data);
	/**
	 * id查询品类表
	 */
	public String queryCateID(String data);
	/**
	 * 前端商品销售查询品类
	 */
	public String queryFrontCategoryTab(String data);
	/**
	 * 总实例添加品类信息
	 * @param data
	 * @return
	 */
	public String addPushCategoryTab(String data);
	/**
	 * 总实例更新品类信息
	 */
	public String updatePushCategoryTab(String data);
}
