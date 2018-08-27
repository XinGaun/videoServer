package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.dao.CommentTabDao;
import com.service.CommentTabService;
@Service
public class CommentTabServiceImpl implements CommentTabService {
	@Autowired
	private CommentTabDao dao;
	protected final Logger  logger = LoggerFactory.getLogger(this.getClass());  
	@Override
	public String addCommentTabMap(HashMap<String,Object> comment) {
		// TODO Auto-generated method stub
		int flag =dao.addCommentTabMap(comment);
		if(flag >0) {
			return "success";
		}
		return "error";
	}
	
//	@Override
//	public String addCommentTabEntity(CommentTab comment) {
//		// TODO Auto-generated method stub
//		int flag =dao.addEntity(comment);
//		if(flag >0) {
//			return "success";
//		}
//		return "error";
//	}

	@Override
	public String queryCommentTab(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		ArrayList<HashMap<String,Object>> datalist = dao.queryCommentTab(hashMap);
		int total = dao.queryCount(hashMap);
		logger.info(datalist.toString());
		logger.info(Integer.toString(total));
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("data", datalist);
		result.put("limit", Integer.parseInt(hashMap.get("limit").toString()));
		result.put("total", total);
		result.put("page", Integer.parseInt(hashMap.get("page").toString()));
		
		return JSON.toJSONStringWithDateFormat(result, "yyyy-MM-dd HH:mm:ss", SerializerFeature.WriteDateUseDateFormat);
	}

	@Override
	public String updateCommentTab(HashMap<String, Object> hashMap) {
		// TODO Auto-generated method stub
		if(!hashMap.containsKey("comment_id")) {
			return "error";
		}
		int flag = dao.updateCommentTab(hashMap);
		logger.info(hashMap.toString());
		if(flag >0) {
			return "success";
		}
		return "error";
	}

	@Override
	public String deleteCommentTab(List<String>  datalist) {
		// TODO Auto-generated method stub
		logger.info("data"+datalist.toString());
		int flag = 0;
		for (int i = 0; i < datalist.size(); i++) {
			logger.info("service");
			flag =dao.deleteCommentTab(Integer.parseInt(datalist.get(i)));
			logger.info("go");
			if(flag <= 0) {
				return "error";
			}
		}		
		if(flag >0) {
			return "success";
		}
		return "error";
	}

}
