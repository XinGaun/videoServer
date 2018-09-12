package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.InstallUnitTabDao;
import com.entity.InstallUnitTab;
import com.service.InstallUnitTabSercice;
import com.util.Count;
import com.util.Page;
/**
 * 安装单位信息Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class InstallUnitTabSerciceImpl implements InstallUnitTabSercice {
	@Autowired
	private InstallUnitTabDao installUnitTabDao;//调用安装单位Dao层接口
	private Logger logger = Logger.getLogger(InstallUnitTabSerciceImpl.class);
	/**
	 * 添加安装单位
	 */
	@Override
	public String addInstallUnitTab(String data) {
		logger.info("/addInstallUnitTab data: "+data);
		InstallUnitTab installUnitTab = JSON.parseObject(data, InstallUnitTab.class);
		int flog = installUnitTabDao.addInstallUnitTab(installUnitTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询安装单位
	 */
	@Override
	public String queryInstallUnitTab(String data) {
		logger.info("/queryInstallUnitTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = installUnitTabDao.queryInstallUnitTab(hashMap);
		int count = installUnitTabDao.queryInstallUnitTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryInstallUnitTab success"));
	}
	/**
	 * 更新安装单位
	 */
	@Override
	public String updateInstallUnitTab(String data) {
		logger.info("/updateInstallUnitTab data: "+data);
		InstallUnitTab installUnitTab = JSON.parseObject(data, InstallUnitTab.class);
		int flog = installUnitTabDao.updateInstallUnitTab(installUnitTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除安装单位
	 */
	@Transactional
	public String deleteInstallUnitTab(String data) {
		logger.info("/deleteInstallUnitTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int inst_unit_id = list.get(i);
			int flog = installUnitTabDao.deleteInstallUnitTab(inst_unit_id);
			if(flog<=0) {
				retlist.add(inst_unit_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
