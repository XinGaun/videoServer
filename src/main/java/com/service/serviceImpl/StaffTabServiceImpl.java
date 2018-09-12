package com.service.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.StaffTabDao;
import com.entity.StaffTab;
import com.service.StaffTabService;
import com.util.Count;
import com.util.MD5;
import com.util.Page;
/**
 * 员工Service层实现类
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class StaffTabServiceImpl implements StaffTabService {
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	private Logger logger = Logger.getLogger(StaffTabServiceImpl.class);
	/**
	 * 添加员工信息
	 */
	@Override
	public String addStaffTab(String data) {
		logger.info("/addStaffTab data: "+data);
		StaffTab staffTab = JSON.parseObject(data, StaffTab.class);
		String pwd = staffTab.getStaf_pwd();
		pwd = MD5.md5(pwd);
		staffTab.setStaf_pwd(pwd);
		int flog = staffTabDao.addStaffTab(staffTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询员工信息
	 */
	@Override
	public String queryStaffTab(String data) {
		logger.info("/queryStaffTab data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap= Page.page(datamap);
		ArrayList<HashMap<String,Object>> list = staffTabDao.queryStaffTab(datamap);
		int count = staffTabDao.queryStaffTabCount(datamap);
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"queryStaffTab success"));
	}
	/**
	 * 更新员工信息
	 */
	@Override
	public String updateStaffTab(String data) {
		logger.info("/updateStaffTab data: "+data);
		StaffTab staffTab = JSON.parseObject(data, StaffTab.class);
		String pwd = staffTab.getStaf_pwd();
		if(pwd!=null&&pwd!="") {
			pwd = MD5.md5(pwd);
			staffTab.setStaf_pwd(pwd);
		}
		int flog = staffTabDao.updateStaffTab(staffTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除员工信息
	 */
	@Transactional
	public String deleteStaffTab(String data) {
		logger.info("/deleteStaffTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int staf_id = list.get(i);
			int flog = staffTabDao.deleteStaffTab(staf_id);
			if(flog<=0) {
				retlist.add(staf_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 验证登录信息
	 */
	@Override
	public String loginStaff(String data) {
		logger.info("/loginStaff data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		String staf_pwd = datamap.get("staf_pwd").toString();
		staf_pwd = MD5.md5(staf_pwd);
		ArrayList<HashMap<String,Object>> list = staffTabDao.queryStaffTab(datamap);
		if(list==null||list.size()<=0) {
			return JSON.toJSONString(Count.counts(null, 0, null,401,"The user does not exist"));
		}else {
			if(staf_pwd.equals(list.get(0).get("staf_pwd"))) {
				StaffTab staffTab = new StaffTab();
				staffTab.setStaf_id(Integer.parseInt(list.get(0).get("staf_id").toString()));
				Date now=new Date();
		        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		        String tablename=dateFormat.format(now);
		        staffTab.setStaf_date(tablename);
		        staffTabDao.updateStaffTab(staffTab);
				return JSON.toJSONString(Count.counts(list, 0, datamap,200,"loginStaff success"));
			}
			return JSON.toJSONString(Count.counts(null, 0, null,400,"wrong password"));
		}
		
	}

}
