package com.web;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.util.ProgressSingleton;
@Controller
@RequestMapping("/ProgressServlet")
public class ProgressServlet extends HttpServlet {//　进度servlet：
	private static final long serialVersionUID = 1L;  
	public ProgressServlet() {
		super();	
	}
	@RequestMapping(value="/progress",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	@ResponseBody
	public String doPost(HttpServletRequest request, HttpServletResponse response,@RequestParam String fileName,@RequestParam String filePath) throws ServletException, IOException {
		System.out.println("press"+fileName+' '+filePath);
		File file = new File(filePath);
		String fileNameStr = file.getName();
		if(fileName == null || fileName == "" )   {    	
			fileName = fileNameStr;
		}else if(!fileName.contains(".")) {
			fileName = fileName+fileNameStr.substring(fileNameStr.indexOf("."));
		}			
		Object size = ProgressSingleton.get(fileName + "size");
		System.out.println(fileName + "size"+"  "+size);
		size = size == null ? 100 : size;
		Object progress = ProgressSingleton.get(fileName + "progress");
		System.out.println(fileName + "progress"+"  "+progress);
		progress = progress == null ? 0 : progress; 
		JSONObject json = new JSONObject();
		json.put("size", size);
		json.put("progress", progress);

		return json.toString();
	}

}
