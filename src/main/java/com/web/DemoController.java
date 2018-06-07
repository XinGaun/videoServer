package com.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.util.Tool;
import com.web.entity.APIError;


public class DemoController {
	protected final Logger  logger = LoggerFactory.getLogger(this.getClass());  
	
	protected HashMap<String, Object> formQuery(String query) {
		logger.info("Receive query: "+query);
		HashMap<String, Object> querytable = new HashMap<String, Object>();
		try {
			if(!Tool.isEmpty(query) || !query.toLowerCase().contains("null")) {
				querytable= new Gson().fromJson(query, new TypeToken<HashMap<String,Object>>() {
					@SuppressWarnings("unused")
					private static final long serialVersionUID = 3893043968492967462L;}.getType());
			}
		} catch (Exception e) {
			logger.info("Parse query failed due to: "+e.getMessage());
		}
		logger.info("Extracted query: "+querytable);
		if(querytable == null) querytable = new HashMap<String, Object>();
		return querytable;
	}
	
	public static void toJson(HttpServletResponse response, Object data)   
			throws IOException {  
		Gson gson = new Gson();  
		String result = null;
		if(data==null){
			APIError response1=new APIError();
			response1.setErrorCode("1");
			response1.setErrorMsg("response is empty: "+data);		
			result = gson.toJson(response1); 
		}	else {			
			result = gson.toJson(data);  
		}
		response.setContentType("text/json; charset=gbk");  
		response.setHeader("Cache-Control", "no-cache"); //取消浏览器缓存  
		PrintWriter out = response.getWriter();  
		out.print(result);  
		out.flush();  
		out.close();  
	} 
	
	
}
