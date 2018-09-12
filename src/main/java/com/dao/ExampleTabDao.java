package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.ExampleTab;

/**
 * 分公司实例Dao层接口
 * @author vip
 *
 */
@Mapper
public interface ExampleTabDao {
	/**
	 * 添加分公司实例信息
	 * @param exampleTab
	 * @return
	 */
	public int addExampleTab(ExampleTab exampleTab);
	/**
	 * 查询分公司实例信息
	 * @return
	 */
	public ArrayList<ExampleTab> queryExampleTab(HashMap<String,Object> map);
	/**
	 * 修改分公司实例信息
	 */
	public int updateExampleTab(ExampleTab exampleTab);
	/**
	 * 删除分公司实例信息
	 * @param list
	 * @return
	 */
	public int deleteExampleTab(ArrayList<Integer> list);
}
