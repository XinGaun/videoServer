package com.web;

import java.io.File;

import javax.servlet.http.HttpServlet;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/oss")
public class OSSUploadController extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8925495603833428379L;

	@RequestMapping(value="/ossupload",produces="application/json;charset=utf-8",method= {RequestMethod.GET,RequestMethod.POST})
	@ResponseBody
	public void upload() {
		String path = this.getServletContext().getRealPath("/upload");
		System.out.println(path);
		File file = new File(path);
		System.out.println(file.getName());
	}
}
