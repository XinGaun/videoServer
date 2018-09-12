package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.DiscussTab;
/**
 * 评论表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface DiscussTabDao {
	/**
	 * 添加评论信息
	 * @param discussTab
	 * @return
	 */
	public int addDiscussTab(DiscussTab discussTab);
	/**
	 * 查询评论信息
	 * @param discussTab
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryDiscussTab(HashMap<String,Object> hashMap);
	/**
	 * 查询评论信息总数
	 * @param discussTab
	 * @return
	 */
	public int queryDiscussTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新评论信息
	 * @param discussTab
	 * @return
	 */
	public int updateDiscussTab(DiscussTab discussTab);
	/**
	 * 删除评论信息
	 * @param discussTab
	 * @return
	 */
	public int deleteDiscussTab(int disc_id);
}
