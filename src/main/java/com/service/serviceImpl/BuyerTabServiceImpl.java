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
import com.service.BuyerTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
/**
 * 买家信息Service实现类
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class BuyerTabServiceImpl implements BuyerTabService {
	@Autowired
	private BuyerTabDao buyerTabDao;
	@Autowired
	private DeliveryAddrTabDao addrTabDao;
	private Logger logger = Logger.getLogger(BuyerTabServiceImpl.class);
	/**
	 * 添加买家信息
	 */
	//@Transactional
	public String addBuyerTab(String data) {
		logger.info("/addBuyerTab data: "+data);
		BuyerTab buyertab = JSON.parseObject(data,BuyerTab.class);
		int flog = buyerTabDao.addBuyerTab(buyertab);
		if(flog>=0) {
			//添加送货地址
			logger.info("/URL: "+"http://test.cloud-scale.cn/client/"+buyertab.getNineteen_id());
			//logger.info("/URL: "+"http://tl-service.hzgas.cn/client/"+buyertab.getNineteen_id());
			String result= HttpReq.httpRequest("http://test.cloud-scale.cn/client/"+buyertab.getNineteen_id(),"GET", null);
			HashMap<String,String> resuMap  =JSON.parseObject(result,HashMap.class);
			ArrayList<String> addList = JSON.parseObject(JSON.toJSONString(resuMap.get("accounts")),ArrayList.class);
			for(int i=0;i<addList.size();i++) {
				HashMap<String,Object> accountsMap = JSON.parseObject(JSON.toJSONString(addList.get(i)), HashMap.class);
				HashMap<String,Object> jddeMap = new HashMap<String,Object>();
				jddeMap.put("uCode", accountsMap.get("address_code"));
				DeliveryAddrTab addrTab = new DeliveryAddrTab();
				try {
					String temp = HttpReq.httpRequestsfrom("http://test.cloud-scale.cn/TransferSystem/query/userInfo","POST",jddeMap);
					HashMap<String,Object> hgdwMap = JSON.parseObject(temp, HashMap.class);
					addrTab.setDeli_jdde(hgdwMap.get("hgdw").toString());
				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
				}finally {
					addrTab.setBuye_id(buyertab.getBuye_id());
					addrTab.setDeli_addr(accountsMap.get("address").toString());
					addrTab.setDeli_contacts(accountsMap.get("name").toString());
					addrTab.setDeli_phone(accountsMap.get("phone").toString());
					addrTabDao.addDeliveryAddrTab(addrTab);
					
				}

			}
			
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("buye_id", buyertab.getBuye_id());
			return JSON.toJSONString(Count.counts(null, 0,map ,200,"addBuyerTab success"));
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询买家信息
	 */
	@Override
	public String queryBuyerTab(String data) {
		logger.info("/queryBuyerTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> arrayList = buyerTabDao.queryBuyerTab(hashmap);
		int count = buyerTabDao.queryBuyerTabCount(hashmap);
		for(int i=0;i<arrayList.size();i++) {
			ArrayList<HashMap<String,Object>> DeliveryAddrTab = addrTabDao.queryDeliveryAddrTab(arrayList.get(i));
			arrayList.get(i).put("DeliveryAddrTab", DeliveryAddrTab);
		}
		//arrayList = Count.count(arrayList, count, hashmap);
		return JSON.toJSONString(Count.counts(arrayList, count, hashmap,200,"queryBuyerTab success"));
	}
	/**
	 *更新买家信息
	 */
	@Override
	public String updateBuyerTab(String data) {
		logger.info("/updateBuyerTab data: "+data);
		BuyerTab buyertab = JSON.parseObject(data,BuyerTab.class);
		int flog = buyerTabDao.updateBuyerTab(buyertab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除买家信息
	 */
	@Transactional
	public String deleteBuyerTab(String data) {
		logger.info("/updateBuyerTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int buye_id = list.get(i);
			int flog = buyerTabDao.deleteBuyerTab(buye_id);
			if(flog<=0) {
				retlist.add(buye_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
