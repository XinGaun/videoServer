package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.JddeTab;

/**
 * 配送单位Dao层接口
 * @author vip
 *
 */
@Mapper
public interface JddeTabDao {
	/**
	 * 添加配送单位
	 * @return
	 */
	public int addJddeTab(JddeTab jddeTab);
	/**
	 * 查询配送单位
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryJddeTab(HashMap<String,Object> map);
	/**
	 * 查询配送单位总数
	 * @param map
	 * @return
	 */
	public int queryJddeTabCount(HashMap<String,Object> map);
	/**
	 * 更新配送单位信息
	 * @param jddeTab
	 * @return
	 */
	public int updateJddeTab(JddeTab jddeTab);	
	/**
	 * 删除配送单位信息
	 */
	public int deleteJddeTab(int jdde_id);
}
