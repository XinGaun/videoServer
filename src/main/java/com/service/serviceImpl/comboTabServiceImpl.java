package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.comboTabDao;
import com.entity.comboTab;
import com.service.comboTabService;
import com.util.OSSUtil;

@Service
public class comboTabServiceImpl implements comboTabService{
	@Autowired
	private comboTabDao vDao;
	private OSSUtil ossUpload = new OSSUtil();
	@Override
	public void insertComboTab(comboTab t) {
		vDao.insertComboTab(t);
	}
	@Override
	public List<comboTab> getTabList() {
		return vDao.getTabList();
	}
	@Override
	public List<comboTab> getTabList(comboTab t) {
		return vDao.getTabList(t);
	}
	@Override
	public void delComboById(int t) {
		vDao.delComboById(t);
	}
	@Override
	public List<comboTab> getTaocanId(int id) {
		return vDao.getTaocanId(id);
	}
	@Override
	public void updComboById(comboTab t) {
		vDao.updComboById(t);
	}
	@Override
	public void insertComboTab(String combo_name, String combo_introduce, String video_id, String combo_price,
			MultipartFile image, int teacher_id) throws Exception {
		// TODO Auto-generated method stub
		String oldImageName = image.getOriginalFilename();
		String imageName = combo_name+oldImageName.substring(oldImageName.lastIndexOf("."));
		System.out.println(imageName);
		String ossImageName = ossUpload.uploadInput(imageName,image.getInputStream());
		String imageUrl = ossUpload.getWebURL(ossImageName);
		System.out.println(imageUrl);
		comboTab c=new comboTab();
		c.setCombo_imgs(imageUrl);
		c.setCombo_introduce(combo_introduce);
		c.setCombo_name(combo_name);
		c.setCombo_price(combo_price);
		c.setTeacher_id(teacher_id);
		c.setVideo_id(video_id);
		insertComboTab(c);
	}
	
}
