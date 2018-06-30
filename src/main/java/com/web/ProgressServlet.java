package com.web;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.util.ProgressSingleton;
@Controller
@RequestMapping("/ProgressServlet")
public class ProgressServlet extends HttpServlet {//　进度servlet：
	private static final long serialVersionUID = 1L;  
	public ProgressServlet() {
		super();	
	}
	@RequestMapping(value="/progress",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public String doPost(@RequestParam(value = "videoName") String videoName,@RequestParam(value = "video") MultipartFile video,HttpServletRequest request) throws Exception{
		System.out.println("press"+videoName);
		try {  
			String filePath = video.getOriginalFilename();
			String ossFileName = videoName+filePath.substring(filePath.lastIndexOf("."));
			System.out.println(ossFileName);
			Object size = ProgressSingleton.get(ossFileName + "size");
			System.out.println("press"+ossFileName + "size"+"  "+size);
			size = size == null ? 100 : size;
			Object progress = ProgressSingleton.get(ossFileName + "progress");
			System.out.println(ossFileName + "progress"+"  "+progress);
			progress = progress == null ? 0 : progress; 
			JSONObject json = new JSONObject();
			json.put("size", size);
			json.put("progress", progress);
			return json.toString();


		} catch (Exception e) {  
			e.printStackTrace();  

		}
		return "error";  




	}

}
