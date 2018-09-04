package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface IndexConfigDao {
	/**
	 * 添加首页滚播数据
	 * @param map
	 * @return
	 */
	public int addRollplayTab(HashMap<String,Object> map);
	/**
	 * 查询首页滚播放数据
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryRollplayRab(HashMap<String,Object> map);
	/**
	 * 更新首页滚动播放数据
	 * @param map
	 * @return
	 */
	public int updateRollplayTab(HashMap<String,Object> map);
	/**
	 * 删除首页滚播数据
	 * @param map
	 * @return
	 */
	public int deleteRollplayTab(ArrayList<Integer> list);
}
