package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.RoleTabDao;
import com.dao.StaffTabDao;
import com.entity.RoleTab;
import com.service.RoleTabService;
import com.util.Count;

/**
 * 角色Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class RoleTabServiceImpl implements RoleTabService {
	@Autowired
	private RoleTabDao roleTabDao;//调用角色Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	private Logger logger = Logger.getLogger(RoleTabServiceImpl.class);
	/**
	 * 添加角色
	 */
	@Override
	public String addRoleTab(String data) {
		logger.info("/addRoleTab data: "+data);
		RoleTab roleTab =JSON.parseObject(data,RoleTab.class);
		int flog = roleTabDao.addRoleTab(roleTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询角色
	 */
	@Override
	public String queryRoleTab(String data) {
		logger.info("/queryRoleTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		//hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list =roleTabDao.queryaddRole(hashMap);
		/*for(int i=0;i<list.size();i++) {
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("staf_role_id",list.get(i).get("role_id"));
			ArrayList<HashMap<String,Object>> staff =staffTabDao.queryStaffTab(map);
			list.get(i).put("staff", staff);
		}
		int count =roleTabDao.queryaddRoleCount(hashMap);*/
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, 0, hashMap,200,"queryRoleTab success"));
	}
	/**
	 * 修改角色
	 */
	@Override
	public String updateRoleTab(String data) {
		logger.info("/updateRoleTab data: "+data);
		RoleTab roleTab =JSON.parseObject(data,RoleTab.class);
		int flog =roleTabDao.updateRole(roleTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除角色
	 */
	@Transactional
	public String deleteRoleTab(String data) {
		logger.info("/deleteRoleTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int role_id = list.get(i);
			int flog = roleTabDao.deleteRole(role_id);
			if(flog<=0) {
				retlist.add(role_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
}
