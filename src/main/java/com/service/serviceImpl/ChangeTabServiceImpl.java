package com.service.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.ChangeTabDao;
import com.dao.OrderTabDao;
import com.entity.ChangeTab;
import com.service.ChangeTabService;
import com.util.Count;
import com.util.Page;

/**
 * 退换货单表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class ChangeTabServiceImpl implements ChangeTabService {
	@Autowired
	private ChangeTabDao changeTabDao;//调用退换货单表Dao层接口
	@Autowired
	private OrderTabDao orderTabDao;//调用订单Dao层接口
	private Logger logger = Logger.getLogger(ChangeTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathChange="/Change/";
	/**
	 * 添加退换货单表
	 */
	@Transactional
	public String addChangeTab(MultipartFile[] chan_imgs,ChangeTab changeTab) {
		logger.info("/addChangeTab data: "+JSON.toJSONString(changeTab));
		int flog =-1;
		int flag =-1;
		try {
			if(chan_imgs!=null&&chan_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<chan_imgs.length;i++) {
					String FilePaths = chan_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathChange+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathChange+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					chan_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				changeTab.setChan_img(JSON.toJSONString(elseList));
			}
			Integer[] sale_ids  = changeTab.getSale_ids();
			ArrayList<Integer> comm_ids = JSON.parseObject(changeTab.getComm_ids(),ArrayList.class);
			HashMap<Integer, Integer> commidMap = new HashMap<Integer, Integer>();
			for(int i=0;i<sale_ids.length;i++) {
				if(null!=commidMap&&commidMap.size()>0&&commidMap.containsKey(comm_ids.get(i))) {
					commidMap.put(comm_ids.get(i), commidMap.get(comm_ids.get(i))+1);
				}else {
					commidMap.put(comm_ids.get(i), 1);
				}
				//changeTab.setSale_id(sale_ids[i]);
				//changeTab.setChan_num(chan_nums[i]);
				//flog = changeTabDao.addChangeTab(changeTab);
			}
			Integer[] commIds = new Integer[commidMap.size()];
			Integer[] num = new Integer[commidMap.size()];
			int index = 0;
			for(Integer key : commidMap.keySet()) {
				commIds[index] = key;
				num[index] = commidMap.get(key);
				index++;
			}
			changeTab.setChan_nums(num);
			changeTab.setComm_ids(commIds);
			flog = changeTabDao.addChangeTab(changeTab);
			//更新商品销售记录
			HashMap<String,Object> hashMap = new HashMap<String, Object>();
			hashMap.put("chan_id", changeTab.getChan_id());
			for(int i=0;i<sale_ids.length;i++) {
				hashMap.put("sale_id", sale_ids[i]);
				flag = changeTabDao.updateSalesRecordTab(hashMap);
			}


		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		if(flog>0&&flag>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询退换货单表
	 */
	@Override
	public String queryChangeTab(String data) {
		logger.info("/queryChangeTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = changeTabDao.queryChangeTab(hashMap);

		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("chan_img")) {
				String strlist  = list.get(i).get("chan_img").toString();
				ArrayList<String> strArr = JSON.parseObject(strlist, ArrayList.class);
				list.get(i).put("chan_img", strArr);
			}
			ArrayList<HashMap<String,Object>> saleList = changeTabDao.querySale(list.get(i));
			list.get(i).put("saleList", saleList);
		}

		int count = changeTabDao.queryChangeTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"addChangeTab success"));
	}
	/**
	 * 更新退换货单表
	 */
	@Transactional
	public String updateChangeTab(MultipartFile[] chan_imgs,ChangeTab changeTab) {
		logger.info("/updateChangeTab data: "+JSON.toJSONString(changeTab));
		int flog =-1;
		try {
			if(chan_imgs!=null&&chan_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<chan_imgs.length;i++) {
					String FilePaths = chan_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathChange+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathChange+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					chan_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				changeTab.setChan_img(JSON.toJSONString(elseList));
			}
			flog = changeTabDao.updateChangeTab(changeTab);
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除退换货单表
	 */
	@Transactional
	public String deleteChangeTab(String data) {
		logger.info("/deleteChangeTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int chan_id = list.get(i);
			int flog = changeTabDao.deleteChangeTab(chan_id);
			if(flog<=0) {
				retlist.add(chan_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 审核退换货单信息
	 */
	@Override
	public String auditChangeTab(String data) {
		logger.info("/auditChangeTab data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<Integer> list = JSON.parseObject(JSON.toJSONString(map.get("chan_id")), ArrayList.class);
		ChangeTab changeTab = new ChangeTab();
		changeTab.setChan_status(map.get("chan_status").toString());
		int flog = -1;
		for(int i=0;i<list.size();i++) {
			changeTab.setChan_id(list.get(i));
			flog = changeTabDao.updateChangeTab(changeTab);
		}

		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	@Override
	public String queryChangeOrderId(String data) {
		logger.info("/queryChangeOrderId data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> resultList = changeTabDao.queryChangeOrderId(hashMap);
		return Count.resultMap(resultList, 200,"queryChangeOrderId success", hashMap);
	}
	/**
	 * 前端申请退换货
	 */
	@Transactional
	public String addFontChangeTab(MultipartFile[] chan_imgs,ChangeTab changeTab) {
		changeTab.setChan_status("待审核");
		changeTab.setCargo_status("待确认");
		logger.info("/addFontChangeTab data: "+JSON.toJSONString(changeTab));
		try {
			if(chan_imgs!=null&&chan_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<chan_imgs.length;i++) {
					String FilePaths = chan_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathChange+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathChange+x+currentTimeMillis+FilePaths;
					logger.info("paths: "+paths);
					chan_imgs[i].transferTo(new File(paths));
				}
				changeTab.setChan_img(JSON.toJSONString(elseList));
			}
			ArrayList<Integer> comm_ids = JSON.parseObject(changeTab.getComm_ids(),ArrayList.class);
			ArrayList<Integer> chan_nums = JSON.parseObject(changeTab.getChan_nums(),ArrayList.class);
			int flog = -1;
			flog =changeTabDao.addChangeTab(changeTab);
			HashMap<String,Object> map = new HashMap<String,Object>();
			map.put("num", comm_ids.size());
			map.put("orde_id", changeTab.getOrde_id());

			for(int i=0;i<comm_ids.size();i++) {
				//查询需要退换货商品销售记录的ID		
				map.put("comm_id", comm_ids.get(i));
				ArrayList<HashMap<String,Object>> SaleMap = changeTabDao.querySaleOrdeID(map);
				//更新退商品销售记录
				for(int s=0;s<SaleMap.size();s++) {
					SaleMap.get(i).put("chan_id", changeTab.getChan_id());
					changeTabDao.updateSalesRecordTab(SaleMap.get(i));
				}
			}
			if(flog>=0) {
				return JSON.toJSONString("success");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");
	}

}
