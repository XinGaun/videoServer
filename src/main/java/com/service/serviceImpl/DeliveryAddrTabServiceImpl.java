package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.BuyerTabDao;
import com.dao.DeliveryAddrTabDao;
import com.entity.BuyerTab;
import com.entity.DeliveryAddrTab;
import com.service.DeliveryAddrTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
/**
 * 配置地址Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class DeliveryAddrTabServiceImpl implements DeliveryAddrTabService {
	@Autowired
	private DeliveryAddrTabDao addrTabDao;//调用配置地址Dao层接口
	@Autowired
	private BuyerTabDao buyerTabDao;//调用买家信息Dao层接口

	private Logger logger = Logger.getLogger(DeliveryAddrTabServiceImpl.class);
	/**
	 * 添加配置地址
	 */
	@Override
	public String addDeliveryAddrTab(String data) {
		logger.info("/addDeliveryAddrTab data "+data);
		DeliveryAddrTab addrTab = JSON.parseObject(data,DeliveryAddrTab.class);
		int flog = addrTabDao.addDeliveryAddrTab(addrTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询配置地址
	 */
	@Override
	public String queryDeliveryAddrTab(String data) {
		logger.info("/queryDeliveryAddrTab data "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = addrTabDao.queryDeliveryAddrTab(hashMap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> buyer = buyerTabDao.queryBuyerTab(list.get(i));
			list.get(i).put("buyer", buyer);
		}
		int count = addrTabDao.queryDeliveryAddrTabCount(hashMap);
		//list=Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryDeliveryAddrTab success"));
	}
	/**
	 * 更新配置地址
	 */
	@Override
	public String updateDeliveryAddrTab(String data) {
		logger.info("/updateDeliveryAddrTab data "+data);
		DeliveryAddrTab addrTab = JSON.parseObject(data,DeliveryAddrTab.class);
		int flog = addrTabDao.updateDeliveryAddrTab(addrTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除配置地址
	 */
	@Transactional
	public String deleteDeliveryAddrTab(String data) {
		logger.info("/deleteDeliveryAddrTab data "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int deli_addr_id = list.get(i);
			int flog = addrTabDao.deleteDeliveryAddrTab(deli_addr_id);
			if(flog<=0) {
				retlist.add(deli_addr_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 同步19厅地址信息
	 */
	@Transactional
	public String synchronizationAddr(String data) {
		logger.info("/synchronizationAddr data "+data);
		BuyerTab buyertab = JSON.parseObject(data,BuyerTab.class);
		int flog=addrTabDao.deleteDeliveryAddrBuyeID(buyertab);//删除原有配置地址
		if(flog>0) {
			//添加送货地址		
			logger.info("/URL: "+"http://test.cloud-scale.cn/client/"+buyertab.getNineteen_id());
			String result= HttpReq.httpRequest("http://test.cloud-scale.cn/client/"+buyertab.getNineteen_id(),"GET", null);
			HashMap<String,String> resuMap  =JSON.parseObject(result,HashMap.class);
			ArrayList<String> addList = JSON.parseObject(JSON.toJSONString(resuMap.get("accounts")),ArrayList.class);
			for(int i=0;i<addList.size();i++) {
				HashMap<String,Object> accountsMap = JSON.parseObject(JSON.toJSONString(addList.get(i)), HashMap.class);
				DeliveryAddrTab addrTab = new DeliveryAddrTab();
				addrTab.setBuye_id(buyertab.getBuye_id());
				addrTab.setDeli_addr(accountsMap.get("address").toString());
				addrTab.setDeli_contacts(accountsMap.get("name").toString());
				addrTab.setDeli_phone(accountsMap.get("phone").toString());
				addrTabDao.addDeliveryAddrTab(addrTab);
			}
			
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("buye_id", buyertab.getBuye_id());
			return JSON.toJSONString(Count.counts(null, 0,map ,200,"addBuyerTab success"));
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 增加买家地址信息
	 */
	@Transactional
	public String addBuyersaddress(String data) {
		logger.info("/addBuyersaddress data "+data);
		HashMap<String,Object> dataMap = JSON.parseObject(data, HashMap.class);
		if(dataMap.containsKey("buye_id")) {
			ArrayList<String> list = JSON.parseObject(JSON.toJSONString(dataMap.get("addressList")), ArrayList.class);
			for(int i=0;i<list.size();i++) {
				DeliveryAddrTab listMap = JSON.parseObject(JSON.toJSONString(list.get(i)), DeliveryAddrTab.class);
				listMap.setBuye_id(Integer.parseInt(dataMap.get("buye_id").toString())); 
				addrTabDao.addDeliveryAddrTab(listMap);
			}
		}
		return JSON.toJSONString("success");
	}

}
