package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.ShopTabDao;
import com.entity.ShopTab;
import com.service.ShopTabService;
import com.util.Count;
import com.util.Page;
/**
 * 门店信息Service层实现类
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class ShopTabServiceImpl implements ShopTabService {
	@Autowired
	private ShopTabDao shopTabDao;//调用门店信息Dao层接口
	private Logger logger = Logger.getLogger(ShopTabServiceImpl.class);

	/**
	 * 添加门店信息
	 */
	@Override
	public String addShopTab(String data) {
		logger.info("/addShopTab data:" +data);
		ShopTab shoptab = JSON.parseObject(data,ShopTab.class);
		int flog =shopTabDao.addShopTab(shoptab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询门店信息
	 */
	@Override
	public String queryShopTab(String data) {
		logger.info("/queryShopTab data:" +data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap= Page.page(datamap);
		ArrayList<HashMap<String,Object>> shoplist = shopTabDao.queryShopTab(datamap); 
		int count =shopTabDao.queryShopTabCount(datamap);
		//shoplist =Count.count(shoplist, count, datamap);
		return JSON.toJSONString(Count.counts(shoplist, count, datamap,200,"queryShopTab success"));
	}
	/**
	 * 更新门店信息
	 */
	@Override
	public String updateShopTab(String data) {
		logger.info("/updateShopTab data:" +data);
		ShopTab shoptab = JSON.parseObject(data,ShopTab.class);
		int flog = shopTabDao.updateShopTab(shoptab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除门店信息
	 */
	@Transactional
	public String deleteShopTab(String data) {
		logger.info("/deleteShopTab data:" +data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int shop_id = list.get(i);
			int flog = shopTabDao.deleteShopTab(shop_id);
			if(flog<=0) {
				retlist.add(shop_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
