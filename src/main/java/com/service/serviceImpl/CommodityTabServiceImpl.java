package com.service.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
import com.entity.CommodityTab;
import com.entity.ExampleTab;
import com.service.CommodityTabService;
import com.util.Count;
import com.util.HttpReq;
import com.util.Page;
/**
 * 商品Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class CommodityTabServiceImpl implements CommodityTabService {
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	@Autowired
	private CategoryTabDao categoryTabDao;//调用品类dao层接口
	@Autowired
	private SupplierTabDao supplierTabDao;//调用供应商ID
	@Autowired
	private BrandTabDao brandTabDao;//调用品牌Dao层接口
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(CommodityTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathcommodity="/Commodity/";
	/**
	 * 添加商品
	 */
	@Transactional
	public String addCommodityTab(
			MultipartFile comm_main_imgs, MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		logger.info("/addCommodityTab data: "+JSON.toJSONString(commodityTab));
		logger.info("/ savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = comm_main_imgs.getOriginalFilename();//获得文件名称
		logger.info("/ FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("comm_main_img upload Not file NULL!");
				projectFileFlog = 1;
				return "error";
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				commodityTab.setComm_main_img(pathcommodity+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				comm_main_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			if(comm_else_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<comm_else_imgs.length;i++) {
					String FilePaths = comm_else_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathcommodity+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					comm_else_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				commodityTab.setComm_else_img(JSON.toJSONString(elseList));
			}
			projectupdate = commodityTabDao.addCommodityTab(commodityTab);
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
	 * 查询商品信息
	 */
	@Override
	public String queryCommodityTab(String data) {
		logger.info("/queryCommodityTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = commodityTabDao.queryCommodityTab(hashMap);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("comm_specification")) {
				String str = list.get(i).get("comm_specification").toString();
				HashMap<String,Object> strmap = JSON.parseObject(str, HashMap.class);
				list.get(i).put("comm_specification", strmap);
			}
			if(list.get(i).containsKey("comm_else_img")&&!list.get(i).get("comm_else_img").equals("")) {
				//System.out.println(i);
				String strlist  = list.get(i).get("comm_else_img").toString();
				ArrayList<String> strArr = JSON.parseObject(strlist, ArrayList.class);
				list.get(i).put("comm_else_img", strArr);
			}
			String lock_status = list.get(i).get("lock_status").toString();
			list.get(i).put("lock_status", null);
			ArrayList<HashMap<String,Object>> category = categoryTabDao.queryCategoryTab(list.get(i));
			ArrayList<HashMap<String,Object>> supplier = supplierTabDao.querySupplierTab(list.get(i));
			ArrayList<HashMap<String,Object>> brand = brandTabDao.queryBrandTab(list.get(i));
			list.get(i).put("lock_status", lock_status);
			list.get(i).put("category", category);
			list.get(i).put("supplier", supplier);
			list.get(i).put("brand", brand);
		};

		int count = commodityTabDao.queryCommodityTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryCommodityTab success"));
	}
	/**
	 * 更新商品信息
	 */
	@Transactional
	public String updateCommodityTab(MultipartFile comm_main_imgs, MultipartFile[] comm_else_imgs,CommodityTab commodityTab) {
		logger.info("/updateCommodityTab data: "+JSON.toJSONString(commodityTab));
		logger.info("/updateCommodityTab savePath: "+savePath);
		//int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = null;
		if(comm_main_imgs!=null&&comm_main_imgs.getOriginalFilename()!=""&&comm_main_imgs.getOriginalFilename()!=" ") {
			FilePath = comm_main_imgs.getOriginalFilename();//获得文件名称
		}
		logger.info("/updateCommodityTab FilePath: "+FilePath);
		try {
			if(FilePath==null||FilePath=="") {
				//没有文件上传
				logger.info("comm_main_img upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数

				commodityTab.setComm_main_img(pathcommodity+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				comm_main_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			if(comm_else_imgs.length>0&&comm_else_imgs[0].getOriginalFilename()!=""&&comm_else_imgs[0].getOriginalFilename()!=" "&&comm_else_imgs[0].getOriginalFilename()!=null) {
				logger.info("comm_else_imgs.length"+comm_else_imgs.length);
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<comm_else_imgs.length;i++) {
					String FilePaths = comm_else_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					String paths = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					comm_else_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
					elseList.add(pathcommodity+x+currentTimeMillis+FilePaths);
				}
				commodityTab.setComm_else_img(JSON.toJSONString(elseList));
			}
			projectupdate = commodityTabDao.updateCommodityTab(commodityTab);
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
	 * 删除商品
	 */
	@Override
	public String deleteCommodityTab(String data) {
		logger.info("/deleteCommodityTab: data"+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int comm_putaway_id = list.get(i);
			int flog = commodityTabDao.deleteCommodityTab(comm_putaway_id);
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
	 * 根据商品名称ID查询数据
	 */
	@Override
	public String queryCommName(String data) {
		logger.info("/queryCommName: data"+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> retlist = commodityTabDao.queryCommName(hashMap);
		return JSON.toJSONString(Count.counts(retlist, 0, hashMap,200,"queryCommodityTab success"));
	}
	/**
	 * 前端查询商品详情
	 */
	@Override
	public String quertFrontCommodityTab(String data) {
		logger.info("/quertFrontCommodityTab: data"+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		List<Integer> brand_list = JSON.parseObject(JSON.toJSONString(hashMap.get("brand_list")), List.class); 
		hashMap.put("brand_list", brand_list);
		hashMap = Page.page(hashMap);
		if(hashMap.containsKey("brand_cate_id")) {
			ArrayList<Integer> tatilList = new ArrayList<Integer>();
			tatilList.add(Integer.parseInt(hashMap.get("brand_cate_id").toString()));

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
			hashMap.put("brand_cate_id", tatilList);
		}
		ArrayList<HashMap<String,Object>> list =commodityTabDao.quertFrontCommodityTab(hashMap);	
		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("comm_specification")) {
				String str = list.get(i).get("comm_specification").toString();
				HashMap<String,Object> strmap = JSON.parseObject(str, HashMap.class);
				list.get(i).put("comm_specification", strmap);
			}
			if(list.get(i).containsKey("comm_else_img")&&!list.get(i).get("comm_else_img").equals("")) {
				String strlist  = list.get(i).get("comm_else_img").toString();
				ArrayList<String> strArr = JSON.parseObject(strlist, ArrayList.class);
				list.get(i).put("comm_else_img", strArr);
			}
			Integer stock = commodityTabDao.querystockTab(list.get(i));
			if(stock!=null) {
				list.get(i).put("stock", stock);
			}else {
				list.get(i).put("stock", 0);
			}
			
		}
		int count = commodityTabDao.quertFrontCommodityTabCount(hashMap);
		hashMap.put("brand_cate_id","");
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"quertFrontCommodityTab success"));
	}
	/**
	 * 后端购物查询商品信息
	 */
	@Override
	public String queryCommodityTabBack(String data) {
		logger.info("/queryCommodityTabBack: data"+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list =commodityTabDao.queryCommodityTabBack(hashMap);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("comm_specification")) {
				String str = list.get(i).get("comm_specification").toString();
				HashMap<String,Object> strmap = JSON.parseObject(str, HashMap.class);
				list.get(i).put("comm_specification", strmap);
			}
			if(list.get(i).containsKey("comm_else_img")) {
				String strlist  = list.get(i).get("comm_else_img").toString();
				ArrayList<String> strArr = JSON.parseObject(strlist, ArrayList.class);
				list.get(i).put("comm_else_img", strArr);
			}
		}
		int count = commodityTabDao.queryCommodityTabBackCount(hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryCommodityTabBack success"));
	}
	/**
	 * 总实例添加商品信息
	 */
	@Transactional
	public String addPushCommodityTab(MultipartFile comm_main_imgs, MultipartFile[] comm_else_imgs,
			CommodityTab commodityTab) {
		logger.info("/addCommodityTab data: "+JSON.toJSONString(commodityTab));
		logger.info("/ savePath: "+savePath);
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = comm_main_imgs.getOriginalFilename();//获得文件名称
		logger.info("/ FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				//没有文件上传
				logger.info("comm_main_img upload Not file NULL!");
				projectFileFlog = 1;
				return "error";
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				commodityTab.setComm_main_img(pathcommodity+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				comm_main_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			if(comm_else_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<comm_else_imgs.length;i++) {
					String FilePaths = comm_else_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathcommodity+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					comm_else_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				commodityTab.setComm_else_img(JSON.toJSONString(elseList));
			}
			projectupdate = commodityTabDao.addCommodityTab(commodityTab);
			//推送添加商品信息
			//1.通过上架ID查询添加到数据库的信息
			logger.info("commodityTab.getComm_id :"+ commodityTab.getComm_id());
			HashMap<String,Object> commIdMap = commodityTabDao.queryPushCommodityID(commodityTab.getComm_id());
			logger.info("commIdMap :"+ commIdMap);
			commodityTab.setComm_putaway_id(Integer.parseInt(commIdMap.get("comm_putaway_id").toString()));
			//2.获取推送接口IP地址
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			logger.info("exampleList :"+ JSON.toJSONString(exampleList));
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/addPushCommodity", "POST",JSON.toJSONString(commodityTab));
				logger.info("result httpPush :"+ JSON.toJSONString(result));
				resultList.put(exampleList.get(i).getExample_name(), result);
			}
			//3.组装返回值
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
	 * 更新商品总实例信息并推送分实例
	 */
	@Transactional
	public String updatePushCommodityTab(MultipartFile comm_main_imgs, MultipartFile[] comm_else_imgs,
			CommodityTab commodityTab) {
		logger.info("/updateCommodityTab data: "+JSON.toJSONString(commodityTab));
		logger.info("/updateCommodityTab savePath: "+savePath);
		//int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = null;
		if(comm_main_imgs!=null&&comm_main_imgs.getOriginalFilename()!=""&&comm_main_imgs.getOriginalFilename()!=" ") {
			FilePath = comm_main_imgs.getOriginalFilename();//获得文件名称
		}
		logger.info("/updateCommodityTab FilePath: "+FilePath);
		try {
			if(FilePath==null||FilePath=="") {
				//没有文件上传
				logger.info("comm_main_img upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数

				commodityTab.setComm_main_img(pathcommodity+x+currentTimeMillis+FilePath);
				FilePath = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				comm_main_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			if(comm_else_imgs.length>0&&comm_else_imgs[0].getOriginalFilename()!=""&&comm_else_imgs[0].getOriginalFilename()!=" "&&comm_else_imgs[0].getOriginalFilename()!=null) {
				logger.info("comm_else_imgs.length"+comm_else_imgs.length);
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<comm_else_imgs.length;i++) {
					String FilePaths = comm_else_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					String paths = savePath+"//"+pathcommodity+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					comm_else_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
					elseList.add(pathcommodity+x+currentTimeMillis+FilePaths);
				}
				commodityTab.setComm_else_img(JSON.toJSONString(elseList));
			}
			projectupdate = commodityTabDao.updateCommodityTab(commodityTab);
			//1.获取需要推送的地址IP
			ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
			String result = null;
			HashMap<String,Object> resultList = new HashMap<String,Object>();
			for(int i=0;i<exampleList.size();i++) {
				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/updatePushCommodity", "POST",JSON.toJSONString(commodityTab));
				resultList.put(exampleList.get(i).getExample_name(), result);
			}
			//2.组装返回值
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
	/**
	 * 总实例删除商品信息
	 */
	@Transactional
	public String deletePushCommodityTab(String data) {
		logger.info("/deletePushCommodityTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();	
		for(int i=0;i<list.size();i++) {
			int comm_putaway_id = list.get(i);
			int flog = commodityTabDao.deleteCommodityTab(comm_putaway_id);
			if(flog<=0) {
				retlist.add(comm_putaway_id);
			}
		}
		//1.删除子实例商品信息
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		String result = null;
		HashMap<String,Object> resultList = new HashMap<String,Object>();
		for(int i=0;i<exampleList.size();i++) {
			result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/BranchesReceive/deletePushCommodity", "POST",JSON.toJSONString(list));
			resultList.put(exampleList.get(i).getExample_name(), result);
		}
		//2.组装返回值
		HashMap<String,Object> returnMap = new HashMap<String,Object>();
		returnMap.put("code", 200);
		returnMap.put("msg", resultList);
		return JSON.toJSONString(returnMap);
	}

}
