package com.service;

import java.util.List;

import com.entity.comboTab;

public interface comboTabService {
	public void insertComboTab(comboTab t);
	public List<comboTab> getTabList();
	public List<comboTab> getTabList(comboTab t);
	public void delComboById(int t);
	public List<comboTab> getTaocanId(int id);
	public void updComboById(comboTab t);
}