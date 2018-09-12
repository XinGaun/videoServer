package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map.Entry;

public class HttpReq {
	/**
	 * 请求API数据
	 * @param requestUrl API地址
	 * @param requestMethod 请求方式"post"或"get"
	 * @param outputStr 请求参数
	 * @return
	 */
	public static String httpRequest(String requestUrl,String requestMethod,String outputStr){  
		StringBuffer buffer=null;  
		try{  
			URL url=new URL(requestUrl);  
			HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
			conn.setDoOutput(true);  
			conn.setDoInput(true);  
			conn.setRequestMethod(requestMethod);  
			conn.setRequestProperty("Content-Type","application/json");
			conn.connect();  
			//发起http请求参数  
			if(null!=outputStr){  
				OutputStream os=conn.getOutputStream();  
				os.write(outputStr.getBytes("utf-8"));  
				os.close();  
			}           
			//读取API返回的内容  
			InputStream is=conn.getInputStream();  
			InputStreamReader isr=new InputStreamReader(is,"utf-8");  
			BufferedReader br=new BufferedReader(isr);  
			buffer=new StringBuffer();  
			String line=null;  
			while((line=br.readLine())!=null){  
				buffer.append(line);  
			}  
		}catch(Exception e){  
			e.printStackTrace();  
		}  
		return buffer.toString();  
	}  
	/**
	 * 请求API数据
	 * @param requestUrl API地址
	 * @param requestMethod 请求方式"post"或"get"
	 * @param outputStr 请求参数
	 * @return
	 */
	public static String httpRequestsfrom(String urlParam,String requestMethod,HashMap<String,Object> params){  
		StringBuffer resultBuffer = null;
		// 构建请求参数
		StringBuffer sbParams = new StringBuffer();
		if (params != null && params.size() > 0) {
			for (Entry<String, Object> e : params.entrySet()) {
				sbParams.append(e.getKey());
				sbParams.append("=");
				sbParams.append(e.getValue());
				sbParams.append("&");
			}
			HttpURLConnection con = null;
			OutputStreamWriter osw = null;
			BufferedReader br = null;
			// 发送请求
			try {
				URL url = new URL(urlParam);
				con = (HttpURLConnection) url.openConnection();
				con.setRequestMethod("POST");
				con.setDoOutput(true);
				con.setDoInput(true);
				con.setUseCaches(false);
				con.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
				if (sbParams != null && sbParams.length() > 0) {
					osw = new OutputStreamWriter(con.getOutputStream(), "utf-8");
					osw.write(sbParams.substring(0, sbParams.length() - 1));
					osw.flush();
				}
				// 读取返回内容
				resultBuffer = new StringBuffer();
				int contentLength = Integer.parseInt(con.getHeaderField("Content-Length"));
				if (contentLength > 0) {
					br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
					String temp;
					while ((temp = br.readLine()) != null) {
						resultBuffer.append(temp);
					}
				}
			} catch (Exception e) {

				throw new RuntimeException(e);
			}finally {
				if (osw != null) {
					try {
						osw.close();
					} catch (IOException e) {
						osw = null;
						throw new RuntimeException(e);
					} finally {
						if (con != null) {
							con.disconnect();
							con = null;
						}
					}
				}
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						br = null;
						throw new RuntimeException(e);
					} finally {
						if (con != null) {
							con.disconnect();
							con = null;
						}
					}
				}
				
			}
		}
		return resultBuffer.toString();
	}  
}
