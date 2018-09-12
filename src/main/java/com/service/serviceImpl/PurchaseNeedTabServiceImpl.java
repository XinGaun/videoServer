package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CommodityTabDao;
import com.dao.PurchaseNeedTabDao;
import com.dao.PurchaseTabDao;
import com.dao.ShopTabDao;
import com.dao.StaffTabDao;
import com.entity.PurchaseNeedTab;
import com.service.PurchaseNeedTabService;
import com.util.Count;
import com.util.Page;
/**
 * 采购需求Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class PurchaseNeedTabServiceImpl implements PurchaseNeedTabService {
	@Autowired
	private PurchaseNeedTabDao purchaseNeedTabDao;//调用采购需求Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	@Autowired
	private ShopTabDao shopTabDao;//调用门店Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	@Autowired
	private PurchaseTabDao purchaseTabDao;//调用采购单Dao层接口
	private Logger logger = Logger.getLogger(PurchaseNeedTabServiceImpl.class);
	/**
	 * 添加采购需求
	 */
	@Override
	public String addPurchaseNeedTab(String data) {
		logger.info("/addPurchaseNeedTab data: "+data);
		PurchaseNeedTab purchaseNeedTab = JSON.parseObject(data, PurchaseNeedTab.class);
		int flog = purchaseNeedTabDao.addPurchaseNeedTab(purchaseNeedTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询采购需求
	 */
	@Override
	public String queryPurchaseNeedTab(String data) {
		logger.info("/queryPurchaseNeedTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = purchaseNeedTabDao.queryPurchaseNeedTab(hashMap);
		int count = purchaseNeedTabDao.queryPurchaseNeedTabCount(hashMap);
		for(int i=0;i<list.size();i++) {
			list.get(i).put("comm_putaway_id",list.get(i).get("comm_id"));
			list.get(i).put("comm_id", null);
			ArrayList<HashMap<String,Object>> commodity = commodityTabDao.queryCommodityTab(list.get(i));
			ArrayList<HashMap<String,Object>> shop = shopTabDao.queryShopTab(list.get(i));
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
			list.get(i).put("commodity", commodity);
			list.get(i).put("shop", shop);
			list.get(i).put("staff", staff);
			if(list.get(i).containsKey("purc_id")) {
				HashMap<String,Object> map = new HashMap<String,Object>();
				map.put("purc_id", list.get(i).get("purc_id"));
				ArrayList<HashMap<String,Object>> purchase= purchaseTabDao.queryPurchaseTab(map);
				list.get(i).put("purchase", purchase);
			}
			
		}
		//list=Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryPurchaseNeedTab success"));
	}
	/**
	 * 更新采购需求
	 */
	@Override
	public String updatePurchaseNeedTab(String data) {
		logger.info("/updatePurchaseNeedTab data: "+data);
		PurchaseNeedTab purchaseNeedTab = JSON.parseObject(data, PurchaseNeedTab.class);
		int flog = purchaseNeedTabDao.updatePurchaseNeedTab(purchaseNeedTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除采购需求
	 */
	@Transactional
	public String deletePurchaseNeedTab(String data) {
		logger.info("/deletePurchaseNeedTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int purc_need_id = list.get(i);
			int flog = purchaseNeedTabDao.deletePurchaseNeedTab(purc_need_id);
			if(flog<=0) {
				retlist.add(purc_need_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
