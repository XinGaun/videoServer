package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.StaffLogTabDao;
import com.dao.StaffTabDao;
import com.entity.StaffLogTab;
import com.service.StaffLogTabService;
import com.util.Count;
import com.util.Page;
/**
 * 员工日志Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class StaffLogTabServiceImpl implements StaffLogTabService{
	@Autowired
	private StaffLogTabDao logTabDao;//调用员工日志Dao层
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	private Logger logger = Logger.getLogger(StaffLogTabServiceImpl.class);
	/**
	 * 添加员工日志信息
	 */
	@Override
	public String addStaffLogTab(String data) {
		logger.info("/addStaffLogTab data: "+data);
		StaffLogTab staffLogTab = JSON.parseObject(data, StaffLogTab.class);
		int flog = logTabDao.addStaffLogTab(staffLogTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询员工日志信息
	 */
	@Override
	public String queryStaffLogTab(String data) {
		logger.info("/queryStaffLogTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = logTabDao.queryStaffLogTab(hashMap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
			list.get(i).put("staff", staff);
		}
		int count = logTabDao.queryStaffLogTabCount(hashMap);
		//list=Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryStaffLogTab success"));
	}
	/**
	 * 更新员工日志信息
	 */
	@Override
	public String updateStaffLogTab(String data) {
		logger.info("/updateStaffLogTab data: "+data);
		StaffLogTab staffLogTab = JSON.parseObject(data, StaffLogTab.class);
		int flog = logTabDao.updateStaffLogTab(staffLogTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除员工日志信息
	 */
	@Transactional
	public String deleteStaffLogTab(String data) {
		logger.info("/deleteStaffLogTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int staff_log_id = list.get(i);
			int flog = logTabDao.deleteStaffLogTab(staff_log_id);
			if(flog<=0) {
				retlist.add(staff_log_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	
}
