package com.service.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.IndexConfigDao;
import com.entity.TeacherDomain;
import com.service.IndexConfigService;
import com.util.Count;
import com.util.OSSUtil;
import com.util.PaginationBean;
@Service
@SuppressWarnings("unchecked")
public class IndexConfigServiceImpl implements IndexConfigService {
	@Autowired
	private IndexConfigDao configDao;
	/**
	 * 添加通知信息
	 */
	@Override
	public String addinform(String data,HttpServletRequest request) {
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		//System.out.println(JSON.toJSON(map));
		map.put("teac_id", teacher.getTeacher_id());
		int flog = configDao.addinform(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"addinform success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"addinform error"));
	}
	/**
	 * 查询通知信息
	 */
	@Override
	public String queryinformAll(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int totalRows = configDao.queryinformCount(map);
		PaginationBean page = new PaginationBean();
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		page.setCurrentPage(Integer.parseInt(map.get("currPage").toString()));
		page.setTotalRows(totalRows);
		page.repaginate();
		map.put("startNum", page.getStartNum());
		map.put("endIndex", page.getEndIndex());
		ArrayList<HashMap<String,Object>> list = configDao.queryinformList(map);
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("Code", 200);
		hashMap.put("listObject", list);
		hashMap.put("totalRows", page.getTotalRows());
		return JSON.toJSONString(hashMap);
	}
	/**
	 * 删除首页通知信息
	 */
	@Override
	public String deleteinfo(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = configDao.deleteinform(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"deleteinfo success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"deleteinfo error"));
	}
	/**
	 * 修改首页通知信息
	 */
	@Override
	public String updateinfo(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = configDao.updateinform(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"updateinfo success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"updateinfo error"));
	}
	/**
	 * 添加滚播信息
	 */
	@Transactional
	public String addRollplayTab(String roll_url, Integer roll_weight, MultipartFile roll_img) throws Exception {
		OSSUtil ossUtil = new OSSUtil();
		String oldImageName = roll_img.getOriginalFilename();
		String imageName = oldImageName;//roll_img.getName()+oldImageName.substring(oldImageName.lastIndexOf("."));
		CommonsMultipartFile cf= (CommonsMultipartFile)roll_img; //这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		File imageFile = fi.getStoreLocation();
		String rollimg = ossUtil.upload(imageFile, imageName);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("roll_img", rollimg);
		map.put("roll_weight", roll_weight);
		map.put("roll_url", roll_url);
		int flog = configDao.addRollplayTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"addRollplayTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"addRollplayTab error"));
	}
	/**
	 * 查询首页滚播信息
	 */
	@Override
	public String queryRollplayRab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int totalRows = configDao.queryRollplayTabCount(map);
		PaginationBean page = new PaginationBean();
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		page.setCurrentPage(Integer.parseInt(map.get("currPage").toString()));
		page.setTotalRows(totalRows);
		page.repaginate();
		map.put("startNum", page.getStartNum());
		map.put("endIndex", page.getEndIndex());
		ArrayList<HashMap<String,Object>> list = configDao.queryRollplayRab(map);
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("Code", 200);
		hashMap.put("listObject", list);
		hashMap.put("totalRows", page.getTotalRows());
		return JSON.toJSONString(hashMap);
	}
	/**
	 * 删除首页滚播信息
	 */
	@Override
	public String deleteRollplayTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = configDao.deleteRollplayTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"deleteRollplayTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"deleteRollplayTab error"));
	}
	/**
	 * 修改首页滚播信息
	 */
	@Transactional
	public String updateRollplayTab(Integer roll_id, String roll_url, Integer roll_weight, MultipartFile roll_img) {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("roll_id", roll_id);
		map.put("roll_url", roll_url);
		map.put("roll_weight", roll_weight);
		if(null!=roll_img&&null!=roll_img.getOriginalFilename()) {
			OSSUtil ossUtil = new OSSUtil();
			String oldImageName = roll_img.getOriginalFilename();
			String imageName = oldImageName;//roll_img.getName()+oldImageName.substring(oldImageName.lastIndexOf("."));
			CommonsMultipartFile cf= (CommonsMultipartFile)roll_img; //这个myfile是MultipartFile的
			DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
			File imageFile = fi.getStoreLocation();
			try {
				String rollimg = ossUtil.upload(imageFile, imageName);
				map.put("roll_img", rollimg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return JSON.toJSONString(Count.counts(null, -1, map,400,"updateRollplayTab error"));
			}
		}
		int flog = configDao.updateRollplayTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"updateRollplayTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"updateRollplayTab error"));

	}
	/**
	 * 添加展示教师信息
	 * @throws Exception 
	 */
	@Transactional
	public String addTeachershowTab(MultipartFile teac_show_img, String teac_show_name, String teac_show_introduce,
			String teac_show_url, Integer teac_show_weight) throws Exception {
		OSSUtil ossUtil = new OSSUtil();
		String oldImageName = teac_show_img.getOriginalFilename();
		String imageName = oldImageName;//roll_img.getName()+oldImageName.substring(oldImageName.lastIndexOf("."));
		CommonsMultipartFile cf= (CommonsMultipartFile)teac_show_img; //这个myfile是MultipartFile的
		DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
		File imageFile = fi.getStoreLocation();
		String teac_show_imgs = ossUtil.upload(imageFile, imageName);
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("teac_show_img", teac_show_imgs);
		map.put("teac_show_weight", teac_show_weight);
		map.put("teac_show_url", teac_show_url);
		map.put("teac_show_introduce", teac_show_introduce);
		map.put("teac_show_name", teac_show_name);
		int flog = configDao.addTeachershowTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"addTeachershowTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"addTeachershowTab error"));
	}
	/**
	 * 查询展示教师信息
	 */
	@Override
	public String queryTeachershowTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int totalRows = configDao.queryTeachershowTabCount(map);
		PaginationBean page = new PaginationBean();
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		page.setCurrentPage(Integer.parseInt(map.get("currPage").toString()));
		page.setTotalRows(totalRows);
		page.repaginate();
		map.put("startNum", page.getStartNum());
		map.put("endIndex", page.getEndIndex());
		ArrayList<HashMap<String,Object>> list = configDao.queryTeachershowTab(map);
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("Code", 200);
		hashMap.put("listObject", list);
		hashMap.put("totalRows", page.getTotalRows());
		return JSON.toJSONString(hashMap);
	}
	/**
	 * 删除展示教师信息
	 */
	@Override
	public String deleteTeachershowTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int flog = configDao.deleteTeachershowTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"deleteTeachershowTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"deleteTeachershowTab error"));
	}
	/**
	 * 修改展示教师信息
	 */
	@Override
	public String updateTeachershowTab(@RequestParam(value="teac_show_img",required=false)MultipartFile teac_show_img,String teac_show_name,String teac_show_introduce,String teac_show_url,Integer teac_show_weight,Integer teac_show_id)throws Exception {
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("teac_show_id", teac_show_id);
		map.put("teac_show_name", teac_show_name);
		map.put("teac_show_introduce", teac_show_introduce);
		map.put("teac_show_url", teac_show_url);
		map.put("teac_show_weight", teac_show_weight);
		if(null!=teac_show_img&&null!=teac_show_img.getOriginalFilename()) {
			OSSUtil ossUtil = new OSSUtil();
			String oldImageName = teac_show_img.getOriginalFilename();
			String imageName = oldImageName;//roll_img.getName()+oldImageName.substring(oldImageName.lastIndexOf("."));
			CommonsMultipartFile cf= (CommonsMultipartFile)teac_show_img; //这个myfile是MultipartFile的
			DiskFileItem fi = (DiskFileItem)cf.getFileItem(); 
			File imageFile = fi.getStoreLocation();
			try {
				String rollimg = ossUtil.upload(imageFile, imageName);
				map.put("teac_show_img", rollimg);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return JSON.toJSONString(Count.counts(null, -1, map,400,"updateTeachershowTab error"));
			}
		}
		int flog = configDao.updateTeachershowTab(map);
		if(flog>0) {
			return JSON.toJSONString(Count.counts(null, -1, map,200,"updateTeachershowTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"updateTeachershowTab error"));

	}
	/**
	 * 首页查询滚播内容
	 */
	@Override
	public String queryrRollplaTabAll(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = configDao.queryrRollplaTabAll(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryrRollplaTabAll success"));
	}
	/**
	 * 首页查询全部通通知内容
	 */
	@Override
	public String queryinformList(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = configDao.queryinformAll(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryinformList success"));
	}
	/**
	 * 首页查询展示教师信息
	 */
	@Override
	public String queryTeachershowTabAll(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = configDao.queryTeachershowTabAll(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryTeachershowTabAll success"));
	}
	/**
	 * 查询跳转教师ID信息
	 */
	@Override
	public String queryTeachersUrlID(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = configDao.queryTeachersUrlID(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryTeachersUrlID success"));
	}

}
