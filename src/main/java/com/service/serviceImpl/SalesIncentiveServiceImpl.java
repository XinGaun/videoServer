package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.SalesIncentiveDao;
import com.service.SalesIncentiveService;
import com.util.Count;
/**
 * 销售记录配置Service层实现类
 * @author 87518
 *
 */
@SuppressWarnings("unchecked")
@Service
public class SalesIncentiveServiceImpl implements SalesIncentiveService {
	@Autowired
	private SalesIncentiveDao salesIncentiveDao;
	private Logger logger = Logger.getLogger(SalesIncentiveServiceImpl.class);
	/**
	 * 添加销售记录团队类型
	 */
	@Override
	public String addSalesteamTypeTab(String data) {
		logger.info("/addSalesteamTypeTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.addSalesteamTypeTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"addSalesteamTypeTab success",map);
		}else {
			return Count.resultMap(null,401,"addSalesteamTypeTab error",map);
		}
		
	}
	/**
	 * 查询销售团队类型
	 */
	@Override
	public String querySalesteamTypeTab(String data) {
		logger.info("/querySalesteamTypeTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = salesIncentiveDao.querySalesteamTypeTab(map);
		return Count.resultMap(list,200,"querySalesteamTypeTab success",map);
	}
	/**
	 * 更新销售团队类型
	 */
	@Override
	public String updateSalesteamTypeTab(String data) {
		logger.info("/updateSalesteamTypeTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.updateSalesteamTypeTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"updateSalesteamTypeTab success",map);
		}else {
			return Count.resultMap(null,401,"updateSalesteamTypeTab error",map);
		}
	}
	/**
	 * 删除销售团队类型
	 */
	@Transactional
	public String deleteSalesteamTypeTab(String data) {
		logger.info("/deleteSalesteamTypeTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		int flog = salesIncentiveDao.deleteSalesteamTypeTab(list);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("parameter", list);
		if(flog>0) {
			return Count.resultMap(null,200,"deleteSalesteamTypeTab success",map);
		}else {
			return Count.resultMap(null,401,"deleteSalesteamTypeTab error",map);
		}
	}
	/**
	 * 添加销售团队信息
	 */
	@Override
	public String addSalesteamTab(String data) {
		logger.info("/addSalesteamTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.addSalesteamTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"addSalesteamTab success",map);
		}else {
			return Count.resultMap(null,401,"addSalesteamTab error",map);
		}
	}
	/**
	 * 查询销售团队信息
	 */
	@Override
	public String querySalesteamTab(String data) {
		logger.info("/querySalesteamTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = salesIncentiveDao.querySalesteamTab(map);
		return Count.resultMap(list,200,"querySalesteamTab success",map);
	}
	/**
	 * 更新销售团队信息
	 */
	@Override
	public String updateSalesteamTab(String data) {
		logger.info("/updateSalesteamTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.updateSalesteamTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"updateSalesteamTab success",map);
		}else {
			return Count.resultMap(null,401,"updateSalesteamTab error",map);
		}
	}
	/**
	 * 删除销售团队信息
	 */
	@Override
	public String deleteSalesteamTab(String data) {
		logger.info("/deleteSalesteamTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		int flog = salesIncentiveDao.deleteSalesteamTab(list);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("parameter", list);
		if(flog>0) {
			return Count.resultMap(null,200,"deleteSalesteamTab success",map);
		}else {
			return Count.resultMap(null,401,"deleteSalesteamTab error",map);
		}
	}
	/**
	 * 添加销售团队员工
	 */
	@Override
	public String addSalesteamStaffMiddleTab(String data) {
		logger.info("/addSalesteamStaffMiddleTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.addSalesteamStaffMiddleTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"addSalesteamStaffMiddleTab success",map);
		}else {
			return Count.resultMap(null,401,"addSalesteamStaffMiddleTab error",map);
		}
	}
	/**
	 * 删除销售团队员工
	 */
	@Override
	public String deleteSalesteamStaffMiddleTab(String data) {
		logger.info("/deleteSalesteamStaffMiddleTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		int flog = salesIncentiveDao.deleteSalesteamStaffMiddleTab(list);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("parameter", list);
		if(flog>0) {
			return Count.resultMap(null,200,"deleteSalesteamStaffMiddleTab success",map);
		}else {
			return Count.resultMap(null,401,"deleteSalesteamStaffMiddleTab error",map);
		}
	}
	/**
	 * 查询成员信息
	 */
	@Override
	public String querySalesteamStaffMiddleTab(String data) {
		logger.info("/querySalesteamStaffMiddleTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = salesIncentiveDao.querySalesteamStaffMiddleTab(map);
		return Count.resultMap(list,200,"querySalesteamStaffMiddleTab success",map);
	}
	/**
	 * 添加品类提成配置信息
	 */
	@Override
	public String addCommissionsTab(String data) {
		logger.info("/addCommissionsTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.addCommissionsTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"addCommissionsTab success",map);
		}else {
			return Count.resultMap(null,401,"addCommissionsTab error",map);
		}
	}
	/**
	 * 查询品类提成配置信息
	 */
	@Override
	public String queryCommissionsTab(String data) {
		logger.info("/queryCommissionsTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = salesIncentiveDao.queryCommissionsTab(map);
		return Count.resultMap(list,200,"queryCommissionsTab success",map);
	}
	/**
	 * 更新品类提成配置信息
	 */
	@Override
	public String updateCommissionsTab(String data) {
		logger.info("/updateCommissionsTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.updateCommissionsTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"updateCommissionsTab success",map);
		}else {
			return Count.resultMap(null,401,"updateCommissionsTab error",map);
		}
	}
	/**
	 * 删除品类提成配置信息
	 */
	@Override
	public String deleteCommissionsTab(String data) {
		logger.info("/deleteCommissionsTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		int flog = salesIncentiveDao.deleteCommissionsTab(list);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("parameter", list);
		if(flog>0) {
			return Count.resultMap(null,200,"deleteCommissionsTab success",map);
		}else {
			return Count.resultMap(null,401,"deleteCommissionsTab error",map);
		}
	}
	/**
	 * 添加考核额度信息
	 */
	@Override
	public String addAssessTab(String data) {
		logger.info("/addAssessTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.addAssessTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"addAssessTab success",map);
		}else {
			return Count.resultMap(null,401,"addAssessTab error",map);
		}
	}
	/**
	 *  查询考核额度信息
	 */
	@Override
	public String queryAssessTab(String data) {
		logger.info("/queryAssessTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = salesIncentiveDao.queryAssessTab(map);
		return Count.resultMap(list,200,"queryAssessTab success",map);
	}
	/**
	 * 修改考核额度表信息
	 */
	@Override
	public String updateAssessTab(String data) {
		logger.info("/updateAssessTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = salesIncentiveDao.updateAssessTab(map);
		if(flog>0) {
			return Count.resultMap(null,200,"updateAssessTab success",map);
		}else {
			return Count.resultMap(null,401,"updateAssessTab error",map);
		}
	}
	/**
	 * 删除考核额度表信息
	 */
	@Override
	public String deleteAssessTab(String data) {
		logger.info("/deleteAssessTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		int flog = salesIncentiveDao.deleteAssessTab(list);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("parameter", list);
		if(flog>0) {
			return Count.resultMap(null,200,"deleteAssessTab success",map);
		}else {
			return Count.resultMap(null,401,"deleteAssessTab error",map);
		}
	}

}
