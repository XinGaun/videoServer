package com.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.util.OSSUtil;
@Controller
@RequestMapping("/UploadServlet")
public class UploadServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	public OSSUtil ossUtil = new OSSUtil();

	@RequestMapping(value="/upload",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void uploadflv(String fileName,String video_url,String image_url,HttpServletRequest request) throws Exception{
		System.out.println("upload"+fileName);
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(4*1024);
		ossUtil.uploadJD(video_url, fileName);
		ossUtil.upload(image_url,null);
	}
}
