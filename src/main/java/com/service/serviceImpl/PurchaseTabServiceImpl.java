package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.PurchaseNeedTabDao;
import com.dao.PurchaseTabDao;
import com.dao.StaffTabDao;
import com.entity.PurchaseNeedTab;
import com.entity.PurchaseTab;
import com.service.PurchaseTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 采购单Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class PurchaseTabServiceImpl implements PurchaseTabService {
	@Autowired
	private PurchaseTabDao purchaseTabDao;//调用采购单Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	@Autowired
	private PurchaseNeedTabDao needTabDao;//调用采购需求Dao层接口

	
	private Logger logger = Logger.getLogger(PurchaseTabServiceImpl.class);
	/**
	 * 添加采购单信息
	 */
	@Transactional
	public String addPurchaseTab(String data) {
		logger.info("/addPurchaseTab data: "+data);
		ArrayList<String> purchaseTab = JSON.parseObject(data, ArrayList.class);
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<purchaseTab.size();i++) {
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(purchaseTab.get(i)), HashMap.class);
			map.put("purc_id", -1);
			map.put("purc_date", DateUtil.getNowDate());
			int flog = purchaseTabDao.addPurchaseTab(map);
			if(map.containsKey("purc_need_id")) {
				PurchaseNeedTab purchaseNeed = new PurchaseNeedTab();
				purchaseNeed.setPurc_id(Integer.parseInt(map.get("purc_id").toString()));
				purchaseNeed.setPurc_need_id(Integer.parseInt(map.get("purc_need_id").toString()));
				purchaseNeed.setPurc_need_status("已生成采购单");
				needTabDao.updatePurchaseNeedTab(purchaseNeed);//更新所属采购需求信息
			}
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
	 * 查询采购单信息
	 */
	@Override
	public String queryPurchaseTab(String data) {
		logger.info("/queryPurchaseTab data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap= Page.page(datamap);
		ArrayList<HashMap<String,Object>> list = purchaseTabDao.queryPurchaseTab(datamap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
			list.get(i).put("staff", staff);
			if(list.get(i).containsKey("purc_need_id")) { 
				HashMap<String,Object> hashmap = new HashMap<String,Object>();
				hashmap.put("purc_need_id", list.get(i).get("purc_need_id"));
				ArrayList<HashMap<String,Object>> purchaseNeed = needTabDao.queryPurchaseNeedTab(hashmap);
				for(int s=0;s<purchaseNeed.size();s++) {
					HashMap<String,Object> Commodity = purchaseTabDao.queryCommodity(purchaseNeed.get(s));
					purchaseNeed.get(s).put("Commodity", Commodity);
					HashMap<String,Object> Shop = purchaseTabDao.queryShop(purchaseNeed.get(s));
					purchaseNeed.get(s).put("Shop", Shop);
				}			
				list.get(i).put("purchaseNeed", purchaseNeed);
			}	
			
			
		}
		int count = purchaseTabDao.queryPurchaseTabCount(datamap);
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"queryPurchaseTab success"));
	}
	/**
	 * 更新采购单信息
	 */
	@Override
	public String updatePurchaseTab(String data) {
		logger.info("/updatePurchaseTab data: "+data);
		PurchaseTab purchaseTab = JSON.parseObject(data, PurchaseTab.class);
		int flog = purchaseTabDao.updatePurchaseTab(purchaseTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除采购单信息
	 */
	@Transactional
	public String deletePurchaseTab(String data) {
		logger.info("/deletePurchaseTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int purc_id = list.get(i);
			int flog = purchaseTabDao.deletePurchaseTab(purc_id);
			if(flog<=0) {
				retlist.add(purc_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
