package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.DocumentsTab;
/**
 * 文案模块表信息Dao层接口
 * @author vip
 *
 */
@Mapper
public interface DocumentsTabDao {
	/**
	 * 添加文案模块表信息
	 * @param documentsTab
	 * @return
	 */
	public int addDocumentsTab(DocumentsTab documentsTab);
	/**
	 * 查询文案模块表信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryDocumentsTab(HashMap<String,Object> hashMap);
	/**
	 * 查询文案模块表信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryDocumentsTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新文案模块表信息
	 * @param documentsTab
	 * @return
	 */
	public int updateDocumentsTab(DocumentsTab documentsTab);
	/**
	 * 删除文案模块表信息
	 * @param docu_id
	 * @return
	 */
	public int deleteDocumentsTab(int docu_id);
}
