package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.CourseDetailsDao;
import com.service.CourseDetailsService;
import com.util.Count;
import com.util.Page;
@Service
@SuppressWarnings("unchecked")
public class CourseDetailsServiceImpl implements CourseDetailsService {
	@Autowired
	private CourseDetailsDao courseDetailsDao;
	/**
	 * 查询课程详情
	 */
	@Override
	public String queryCourseDetails(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		ArrayList<HashMap<String,Object>> arrayList = courseDetailsDao.queryCourseDetails(map);
		return JSON.toJSONString(arrayList);
	}
	/**
	 * 查询视频信息
	 */
	@Override
	public String queryVideoDetails(String data) {
		ArrayList<String> list = JSON.parseObject(data,ArrayList.class);
		ArrayList<HashMap<String,Object>> arrayList = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<list.size();i++) {
			if(list.get(i)!=""&&list.get(i)!=null&&list.get(i).toString().length()>0) {
				int video_id =  Integer.parseInt(list.get(i));
				HashMap<String,Object> map = courseDetailsDao.queryVideoDetails(video_id);
				arrayList.add(map);
			}
			
		}
		return JSON.toJSONString(arrayList);
	}
	/**
	 * 查询推荐课程
	 */
	@Override
	public String queryqueryRecommendCourse() {
		ArrayList<HashMap<String,Object>> arrayList = courseDetailsDao.queryRecommendCourse();
		return JSON.toJSONString(arrayList);
	}
	/**
	 * 查询学员评论
	 */
	@Override
	public String queryStudentComments(String data) {
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		map= Page.page(map);
		ArrayList<HashMap<String,Object>> list = courseDetailsDao.queryStudentComments(map);
		int count = courseDetailsDao.queryStudentCommentsAllCount(map);
		return JSON.toJSONString(Count.counts(list, count, map,200,"queryStudentCommentsAllCount success"));
	}
}
