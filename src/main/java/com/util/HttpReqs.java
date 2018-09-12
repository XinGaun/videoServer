package com.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpReqs {
	/**
	 * 请求API数据
	 * @param requestUrl API地址
	 * @param requestMethod 请求方式"post"或"get"
	 * @param outputStr 请求参数
	 * @return
	 * @throws IOException 
	 */
	public static String httpRequest(String requestUrl,String requestMethod,String outputStr,String ThirdPartyToken) throws IOException{  
        StringBuffer buffer=null;  
        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br =null;
        try{  
        URL url=new URL(requestUrl);  
        HttpURLConnection conn=(HttpURLConnection)url.openConnection();  
        conn.setDoOutput(true);  
        conn.setDoInput(true);  
        conn.setRequestMethod(requestMethod);  
        conn.setRequestProperty("Content-Type","application/json");
        conn.setRequestProperty("ThirdPartyToken", ThirdPartyToken);
        conn.connect();  
        //发起http请求参数  
        if(null!=outputStr){  
            OutputStream os=conn.getOutputStream();  
            os.write(outputStr.getBytes("utf-8"));  
            os.close();  
        }           
        //读取API返回的内容  
        is=conn.getInputStream();  
        isr=new InputStreamReader(is,"utf-8");  
        br=new BufferedReader(isr);  
        buffer=new StringBuffer();  
        String line=null;  
        while((line=br.readLine())!=null){  
            buffer.append(line);  
        }  
        }catch(Exception e){  
        	is.close();
        	isr.close();
            br.close();
            e.printStackTrace();  
        }finally {
        	is.close();
        	isr.close();
            br.close();
        }  
        return buffer.toString();  
    }  
}
