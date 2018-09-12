package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CategoryTabDao;
import com.dao.ExampleTabDao;
import com.entity.CategoryTab;
import com.entity.ExampleTab;
import com.service.CategoryTabService;
import com.util.Count;
import com.util.HttpReq;

/**
 * 品类信息Service层实现类
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class CategoryTabServiceImpl implements CategoryTabService {
	@Autowired
	private CategoryTabDao categoryTabDao;//调用品类Dao层接口
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(CategoryTabServiceImpl.class);
	/**
	 * 添加品类信息
	 */
	@Override
	public String addCategoryTab(String data) {
		logger.info("/addCategoryTab data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = categoryTabDao.addCategoryTab(categoryTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询品类信息
	 */
	@Override
	public String queryCategoryTab(String data) {
		logger.info("/queryCategoryTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list =categoryTabDao.queryCategoryTab(hashMap);
		return JSON.toJSONString(Count.counts(list, -1, hashMap,200,"queryCategoryTab success"));
	}
	/**
	 * 更新品类信息
	 */
	@Override
	public String updateCategoryTab(String data) {
		logger.info("/updateCategoryTab data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = categoryTabDao.updateCategoryTab(categoryTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除品类信息
	 */
	@Transactional
	public String deleteCategoryTab(String data) {
		logger.info("/deleteCategoryTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int cate_id = list.get(i);
			int flog = categoryTabDao.deleteCategoryTab(cate_id);
			if(flog<=0) {
				retlist.add(cate_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * ID查询品类信息
	 */
	@Override
	public String queryCateID(String data) {
		logger.info("/queryCateID data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list =categoryTabDao.queryCateID(hashMap);
		return JSON.toJSONString(Count.counts(list, -1, hashMap,200,"queryCategoryTab success"));
	}
	/**
	 * 查询前端品类信息
	 */
	@Override
	public String queryFrontCategoryTab(String data) {
		logger.info("/queryFrontCategoryTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list =categoryTabDao.queryCategoryTab(hashMap);

		for(int i=0;i<list.size();i++) {
			hashMap.put("cate_superior",list.get(i).get("cate_id"));
			hashMap.put("cate_ids", null);
			ArrayList<HashMap<String,Object>> twoList = categoryTabDao.queryCategoryTab(hashMap);		
			for(int s=0;s<twoList.size();s++) {
				hashMap.put("cate_superior",twoList.get(s).get("cate_id"));
				ArrayList<HashMap<String,Object>> threeList = categoryTabDao.queryCategoryTab(hashMap);
				twoList.get(s).put("sonList", threeList);
			}
			list.get(i).put("sonList", twoList);
		}
		return JSON.toJSONString(Count.counts(list, -1, null,200,"queryFrontCategoryTab success"));
	}
	/**
	 * 总实例添加品类信息
	 */
	@Transactional
	public String addPushCategoryTab(String data) {
		logger.info("/addPushCategoryTab data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = categoryTabDao.addCategoryTab(categoryTab);
		//1.获取需要推送的地址IP
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		String result = null;
		HashMap<String,Object> resultList = new HashMap<String,Object>();
		for(int i=0;i<exampleList.size();i++) {
			result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/addPushCategory", "POST",JSON.toJSONString(categoryTab));
			resultList.put(exampleList.get(i).getExample_name(), result);
		}
		if(flog>0) {
			HashMap<String,Object> returnMap = new HashMap<String,Object>();
			returnMap.put("code", 200);
			returnMap.put("msg", resultList);
			return JSON.toJSONString(returnMap);
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 总实例更新品类信息
	 */
	@Transactional
	public String updatePushCategoryTab(String data) {
		logger.info("/updatePushCategoryTab data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = categoryTabDao.updateCategoryTab(categoryTab);
		//1.获取需要推送的地址IP
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		String result = null;
		HashMap<String,Object> resultList = new HashMap<String,Object>();
		for(int i=0;i<exampleList.size();i++) {
			result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/updatePushCategory", "POST",JSON.toJSONString(categoryTab));
			resultList.put(exampleList.get(i).getExample_name(), result);
		}
		if(flog>0) {
			HashMap<String,Object> returnMap = new HashMap<String,Object>();
			returnMap.put("code", 200);
			returnMap.put("msg", resultList);
			return JSON.toJSONString(returnMap);
		}
		return JSON.toJSONString("error");
	}

}
