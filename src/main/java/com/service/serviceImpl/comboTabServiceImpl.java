package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.comboTabDao;
import com.entity.comboTab;
import com.service.comboTabService;

@Service
public class comboTabServiceImpl implements comboTabService{
	@Autowired
	private comboTabDao vDao;
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
	
}
