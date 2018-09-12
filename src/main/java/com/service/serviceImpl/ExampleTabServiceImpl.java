package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.ExampleTabDao;
import com.entity.ExampleTab;
import com.service.ExampleTabService;
import com.util.Count;
/**
 * 分实例管理Service层实现类
 * @author vip
 *
 */
@Service
public class ExampleTabServiceImpl implements ExampleTabService {
	@Autowired
	private ExampleTabDao exampleTabDao;
	private Logger logger = Logger.getLogger(ExampleTabServiceImpl.class);
	/**
	 * 添加分公司实例信息
	 */
	@Override
	public String addExampleTab(ExampleTab exampleTab) {
		logger.info("addExampleTab data: "+JSON.toJSONString(exampleTab));
		int flog = exampleTabDao.addExampleTab(exampleTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询分公司实例信息
	 */
	@Override
	public String queryExampleTab() {
		logger.info("queryExampleTab");
		ArrayList<ExampleTab> list = exampleTabDao.queryExampleTab(new HashMap<String, Object>());
		return Count.resultMap(list, 200,"queryExampleTab success",null);
	}
	/**
	 * 更新分公司实例信息
	 */
	@Override
	public String updateExampleTab(ExampleTab exampleTab) {
		logger.info("updateExampleTab data: "+JSON.toJSONString(exampleTab));
		int flog = exampleTabDao.updateExampleTab(exampleTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除分公司实例
	 */
	@Override
	public String deleteExampleTab(ArrayList<Integer> list) {
		logger.info("deleteExampleTab data: "+JSON.toJSONString(list));
		int flog = exampleTabDao.deleteExampleTab(list);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}

}
