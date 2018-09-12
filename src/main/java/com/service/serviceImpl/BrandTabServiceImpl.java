package com.service.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.BrandTabDao;
import com.dao.CategoryTabDao;
import com.dao.CommodityTabDao;
import com.dao.ExampleTabDao;
import com.dao.SupplierTabDao;
import com.entity.BrandTab;
import com.entity.ExampleTab;
import com.service.BrandTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
/**
 * 品牌Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class BrandTabServiceImpl implements BrandTabService {
	@Autowired
	private BrandTabDao brandTabDao;//调用品牌Dao层接口
	@Autowired
	private SupplierTabDao supplierTabDao;//调用供应商Dao层接口
	@Autowired
	private CategoryTabDao categoryTabDao;//调用品类Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(BrandTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathbrand = "/Brand/";
	/**
	 * 添加品牌
	 */
	@Transactional
	public String addBrandTab(HttpServletRequest req, HttpServletResponse res, MultipartFile brand_logo,
			String brand_name, int brand_weight, int brand_supp_id, int brand_cate_id,String lock_status) {
		logger.info("/addBrandTab data: brand_name="+brand_name+",brand_weight="+brand_weight+",brand_supp_id="+brand_supp_id+",brand_cate_id="+brand_cate_id);
		BrandTab brandTab = new BrandTab();
		brandTab.setBrand_name(brand_name);
		brandTab.setBrand_cate_id(brand_cate_id);
		brandTab.setBrand_supp_id(brand_supp_id);
		brandTab.setBrand_weight(brand_weight);
		brandTab.setLock_status(lock_status);
		logger.info("/addBrandTab savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = brand_logo.getOriginalFilename();//获得文件名称
		logger.info("/addBrandTab FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
				projectFileFlog = 1;
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				brandTab.setBrand_logo(pathbrand+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathbrand+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				brand_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
				projectupdate = brandTabDao.addBrandTab(brandTab);
			}
			if(projectFileFlog==-1&&projectupdate>0) {
				return JSON.toJSONString("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询品牌信息
	 */
	@Override
	public String queryBrandTab(String data) {
		logger.info("/queryBrandTab data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap = Page.page(datamap);
		if(datamap.containsKey("cate_id")) {
			ArrayList<Integer> tatilList = new ArrayList<Integer>();
			tatilList.add(Integer.parseInt(datamap.get("cate_id").toString()));

			ArrayList<Integer> cateListTow =null;
			ArrayList<Integer> cateListThree = null;
			HashMap<String,Object> cateMap = new HashMap<String,Object>();

			cateMap.put("cate_superior", tatilList.get(0));
			cateListTow = commodityTabDao.queryCategoryID(cateMap);//查询二级品类
			tatilList.addAll(cateListTow);
			for(int s=0;s<cateListTow.size();s++) {
				cateMap.put("cate_superior", cateListTow.get(s));
				cateListThree = commodityTabDao.queryCategoryID(cateMap);//查询三级品类
				tatilList.addAll(cateListThree);

			}
			datamap.put("cate_id", tatilList);
		}
		ArrayList<HashMap<String,Object>> list = brandTabDao.queryBrandTab(datamap);
		
		HashMap<String,Object> quertMap = new HashMap<String,Object>();
		for(int i=0;i<list.size();i++) {
			quertMap.put("brand_supp_id",list.get(i).get("brand_supp_id"));
			quertMap.put("brand_cate_id", list.get(i).get("brand_cate_id"));
			ArrayList<HashMap<String,Object>> supplier = supplierTabDao.querySupplierTab(quertMap);
			ArrayList<HashMap<String,Object>> category = categoryTabDao.queryCategoryTab(quertMap);
			list.get(i).put("supplier", supplier);
			list.get(i).put("category", category);
		}
		int count = brandTabDao.queryBrandTabCount(datamap);
		datamap.put("cate_id", "");
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"queryBrandTab success"));
	}
	/**
	 * 更新品牌信息
	 */
	@Transactional
	public String updateBrandTab(HttpServletRequest req, HttpServletResponse res, MultipartFile brand_logo,
			String brand_name, int brand_weight, int brand_supp_id, int brand_cate_id,int brand_id,String lock_status) {
		logger.info("/updateBrandTab data: brand_name="+brand_name+",brand_weight="+brand_weight+",brand_supp_id="+brand_supp_id+",brand_cate_id="+brand_cate_id);
		BrandTab brandTab = new BrandTab();
		brandTab.setLock_status(lock_status);
		brandTab.setBrand_id(brand_id);
		brandTab.setBrand_name(brand_name);
		brandTab.setBrand_cate_id(brand_cate_id);
		brandTab.setBrand_supp_id(brand_supp_id);
		brandTab.setBrand_weight(brand_weight);
		logger.info("/updateBrandTab savePath: "+savePath);
		int projectupdate =-1;
		String FilePath = null;
		if(brand_logo!=null) {
			FilePath = brand_logo.getOriginalFilename();//获得文件名称
		}
		logger.info("/updateBrandTab FilePath: "+FilePath);
		try {
			if(FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				brandTab.setBrand_logo(pathbrand+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathbrand+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				brand_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			projectupdate = brandTabDao.updateBrandTab(brandTab);
			if(projectupdate>0) {
				return JSON.toJSONString("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除品牌信息
	 */
	@Override
	public String deleteBrandTab(String data) {
		logger.info("/deleteBrandTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int brand_id = list.get(i);
			int flog = brandTabDao.deleteBrandTab(brand_id);
			if(flog<=0) {
				retlist.add(brand_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 总实体类添加品牌信息
	 */
	@Transactional
	public String addPushBrand(HttpServletRequest req, HttpServletResponse res, MultipartFile brand_logo,
			String brand_name, int brand_weight, int brand_supp_id, int brand_cate_id, String lock_status) {
		logger.info("/addPushBrand data: brand_name="+brand_name+",brand_weight="+brand_weight+",brand_supp_id="+brand_supp_id+",brand_cate_id="+brand_cate_id);
		BrandTab brandTab = new BrandTab();
		brandTab.setBrand_name(brand_name);
		brandTab.setBrand_cate_id(brand_cate_id);
		brandTab.setBrand_supp_id(brand_supp_id);
		brandTab.setBrand_weight(brand_weight);
		brandTab.setLock_status(lock_status);
		logger.info("/addPushBrand savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = brand_logo.getOriginalFilename();//获得文件名称
		logger.info("/addPushBrand FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
				projectFileFlog = 1;
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				brandTab.setBrand_logo(pathbrand+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathbrand+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				brand_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
				projectupdate = brandTabDao.addBrandTab(brandTab);
			}
			//1.获取需要推送的地址IP
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/addPushBrand", "POST",JSON.toJSONString(brandTab));
				resultList.put(exampleList.get(i).getExample_name(), result);
			}
			
			if(projectFileFlog==-1&&projectupdate>0) {
				HashMap<String,Object> returnMap = new HashMap<String,Object>();
				returnMap.put("code", 200);
				returnMap.put("msg", resultList);
				return JSON.toJSONString(returnMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 总实体修改品牌信息
	 */
	@Transactional
	public String updatePushBrandTab(HttpServletRequest req, HttpServletResponse res, MultipartFile brand_logo,
			String brand_name, int brand_weight, int brand_supp_id, int brand_cate_id, int brand_id,
			String lock_status) {
		logger.info("/updatePushBrandTab data: brand_name="+brand_name+",brand_weight="+brand_weight+",brand_supp_id="+brand_supp_id+",brand_cate_id="+brand_cate_id);
		BrandTab brandTab = new BrandTab();
		brandTab.setLock_status(lock_status);
		brandTab.setBrand_id(brand_id);
		brandTab.setBrand_name(brand_name);
		brandTab.setBrand_cate_id(brand_cate_id);
		brandTab.setBrand_supp_id(brand_supp_id);
		brandTab.setBrand_weight(brand_weight);
		logger.info("/updateBrandTab savePath: "+savePath);
		int projectupdate =-1;
		String FilePath = null;
		if(brand_logo!=null) {
			FilePath = brand_logo.getOriginalFilename();//获得文件名称
		}
		logger.info("/updateBrandTab FilePath: "+FilePath);
		try {
			if(FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				brandTab.setBrand_logo(pathbrand+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathbrand+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				brand_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			projectupdate = brandTabDao.updateBrandTab(brandTab);
			//1.获取需要推送的地址IP
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/updatePushBrand", "POST",JSON.toJSONString(brandTab));
				resultList.put(exampleList.get(i).getExample_name(), result);
			}
			if(projectupdate>0) {
				HashMap<String,Object> returnMap = new HashMap<String,Object>();
				returnMap.put("code", 200);
				returnMap.put("msg", resultList);
				return JSON.toJSONString(returnMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");
	}

}
