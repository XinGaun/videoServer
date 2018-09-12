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
import com.dao.StaffTabDao;
import com.dao.WriterTabDao;
import com.entity.WriterTab;
import com.service.WriterTabService;
import com.util.Count;
import com.util.Page;
/**
 * 文案表Service层接口
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class WriterTabServiceImpl implements WriterTabService {
	@Autowired
	private WriterTabDao writerTabDao;//调用文案Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	private Logger logger = Logger.getLogger(WriterTabServiceImpl.class);
	@Value("${imgs}")
	private String savePath;
	private String pathWriter = "/Writer/";
	/**
	 * 添加文案信息
	 */
	@Override
	public String addWriterTab(MultipartFile writ_imgs,WriterTab writerTab) {
		logger.info("/addWriterTab data: "+JSON.toJSONString(writerTab));
		int projectFileFlog = -1;
		int projectupdate =-1;
		String FilePath = writ_imgs.getOriginalFilename();//获得文件名称
		logger.info("/addWriterTab FilePath: "+FilePath);
		try {
			if(FilePath.equals("")||FilePath==null) {
				logger.info("writ_img upload Not file NULL!");
				projectFileFlog = 1;
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				writerTab.setWrit_img(pathWriter+x+currentTimeMillis+FilePath);
				logger.info("FilePath: "+FilePath);
				writ_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
				projectupdate = writerTabDao.addWriterTab(writerTab);
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
	 * 查询文案信息
	 */
	@Override
	public String queryWriterTab(String data) {
		logger.info("/queryWriterTab data: "+data);
		HashMap<String,Object> datamap = JSON.parseObject(data, HashMap.class);
		datamap = Page.page(datamap);
		ArrayList<HashMap<String,Object>> list = writerTabDao.queryWriterTab(datamap);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
			list.get(i).put("staff", staff);
		}
		int count = writerTabDao.queryWriterTabCount(datamap);
		//list = Count.count(list, count, datamap);
		return JSON.toJSONString(Count.counts(list, count, datamap,200,"queryWriterTab success"));
	}
	/**
	 * 更新文案信息
	 */
	@Override
	public String updateWriterTab(MultipartFile writ_imgs,WriterTab writerTab) {
		logger.info("/updateWriterTab data: "+JSON.toJSONString(writerTab));
		int projectupdate =-1;
		String FilePath = null;
		if(writ_imgs!=null) {
			FilePath = writ_imgs.getOriginalFilename();//获得文件名称
		}
		logger.info("/updateWriterTab FilePath: "+FilePath);
		try {
			if(FilePath==null) {
				//没有文件上传
				logger.info("supp_logo upload Not file NULL!");
			}else {
				long currentTimeMillis = System.currentTimeMillis();//获得当前毫秒数
				int x=(int)(Math.random()*100);//获得一个随机数
				writerTab.setWrit_img(pathWriter+x+currentTimeMillis+FilePath); 
				FilePath = savePath+"//"+pathWriter+x+currentTimeMillis+FilePath;
				logger.info("FilePath: "+FilePath);
				writ_imgs.transferTo(new File(FilePath));//文件下载到服务器指定文件夹
			}
			projectupdate = writerTabDao.updateWriterTab(writerTab);
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
	 * 删除文案信息
	 */
	@Transactional
	public String deleteWriterTab(String data) {
		logger.info("/deleteWriterTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int writ_id = list.get(i);
			int flog = writerTabDao.deleteWriterTab(writ_id);
			if(flog<=0) {
				retlist.add(writ_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}

}
