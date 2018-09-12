package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.DocumentsTabDao;
import com.entity.DocumentsTab;
import com.service.DocumentsTabService;
import com.util.Count;
import com.util.Page;
/**
 * 文案模块表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class DocumentsTabServiceImpl implements DocumentsTabService {
	@Autowired
	private DocumentsTabDao documentsTabDao;//调用文案模块表Dao层接口
	private Logger logger = Logger.getLogger(DocumentsTabServiceImpl.class);
	/**
	 * 添加文案模块信息
	 */
	@Override
	public String addDocumentsTab(String data) {
		logger.info("/addDocumentsTab data: "+data);
		DocumentsTab documentsTab = JSON.parseObject(data, DocumentsTab.class);
		int flog = documentsTabDao.addDocumentsTab(documentsTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询文案模块信息
	 */
	@Override
	public String queryDocumentsTab(String data) {
		logger.info("/queryDocumentsTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> arrayList = documentsTabDao.queryDocumentsTab(hashmap);
		int count = documentsTabDao.queryDocumentsTabCount(hashmap);
		//arrayList = Count.count(arrayList, count, hashmap);
		return JSON.toJSONString(Count.counts(arrayList, count, hashmap,200,"queryDocumentsTab success"));
	}
	/**
	 * 更新文案模块信息
	 */
	@Override
	public String updateDocumentsTab(String data) {
		logger.info("/updateDocumentsTab data: "+data);
		DocumentsTab documentsTab = JSON.parseObject(data, DocumentsTab.class);
		int flog = documentsTabDao.updateDocumentsTab(documentsTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除文案模块信息
	 */
	@Transactional
	public String deleteDocumentsTab(String data) {
		logger.info("/deleteDocumentsTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int docu_id = list.get(i);
			int flog = documentsTabDao.deleteDocumentsTab(docu_id);
			if(flog<=0) {
				retlist.add(docu_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
