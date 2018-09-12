package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CommodityTabDao;
import com.dao.DiscussTabDao;
import com.entity.DiscussTab;
import com.service.DiscussTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 评论表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class DiscussTabServiceImpl implements DiscussTabService {
	@Autowired
	private DiscussTabDao discussTabDao;//调用评论Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	private Logger logger = Logger.getLogger(DiscussTabServiceImpl.class);
	/**
	 * 添加评论信息
	 */
	@Override
	public String addDiscussTab(String data) {
		logger.info("/addDiscussTab data: "+data);
		DiscussTab discussTab = JSON.parseObject(data, DiscussTab.class);
		int flog = discussTabDao.addDiscussTab(discussTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询评论信息
	 */
	@Override
	public String queryDiscussTab(String data) {
		logger.info("/queryDiscussTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = discussTabDao.queryDiscussTab(hashMap);
		int count = discussTabDao.queryDiscussTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryDiscussTab success"));
	}
	/**
	 * 更新评论信息
	 */
	@Override
	public String updateDiscussTab(String data) {
		logger.info("/updateDiscussTab data: "+data);
		DiscussTab discussTab = JSON.parseObject(data, DiscussTab.class);
		discussTab.setDisc_reply_date(DateUtil.getNowDate());
		int flog = discussTabDao.updateDiscussTab(discussTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除评论信息
	 */
	@Transactional
	public String deleteDiscussTab(String data) {
		logger.info("/deleteDiscussTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int disc_id = list.get(i);
			int flog = discussTabDao.deleteDiscussTab(disc_id);
			if(flog<=0) {
				retlist.add(disc_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
