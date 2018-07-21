package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.VideoIndexDao;
import com.service.VideoIndexService;

import com.util.Count;
import com.util.OSSUtil;
import com.util.Page;

@Service
public class VideoIndexServiceImpl implements VideoIndexService {
	@Autowired
	private VideoIndexDao videoIndexDao;
	//查询推荐课程
	@Override
	public String queryBoutiqueVideo(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryBoutiqueVideo(map);
		int bb = list.size();
		for(int i=0;i<bb;i++) {
			HashMap<String, Object> tt = list.get(i);
			for(String in : tt.keySet()){
				int value= Integer.parseInt(tt.get("courses_id").toString());
				HashMap<String,Object> dd = videoIndexDao.queryBoutiqueIntRs(value);
				for(String nn : dd.keySet()) {
					Object value2 = dd.get("count_person");
					tt.put("kcPerson", value2);
				}
				break;
			}
			list.add(tt);
		}
		return JSON.toJSONString(list);
	}
	//查询推荐套餐
	@Override
	public String queryCombo() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCombo();
		int bb = list.size();
		for(int i=0;i<bb;i++) {
			HashMap<String, Object> tt = list.get(i);
			for(String in : tt.keySet()){
				int value= Integer.parseInt(tt.get("courses_id").toString());
				HashMap<String,Object> dd = videoIndexDao.queryBoutiqueIntRs(value);
				for(String nn : dd.keySet()) {
					Object value2 = dd.get("count_person");
					tt.put("kcPerson", value2);
				}
				break;
			}
			list.add(tt);
		}
		return JSON.toJSONString(list);
	}
	//查询推荐套餐
		@Override
		public String queryComboSearch(String data) {
			HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
			 ArrayList<HashMap<String, Object>> list = videoIndexDao.queryComboSearch(map);
			 int bb = list.size();
				for(int i=0;i<bb;i++) {
					HashMap<String, Object> tt = list.get(i);
					for(String in : tt.keySet()){
						int value= Integer.parseInt(tt.get("courses_id").toString());
						HashMap<String,Object> dd = videoIndexDao.queryBoutiqueIntRs(value);
						for(String nn : dd.keySet()) {
							Object value2 = dd.get("count_person");
							tt.put("kcPerson", value2);
						}
						break;
					}
					list.add(tt);
				}
			return JSON.toJSONString(list);
		}
	//获取所有精品课程
	@Override
	public String queryBoutiqueVideoClick(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map= Page.page(map);
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryBoutiqueVideoClick(map);
		int bb = list.size();
		for(int i=0;i<bb;i++) {
			HashMap<String, Object> tt = list.get(i);
			for(String in : tt.keySet()){
				int value= Integer.parseInt(tt.get("courses_id").toString());
				HashMap<String,Object> dd = videoIndexDao.queryBoutiqueIntRs(value);
				for(String nn : dd.keySet()) {
					Object value2 = dd.get("count_person");
					tt.put("kcPerson", value2);
				}
				break;
			}
			list.add(tt);
		}
		int count = videoIndexDao.queryBoutiqueVideoAllCount();
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryBoutiqueVideoAllCount success"));
	}
	//课程评分榜
	/*@Override
	public String queryCourseGrade() {
		ArrayList<HashMap<String,Object>> list = videoIndexDao.queryCourseGrade();
		return JSON.toJSONString(list);
	}*/
	private int parseInt(Object object) {
		// TODO Auto-generated method stub
		return 0;
	}

}
