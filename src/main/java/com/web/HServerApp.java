package com.web;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

import com.alibaba.fastjson.JSONObject;
import com.util.ProgressSingleton;

public class HServerApp implements Runnable{
	public int port = 8080;

	public HServerApp(int port) {
		this.port = port;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 try {
	            ServerSocket server = new ServerSocket(8080,1, InetAddress.getByName("127.0.0.1"));
	            while (true) {
	               
	                //等待client的请求
	                System.out.println("waiting...");
	                Socket socket = server.accept();
	                // 接收客户端的数据
	                DataInputStream in = new DataInputStream(socket.getInputStream());
	                String ossFileName = in.readUTF();
	                System.out.println("client:" + ossFileName);
	                // 发送给客户端数据
	                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
	                String data = getData(ossFileName);
	                out.writeUTF("hi,i am hserver!i say:" + data);
	                socket.close();
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
	
	public String getData(String ossFileName) {
		try {  
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
