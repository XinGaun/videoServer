package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.WriterTab;

/**
 * 文案表Dao层接口
 * @author vip
 *
 */
@Mapper
public interface WriterTabDao {
	/**
	 * 添加文案信息
	 * @param writerTab
	 * @return
	 */
	public int addWriterTab(WriterTab writerTab);
	/**
	 * 查询文案信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryWriterTab(HashMap<String,Object> hashMap);
	/**
	 * 查询文案信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryWriterTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新文案信息
	 * @param writerTab
	 * @return
	 */
	public int updateWriterTab(WriterTab writerTab);
	/**
	 * 删除文案信息
	 * @param writ_id
	 * @return
	 */
	public int deleteWriterTab(int writ_id);
}
