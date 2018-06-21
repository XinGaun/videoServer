package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.VideosDaoService;

@Controller
@RequestMapping("/front/Videos")
@ResponseBody
public class VideosController {
	@Autowired
	private VideosDaoService videosDaoService;
	/**
	 * video查询课程信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/querycoursesTabAll",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String querycoursesTabAll(@RequestBody String data) {
		return videosDaoService.querycoursesTabAll(data);
	}
	/**
	 * video查询推荐课程信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryRecommend",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryRecommend() {
		return videosDaoService.queryRecommend();
	}
	/**
	 * video用户是否购买课程
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryOrder",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOrder(@RequestBody String data) {
		return videosDaoService.queryOrder(data);
	}
}
