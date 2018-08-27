package com.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.entity.TeacherDomain;
import com.entity.comboTab;
import com.service.comboTabService;

@Controller
@RequestMapping("/comboTab")
public class comboTabController {
	@Autowired
	private comboTabService cService;
	
	@RequestMapping(value="/insertComboTab.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void insertComboTab(HttpServletRequest request,String combo_name,String combo_introduce,String video_id,String combo_price,MultipartFile image) throws Exception{
		TeacherDomain teacher=(TeacherDomain) request.getSession().getAttribute("user");
		int teacher_id = Integer.parseInt(teacher.getTeacher_id());
		System.out.println(image.getOriginalFilename());

		cService.insertComboTab( combo_name, combo_introduce, video_id, combo_price, image, teacher_id);
	}
	
	@RequestMapping(value="/getListBy.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<comboTab> getListBy(int teacher_id,String combo_name,String combo_price){
		comboTab c=new comboTab();
		c.setCombo_name(combo_name);
		c.setCombo_price(combo_price);
		c.setTeacher_id(teacher_id);
		return cService.getTabList(c);
	}
	
	@RequestMapping(value="/getList.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<comboTab> getList(){
		return cService.getTabList();
	}
	@RequestMapping(value="/delComboById.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void delComboById(int id){
		cService.delComboById(id);
	}
	@RequestMapping(value="/getTaocanId.do", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public List<comboTab> getTaocanId(int id){
		return cService.getTaocanId(id);
	}
	
	@RequestMapping(value="/updComboById.do", method={RequestMethod.POST,RequestMethod.GET})
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
