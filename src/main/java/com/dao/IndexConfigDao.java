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
	 * 查询首页滚播总数
	 * @param map
	 * @return
	 */
	public int queryRollplayTabCount(HashMap<String,Object> map);
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
	public int deleteRollplayTab(HashMap<String,Object> map);
	/**
	 * 添加首页通知
	 */
	public int addinform(HashMap<String,Object> map);
	/**
	 * 查询首页通知信息
	 */
	public ArrayList<HashMap<String,Object>> queryinformList(HashMap<String,Object> map);
	/**
	 * 查询首页通知信息总数
	 * @param map
	 * @return
	 */
	public int queryinformCount(HashMap<String,Object> map);
	/**
	 * 删除通知消息
	 * @param map
	 * @return
	 */
	public int deleteinform(HashMap<String,Object> map);
	/**
	 * 修改通知信息
	 */
	public int updateinform(HashMap<String,Object> map);
	/**
	 * 添加教师展示信息
	 * @param map
	 * @return
	 */
	public int addTeachershowTab(HashMap<String,Object> map);
	/**
	 * 查询教师展示信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryTeachershowTab(HashMap<String,Object> map);
	/**
	 * 查询教师展示信息总数
	 * @param map
	 * @return
	 */
	public int queryTeachershowTabCount(HashMap<String,Object> map);
	/**
	 * 删除展示教师信息
	 */
	public int deleteTeachershowTab(HashMap<String,Object> map);
	/**
	 * 更新展示教师信息
	 * @param map
	 * @return
	 */
	public int updateTeachershowTab(HashMap<String,Object> map);
	/**
	 * 首页查询滚播信息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryrRollplaTabAll(HashMap<String,Object> map);
	/**
	 * 查询通知消息
	 * @param map
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryinformAll(HashMap<String,Object> map);
	/**
	 * 查询展示教师信息
	 */
	public ArrayList<HashMap<String,Object>> queryTeachershowTabAll(HashMap<String,Object> map);
}
