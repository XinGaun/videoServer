package com.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.entity.comboTab;

public interface comboTabService {
	public void insertComboTab(comboTab t);
	public void insertComboTab(String combo_name,String combo_introduce,String video_id,String combo_price,MultipartFile image,int teacher_id) throws Exception;
	public List<comboTab> getTabList();
	public List<comboTab> getTabList(comboTab t);
	public void delComboById(int t);
	public List<comboTab> getTaocanId(int id);
	public void updComboById(comboTab t);
}
