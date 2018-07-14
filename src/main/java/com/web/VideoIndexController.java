package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.VideoIndexService;

@Controller
@RequestMapping("/front/VideoIndex")
@ResponseBody
public class VideoIndexController {
	@Autowired
	private VideoIndexService indexService;
	/**
	 * index查询精品课程
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBoutiqueVideo",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBoutiqueVideo() {
		return indexService.queryBoutiqueVideo();
	}
	/**
	 * index查询推荐套餐
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCombo",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCombo() {
		return indexService.queryCombo();
	}
	/**
	 * index查询课程点击榜
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryBoutiqueVideoClick",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryBoutiqueVideoClick(@RequestBody String data) {
		return indexService.queryBoutiqueVideoClick(data);
	}
	/**
	 * index查询课程评分榜
	 * @param data
	 * @return
	 */
	/*@RequestMapping(value="/queryCourseGrade",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCourseGrade() {
		return indexService.queryCourseGrade();
	}*/
}
