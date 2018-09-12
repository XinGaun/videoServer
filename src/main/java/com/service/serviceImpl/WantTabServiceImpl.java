package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.WantTabDao;
import com.entity.WantTab;
import com.service.WantTabService;
import com.util.Count;
import com.util.Page;
/**
 * 缺货登记表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class WantTabServiceImpl implements WantTabService {
	@Autowired
	private WantTabDao wantTabDao;//调用缺货登记Dao层接口
	private Logger logger = Logger.getLogger(WantTabServiceImpl.class);
	/**
	 * 添加缺货登记信息
	 */
	@Override
	public String addWantTab(String data) {
		logger.info("/addWantTab data: "+data);
		WantTab wantTab = JSON.parseObject(data, WantTab.class);
		int flog = wantTabDao.addWantTab(wantTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询缺货登记信息
	 */
	@Override
	public String queryWantTab(String data) {
		logger.info("/queryWantTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = wantTabDao.queryWantTab(hashMap);
		int count = wantTabDao.queryWantTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryWantTab success"));
	}
	/**
	 * 更新缺货登记信息
	 */
	@Override
	public String updateWantTab(String data) {
		logger.info("/updateWantTab data: "+data);
		WantTab wantTab = JSON.parseObject(data, WantTab.class);
		int flog = wantTabDao.updateWantTab(wantTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除缺货登记信息
	 */
	@Transactional
	public String deleteWantTab(String data) {
		logger.info("/deleteWantTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int want_id = list.get(i);
			int flog = wantTabDao.deleteWantTab(want_id);
			if(flog<=0) {
				retlist.add(want_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 缺货登记表生成采购需求信息
	 */
	//s@Transactional
	public String generatePurchase(String data) {
		logger.info("/generatePurchase data: "+data);
		//HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		ArrayList<String> list = JSON.parseObject(data,ArrayList.class);
		for(int i=0;i<list.size();i++) {
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(list.get(i)),HashMap.class);
			ArrayList<HashMap<String,Object>> listMap = wantTabDao.queryWantTab(map);
			listMap.get(0).put("staf_id", map.get("staf_id"));
			listMap.get(0).put("shop_id", map.get("shop_id"));
			listMap.get(0).put("purc_need_id", -1);		
			wantTabDao.addprocurement(listMap.get(0));
			map.put("want_status","已生成采购需求");
			map.put("purc_need_id",listMap.get(0).get("purc_need_id"));
			wantTabDao.updatescWantTab(map);
		}
		return JSON.toJSONString("success");
	}

}
