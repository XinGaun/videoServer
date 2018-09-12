package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.BranchesReceiveDao;
import com.entity.BrandTab;
import com.entity.CategoryTab;
import com.entity.CommodityTab;
import com.entity.SpecificationsTab;
import com.entity.SupplierTab;
import com.service.BranchesReceiveService;
/**
 * 总实例推送信息Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class BranchesReceiveServiceImpl implements BranchesReceiveService {
	@Autowired
	private BranchesReceiveDao branchesReceiveDao;
	private Logger logger = Logger.getLogger(BranchesReceiveServiceImpl.class);
	/**
	 * 添加推送商品信息
	 */
	@Override
	public String addPushCommodity(String data) {
		logger.info("addPushCommodity data: "+data);
		CommodityTab commodityTab = JSON.parseObject(data, CommodityTab.class);
		int flog = branchesReceiveDao.addPushCommodity(commodityTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新推送商品信息
	 */
	@Override
	public String updatePushCommodity(String data) {
		logger.info("updatePushCommodity data: "+data);
		CommodityTab commodityTab = JSON.parseObject(data, CommodityTab.class);
		int flog = branchesReceiveDao.updatePushCommodity(commodityTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除商品推送信息
	 */
	@Override
	public String deletePushCommodity(String data) {
		logger.info("deletePushCommodity data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int comm_putaway_id = list.get(i);
			int flog = branchesReceiveDao.deletePushCommodity(comm_putaway_id);
			if(flog<=0) {
				retlist.add(comm_putaway_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 添加推送品类信息
	 */
	@Override
	public String addPushCategory(String data) {
		logger.info("addPushCategory data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = branchesReceiveDao.addPushCategory(categoryTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新推送品类信息
	 */
	@Override
	public String updatePushCategory(String data) {
		logger.info("updatePushCategory data: "+data);
		CategoryTab categoryTab = JSON.parseObject(data, CategoryTab.class);
		int flog = branchesReceiveDao.updatePushCategory(categoryTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 添加推送商品规格信息
	 */
	@Override
	public String addPushSpecifications(String data) {
		logger.info("addPushSpecifications data: "+data);
		ArrayList<String> purchaseTab = JSON.parseObject(data, ArrayList.class);
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<purchaseTab.size();i++) {
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(purchaseTab.get(i)), HashMap.class);
			int flog = branchesReceiveDao.addPushSpecifications(map);
			if(flog<=0) {
				list.add(map);
			}
		}
		if(list.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新推送商品规格信息
	 */
	@Override
	public String updatePushSpecifications(String data) {
		logger.info("updatePushSpecifications data: "+data);
		SpecificationsTab specificationsTab = JSON.parseObject(data, SpecificationsTab.class);
		int flog = branchesReceiveDao.updatePushSpecifications(specificationsTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 添加总实例推送的供应商信息
	 */
	@Transactional
	public String addPushSupplier(String data) {
		logger.info("addPushSupplier data: "+data);
		SupplierTab supplierTab = JSON.parseObject(data, SupplierTab.class);
		int flog = branchesReceiveDao.addPushSupplier(supplierTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新总实例推送的供应商信息
	 */
	@Transactional
	public String updatePushSupplier(String data) {
		logger.info("addPushSupplier data: "+data);
		SupplierTab supplierTab = JSON.parseObject(data, SupplierTab.class);
		int flog = branchesReceiveDao.updatePushSupplier(supplierTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 添加推送品牌信息
	 */
	@Override
	public String addPushBrand(String data) {
		logger.info("addPushBrand data: "+data);
		BrandTab brandTab = JSON.parseObject(data, BrandTab.class);
		int flog = branchesReceiveDao.addPushBrand(brandTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 更新推送的品牌信息
	 */
	@Override
	public String updatePushBrand(String data) {
		logger.info("updatePushBrand data: "+data);
		BrandTab brandTab = JSON.parseObject(data, BrandTab.class);
		int flog = branchesReceiveDao.updatePushBrand(brandTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}


}
