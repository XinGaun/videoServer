package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.InstallTabDao;
import com.entity.InstallTab;
import com.service.InstallTabService;
import com.util.Count;
import com.util.Page;
/**
 * 安装单信息Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class InstallTabServiceImpl implements InstallTabService {
	@Autowired
	private InstallTabDao installTabDao;//调用安装单Dao层接口
	private Logger logger = Logger.getLogger(InstallTabServiceImpl.class);
	/**
	 * 添加安装单信息
	 */
	@Override
	public String addInstallTab(String data) {
		logger.info("/addInstallTab data: "+data);
		InstallTab installTab = JSON.parseObject(data, InstallTab.class);
		int flog = installTabDao.addInstallTab(installTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询安装单信息
	 */
	@Override
	public String queryInstallTab(String data) {
		logger.info("/queryInstallTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		hashmap = Page.page(hashmap);
		ArrayList<HashMap<String,Object>> arrayList = installTabDao.queryInstallTab(hashmap);
		int count = installTabDao.queryInstallTabCount(hashmap);
		//arrayList = Count.count(arrayList, count, hashmap);
		return JSON.toJSONString(Count.counts(arrayList, count, hashmap,200,"queryInstallTab success"));
	}
	/**
	 * 更新安装单信息
	 */
	@Override
	public String updateInstallTab(String data) {
		logger.info("/updateInstallTab data: "+data);
		InstallTab installTab = JSON.parseObject(data, InstallTab.class);
		int flog = installTabDao.updateInstallTab(installTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新安装单信息
	 */
	@Transactional
	public String updateInstallTabAll(String data) {
		logger.info("/updateInstallTabAll data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("inst_status","已安装");
		map.put("status", "已安装");
		for(int i=0;i<list.size();i++) {
			map.put("inst_id", list.get(i));
			installTabDao.updateSignDeliverTabAll(map);//更新安装单信息
			installTabDao.updateOrder(map);
		}
		return JSON.toJSONString("success");

	}
	/**
	 * 删除安装单信息
	 */
	@Transactional
	public String deleteInstallTab(String data) {
		logger.info("/deleteInstallTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int inst_id = list.get(i);
			int flog = installTabDao.deleteInstallTab(inst_id);
			if(flog<=0) {
				retlist.add(inst_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
