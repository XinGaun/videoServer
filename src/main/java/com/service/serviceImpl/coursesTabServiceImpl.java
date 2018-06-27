package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dao.coursesTabDao;
import com.entity.coursesTab;
import com.service.coursesTabService;
import com.util.OSSUtil;

@Service
public class coursesTabServiceImpl implements coursesTabService{
	@Autowired
	private coursesTabDao ctDao;
	private OSSUtil ossUpload = new OSSUtil();
	@Override
	public List<coursesTab> getTabList(coursesTab v) {
		return ctDao.getTabList(v);
	}

	@Override
	public void addCoursesTab(coursesTab c) {
		ctDao.addCoursesTab(c);
	}

	@Override
	public List<coursesTab> getTabList() {
		return ctDao.getTabList();
	}

	@Override
	public void delCoursesById(int id) {
		ctDao.delCoursesById(id);
	}

	@Override
	public void upCoursesById(coursesTab c) {
		ctDao.upCoursesById(c);
	}

	@Override
	public List<coursesTab> getTabListById(int id) {
		return ctDao.getTabListById(id);
	}

	@Override
	public void addCoursesTab(String courses_name, String courses_introduce, String courses_pricemoney,
			String courses_video, MultipartFile image,int teacher_id) throws Exception {
		// TODO Auto-generated method stub
		String oldImageName = image.getOriginalFilename();
		String imageName = courses_name+oldImageName.substring(oldImageName.lastIndexOf("."));
		System.out.println(imageName);
		String ossImageName = ossUpload.uploadInput(imageName,image.getInputStream());
		
		String imageUrl = ossUpload.getWebURL(ossImageName);
		System.out.println(imageUrl);
		coursesTab c=new coursesTab();
		c.setCourses_name(courses_name);
		c.setCourses_introduce(courses_introduce);
		c.setCourses_video(courses_video);
		c.setCourses_img_url(imageUrl);
		c.setTeacher_id(teacher_id);
		c.setCourses_pricemoney(courses_pricemoney);
		addCoursesTab(c);
	}

}
