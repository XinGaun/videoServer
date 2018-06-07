package com.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.entity.comboTab;
import com.service.comboTabService;

@Controller
@RequestMapping("/comboTab")
public class comboTabController {
	@Autowired
	private comboTabService cService;
	
	@RequestMapping(value="/insertComboTab.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void insertComboTab(/*int teacher_id,*/String combo_name,String combo_introduce,String video_id,String combo_price,String combo_imgs){
		comboTab c=new comboTab();
		c.setCombo_imgs(combo_imgs);
		c.setCombo_introduce(combo_introduce);
		c.setCombo_name(combo_name);
		c.setCombo_price(combo_price);
		c.setTeacher_id(1);
		c.setVideo_id(video_id);
		cService.insertComboTab(c);
	}
	
	@RequestMapping(value="/getListBy.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getListBy(/*int teacher_id,*/String combo_name,String combo_price){
		comboTab c=new comboTab();
		c.setCombo_name(combo_name);
		c.setCombo_price(combo_price);
		return JSON.toJSONString(cService.getTabList(c));
	}
	
	@RequestMapping(value="/getList.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getList(){
		return JSON.toJSONString(cService.getTabList());
	}
	@RequestMapping(value="/delComboById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void delComboById(int id){
		cService.delComboById(id);
	}
	@RequestMapping(value="/getTaocanId.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String getTaocanId(int id){
		return JSON.toJSONString(cService.getTaocanId(id));
	}
	
	@RequestMapping(value="/updComboById.do",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void updComboById(int combo_id,String combo_name,String combo_introduce,String video_id,String combo_imgs,String combo_price){
		comboTab c=new comboTab();
		c.setCombo_id(combo_id);
		c.setCombo_imgs(combo_imgs);
		c.setCombo_introduce(combo_introduce);
		c.setCombo_name(combo_name);
		c.setCombo_price(combo_price);
		c.setVideo_id(video_id);
		cService.updComboById(c);
	}
}
