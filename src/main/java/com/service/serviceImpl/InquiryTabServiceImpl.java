package com.service.serviceImpl;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;



import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.dao.BuyerTabDao;
import com.dao.InquiryTabDao;
import com.dao.OrderTabDao;
import com.dao.StaffTabDao;
import com.entity.InquiryTab;
import com.service.InquiryTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 咨询留言信息Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class InquiryTabServiceImpl implements InquiryTabService {
	@Autowired
	private InquiryTabDao inquiryTabDao;//调用咨询留言Dao层接口
	@Autowired
	private BuyerTabDao buyerTabDao;//调用买家Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	@Autowired
	private OrderTabDao orderTabDao;//调用订单dao层接口
	private Logger logger = Logger.getLogger(InquiryTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathInquiry="/Inquiry/";
	/**
	 * 添加咨询留言信息
	 */
	@Transactional
	public String addInquiryTab(MultipartFile[] inqu_imgs,InquiryTab inquiryTab) {
		logger.info("/addInquiryTab data: "+JSON.toJSONString(inquiryTab));
		int flog = -1;
		try {
			if(inqu_imgs!=null&&inqu_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<inqu_imgs.length;i++) {
					String FilePaths = inqu_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathInquiry+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathInquiry+x+currentTimeMillis+FilePaths;
					logger.info("/addInquiryTab paths: "+paths);
					inqu_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				inquiryTab.setInqu_img(JSON.toJSONString(elseList));
			}
			flog = inquiryTabDao.addInquiryTab(inquiryTab);

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
	 * 查询咨询留言信息
	 */
	@Override
	public String queryInquiryTab(String data) {
		logger.info("/queryInquiryTab data: "+ data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = inquiryTabDao.queryInquiryTab(hashMap);
		for(int i=0;i<list.size();i++) {
			if(list.get(i).containsKey("inqu_img")) {
				String str = list.get(i).get("inqu_img").toString();
				ArrayList<String> strlist = JSON.parseObject(str, ArrayList.class);
				list.get(i).put("inqu_img", strlist);
			}
			ArrayList<HashMap<String,Object>> buyer = buyerTabDao.queryBuyerTab(list.get(i));
			list.get(i).put("buyer", buyer);
			if(list.get(i).containsKey("staf_id")) {
				ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
				list.get(i).put("staff", staff);
			}
			if(list.get(i).containsKey("orde_id")) {
				ArrayList<HashMap<String,Object>> order = orderTabDao.queryOrderTab(list.get(i));
				list.get(i).put("order", order);
			}
			
		}
		int count = inquiryTabDao.queryInquiryTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryInquiryTab success"));
	}
	/**
	 * 更新
	 */
	@Transactional
	public String updateInquiryTab(MultipartFile[] inqu_imgs,InquiryTab inquiryTab) {
		logger.info("/updateInquiryTab data: "+JSON.toJSONString(inquiryTab));
		inquiryTab.setInqu_reply_date(DateUtil.getNowDate());
		int flog = -1;
		try {
			if(inqu_imgs!=null&&inqu_imgs.length>0) {
				ArrayList<String> elseList = new ArrayList<String>();
				for(int i=0;i<inqu_imgs.length;i++) {
					String FilePaths = inqu_imgs[i].getOriginalFilename();//获得文件名称
					long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
					int x=(int)(Math.random()*100);//获得一个随机数
					elseList.add(pathInquiry+x+currentTimeMillis+FilePaths);
					String paths = savePath+"//"+pathInquiry+x+currentTimeMillis+FilePaths;
					logger.info("/addInquiryTab paths: "+paths);
					inqu_imgs[i].transferTo(new File(paths));//文件下载到服务器指定文件夹
				}
				inquiryTab.setInqu_img(JSON.toJSONString(elseList));
			}
			flog = inquiryTabDao.updateInquiryTab(inquiryTab);
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
	 * 删除留言咨询信息
	 */
	@Transactional
	public String deleteInquiryTab(String data) {
		logger.info("/deleteInquiryTab data: "+ data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int inqu_id = list.get(i);
			int flog = inquiryTabDao.deleteInquiryTab(inqu_id);
			if(flog<=0) {
				retlist.add(inqu_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
