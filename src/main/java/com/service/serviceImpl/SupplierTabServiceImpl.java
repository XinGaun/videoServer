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
import com.dao.ExampleTabDao;
import com.dao.SupplierTabDao;
import com.entity.ExampleTab;
import com.entity.SupplierTab;
import com.service.SupplierTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
@SuppressWarnings("unchecked")
@Service
public class SupplierTabServiceImpl implements SupplierTabService {
	@Autowired
	private SupplierTabDao supplierTabDao;//调用厂商信息Dao层接口
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(SupplierTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathSupplier = "/Supplier/";
	/**
	 * 添加厂商信息
	 */
	@Transactional
	public String addSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight,String lock_status) {
		logger.info("/addSupplierTab supp_logo: "+supp_logo+" supp_name: "+supp_name+" supp_weight: "+supp_weight+"lock_status: "+lock_status);
		SupplierTab supplierTab = new SupplierTab();
		supplierTab.setSupp_name(supp_name);
		supplierTab.setSupp_weight(supp_weight);
		supplierTab.setLock_status(lock_status);
		logger.info("savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = supp_logo.getOriginalFilename();//获得文件名称
		logger.info("FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
				projectFileFlog = 1;
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				supplierTab.setSupp_logo(pathSupplier+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathSupplier+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				supp_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
				projectupdate = supplierTabDao.addSupplierTab(supplierTab);
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
	 * 查询厂商信息
	 */
	@Override
	public String querySupplierTab(String data) {
		logger.info("/querySupplierTab data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap = Page.page(datamap);
		ArrayList<HashMap<String,Object>> list = supplierTabDao.querySupplierTab(datamap);
		int count = supplierTabDao.querySupplierTabCount(datamap);
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"querySupplierTab success"));
	}
	/**
	 * 更新厂商信息
	 */
	@Override
	public String updateSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight,int supp_id,String lock_status) {
		logger.info("/updateSupplierTab supp_logo: "+supp_logo+" supp_name: "+supp_name+" supp_weight: "+supp_weight+"lock_status: "+lock_status);
		SupplierTab supplierTab = new SupplierTab();
		supplierTab.setSupp_name(supp_name);
		supplierTab.setSupp_weight(supp_weight);
		supplierTab.setSupp_id(supp_id);
		supplierTab.setLock_status(lock_status);
		logger.info("savePath: "+savePath);
		int projectupdate =-1;
		String FilePath = null;
		if(supp_logo!=null) {
			FilePath = supp_logo.getOriginalFilename();//获得文件名称
		}
				
		logger.info("FilePath: "+FilePath);
		try {
			if(FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				supplierTab.setSupp_logo(pathSupplier+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathSupplier+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				supp_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			projectupdate = supplierTabDao.updateSupplierTab(supplierTab);
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
	 * 删除供应商信息
	 */
	@Transactional
	public String deleteSupplierTab(String data) {
		logger.info("/deleteSupplierTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int supp_id = list.get(i);
			int flog = supplierTabDao.deleteSupplierTab(supp_id);
			if(flog<=0) {
				retlist.add(supp_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 总实例添加供应商信息
	 */
	@Transactional
	public String addPushSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight, String lock_status) {
		logger.info("/addPushSupplierTab supp_logo: "+supp_logo+" supp_name: "+supp_name+" supp_weight: "+supp_weight+"lock_status: "+lock_status);
		SupplierTab supplierTab = new SupplierTab();
		supplierTab.setSupp_name(supp_name);
		supplierTab.setSupp_weight(supp_weight);
		supplierTab.setLock_status(lock_status);
		logger.info("savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = supp_logo.getOriginalFilename();//获得文件名称
		logger.info("FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
				projectFileFlog = 1;
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				supplierTab.setSupp_logo(pathSupplier+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathSupplier+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				supp_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
				projectupdate = supplierTabDao.addSupplierTab(supplierTab);
			}
			//2.获取推送接口IP地址
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/addPushSupplier", "POST",JSON.toJSONString(supplierTab));
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
	 * 总实例更新供应商信息
	 */
	@Transactional
	public String updatePushSupplierTab(HttpServletRequest req, HttpServletResponse res, MultipartFile supp_logo,
			String supp_name, int supp_weight, int supp_id, String lock_status) {
		logger.info("/updateSupplierTab supp_logo: "+supp_logo+" supp_name: "+supp_name+" supp_weight: "+supp_weight+"lock_status: "+lock_status);
		SupplierTab supplierTab = new SupplierTab();
		supplierTab.setSupp_name(supp_name);
		supplierTab.setSupp_weight(supp_weight);
		supplierTab.setSupp_id(supp_id);
		supplierTab.setLock_status(lock_status);
		logger.info("savePath: "+savePath);
		int projectupdate =-1;
		String FilePath = null;
		if(supp_logo!=null) {
			FilePath = supp_logo.getOriginalFilename();//获得文件名称
		}
				
		logger.info("FilePath: "+FilePath);
		try {
			if(FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				supplierTab.setSupp_logo(pathSupplier+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathSupplier+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				supp_logo.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			projectupdate = supplierTabDao.updateSupplierTab(supplierTab);
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/updatePushSupplier", "POST",JSON.toJSONString(supplierTab));
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
