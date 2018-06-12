package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.videoTabDao;
import com.entity.videoTab;
import com.service.videoTabService;
@Service
public class videoTabServiceImpl implements videoTabService{
	
	@Autowired
	private videoTabDao videoDao;
	
	@Override
	public void uploadVideo(videoTab vd) {
		videoDao.uploadVideo(vd);
	}

	@Override
	public List<videoTab> getVideoList() {
		return videoDao.getVideoList();
	}

	@Override
	public List<videoTab> getVideoById(int id) {
		return videoDao.getVideoById(id);
	}

	@Override
	public List<videoTab> selVideo(videoTab vd) {
		return videoDao.selVideo(vd);
	}

	@Override
	public void delVideoById(int video_id) {
		videoDao.delVideoById(video_id);
	}

	@Override
	public void updetVideoById(videoTab vd) {
		videoDao.updetVideoById(vd);
	}
	
}
