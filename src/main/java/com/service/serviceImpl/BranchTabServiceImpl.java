package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.BranchTabDao;
import com.service.BranchTabService;
import com.util.Count;
/**
 * 分公司service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class BranchTabServiceImpl implements BranchTabService {
	@Autowired
	private BranchTabDao branchTabDao;//分公司Dao层接口
	private Logger logger = Logger.getLogger(BranchTabServiceImpl.class);
	/**
	 * 添加分公司
	 */
	@Override
	public String addBranchTab(String data) {
		logger.info("/addBranchTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		int flog = branchTabDao.addBranchTab(hashmap);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	
	/**
	 * 查询分公司
	 */
	@Override
	public String queryBranchTab(String data) {
		logger.info("/queryBranchTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = branchTabDao.queryBranchTab(hashmap);	
		return JSON.toJSONString(Count.counts(list, 0, hashmap,200,"queryBranchTab success"));
	}

	/**
	 * 更新分公司
	 */
	@Override
	public String updateBranchTab(String data) {
		logger.info("/updateBranchTab data: "+data);
		HashMap<String,Object> hashmap = JSON.parseObject(data, HashMap.class);
		int flog = branchTabDao.updateBranchTab(hashmap);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除分公司
	 */
	@Override
	public String deleteBranchTab(String data) {
		logger.info("/deleteBranchTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int branch_id = list.get(i);
			int flog = branchTabDao.deleteBranchTab(branch_id);
			if(flog<=0) {
				retlist.add(branch_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
