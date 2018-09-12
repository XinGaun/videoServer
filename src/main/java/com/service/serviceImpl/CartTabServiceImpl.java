package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CartTabDao;
import com.entity.CartTab;
import com.service.CartTabService;
import com.util.Count;
import com.util.Page;
/**
 * 购物车Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class CartTabServiceImpl implements CartTabService {
	@Autowired
	private CartTabDao cartTabDao;//调用购物车Dao层接口
	private Logger logger = Logger.getLogger(CartTabServiceImpl.class);
	/**
	 * 添加购物车
	 */
	@Override
	public String addCartTab(String data) {
		logger.info("/addCartTab data: "+data);
		CartTab cartTab =JSON.parseObject(data,CartTab.class);
		int flog = cartTabDao.addCartTab(cartTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询购物车
	 */
	@Override
	public String queryCartTab(String data) {
		logger.info("/queryCartTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> list = cartTabDao.queryCartTab(hashmap);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("comm_else_img")) {
				ArrayList<String> commMap = JSON.parseObject(list.get(i).get("comm_else_img").toString(), ArrayList.class);
				list.get(i).put("comm_else_img", commMap);
			}
			if(list.get(i).containsKey("comm_specification")) {
				HashMap<String, Object> commMap = JSON.parseObject(list.get(i).get("comm_specification").toString(), HashMap.class);
				list.get(i).put("comm_specification", commMap);
			}
		}
		int count =cartTabDao.queryCartTabCount(hashmap);
		//list = Count.count(list, count, hashmap);
		return JSON.toJSONString(Count.counts(list, count, hashmap,200,"queryCartTab success"));
	}
	/**
	 * 更新购物车
	 */
	@Override
	public String updateCartTab(String data) {
		logger.info("/updateCartTab data: "+data);
		CartTab cartTab =JSON.parseObject(data,CartTab.class);
		int flog = cartTabDao.updateCartTab(cartTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除购物车
	 */
	@Transactional
	public String deleteCartTab(String data) {
		logger.info("/deleteCartTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int cart_id = list.get(i);
			int flog = cartTabDao.deleteCartTab(cart_id);
			if(flog<=0) {
				retlist.add(cart_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
