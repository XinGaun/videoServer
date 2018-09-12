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
import com.dao.SpecificationsTabDao;
import com.entity.ExampleTab;
import com.entity.SpecificationsTab;
import com.service.SpecificationsTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
/**
 * 商品规格Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class SpecificationsTabServiceImpl implements SpecificationsTabService {
	@Autowired 
	private SpecificationsTabDao specificationsTabDao;
	@Autowired
	private CategoryTabDao categoryTabDao;//调用品类Dao层接口
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(SpecificationsTabServiceImpl.class);
	/**
	 * 添加商品规格
	 */
	@Override
	public String addSpecificationsTab(String data) {
		logger.info("/addSpecificationsTab data:" +data);
		ArrayList<String> purchaseTab = JSON.parseObject(data, ArrayList.class);
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		//SpecificationsTab specificationsTab = JSON.parseObject(data, SpecificationsTab.class);
		for(int i=0;i<purchaseTab.size();i++) {
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(purchaseTab.get(i)), HashMap.class);
			int flog = specificationsTabDao.addSpecificationsTab(map);
			if(flog<=0) {
				list.add(map);
			}
		}
		if(list.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询商品规格
	 */
	@Override
	public String querySpecificationsTab(String data) {
		logger.info("/querySpecificationsTab data:" +data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap= Page.page(datamap);
		ArrayList<HashMap<String,Object>> list = specificationsTabDao.querySpecificationsTab(datamap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> category = categoryTabDao.queryCategoryTab(list.get(i));
			list.get(i).put("category", category);
		}
		int count = specificationsTabDao.querySpecificationsTabCount(datamap);
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"querySpecificationsTab success"));
	}
	/**
	 * 修改商品规格
	 */
	@Override
	public String updateSpecificationsTab(String data) {
		logger.info("/updateSpecificationsTab data:" +data);
		SpecificationsTab specificationsTab = JSON.parseObject(data, SpecificationsTab.class);
		int flog = specificationsTabDao.updateSpecificationsTab(specificationsTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除商品规格
	 */
	@Transactional
	public String deleteSpecificationsTab(String data) {
		logger.info("/deleteSpecificationsTab data:" +data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int spec_id = list.get(i);
			int flog = specificationsTabDao.deleteSpecificationsTab(spec_id);
			if(flog<=0) {
				retlist.add(spec_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 总实例添加商品规格信息
	 */
	@Override
	public String addPushSpecificationsTab(String data) {
		logger.info("/addSpecificationsTab data:" +data);
		ArrayList<String> purchaseTab = JSON.parseObject(data, ArrayList.class);
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		//SpecificationsTab specificationsTab = JSON.parseObject(data, SpecificationsTab.class);
		ArrayList<HashMap<String,Object>> pushMap = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<purchaseTab.size();i++) {			
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(purchaseTab.get(i)), HashMap.class);
			map.put("spec_id", -1);
			int flog = specificationsTabDao.addSpecificationsTab(map);
			pushMap.add(map);
			if(flog<=0) {
				list.add(map);
			}
			
		}
		//1.获取需要推送的地址IP
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		String result = null;
		HashMap<String,Object> resultList = new HashMap<String,Object>();
		for(int i=0;i<exampleList.size();i++) {
			result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/addPushSpecifications", "POST",JSON.toJSONString(pushMap));
			resultList.put(exampleList.get(i).getExample_name(), result);
		}
		if(list.size()==0) {
			HashMap<String,Object> returnMap = new HashMap<String,Object>();
			returnMap.put("code", 200);
			returnMap.put("msg", resultList);
			return JSON.toJSONString(returnMap);
		}

		return JSON.toJSONString("error");
	}
	/**
	 * 总实例更新商品规格信息
	 */
	@Transactional
	public String updatePushSpecificationsTab(String data) {
		logger.info("/updatePushSpecificationsTab data:" +data);
		SpecificationsTab specificationsTab = JSON.parseObject(data, SpecificationsTab.class);
		int flog = specificationsTabDao.updateSpecificationsTab(specificationsTab);
		//1.获取需要推送的地址IP
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		String result = null;
		HashMap<String,Object> resultList = new HashMap<String,Object>();
		for(int i=0;i<exampleList.size();i++) {
			result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/updatePushSpecifications", "POST",JSON.toJSONString(specificationsTab));
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
