package com.web;

import java.awt.Robot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.Configuration;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.DataListener;
import com.util.ProgressSingleton;
@Controller
@RequestMapping("/socketServer")
public class SocketServer {
	
	public SocketIOServer server;
	public SocketListener socketListener;
	public SocketServer() {
		Configuration config = new Configuration();
		config.setHostname("127.0.0.1");
		config.setPort(Integer.parseInt("8099"));
		server = new SocketIOServer(config);
		socketListener = new SocketListener(server);        	        
		//客户端连接上时触发
		server.addConnectListener(socketListener);

		//监听客户端消息
		//工单产品执行监控表头数据，只发一次，需要由客户端请求后发送
		//	        server.addEventListener("testMessage", String.class,new TroutingWipHEventListener());

		/**
		 * 添加监听事件，监听客户端的事件
		 * 1.第一个参数eventName需要与客户端的事件要一致
		 * 2.第二个参数eventClase是传输的数据类型
		 * 3.第三个参数listener是用于接收客户端传的数据，数据类型需要与eventClass一致
		 */	
		server.addEventListener("fileUpload", String.class,new DataListener<String>() {
			@Override
			public void onData(SocketIOClient client, String videoName, AckRequest ackSender) throws Exception {
				// TODO Auto-generated method stub			
				System.err.println("接收到客户端的信息为：" + videoName);
				//向客户端发送消息
				if(ProgressSingleton.get(videoName + "status") == null) {
					client.sendEvent("fileUpload", "null");
				}else {
					while(!(ProgressSingleton.get(videoName + "status").equals("end") )) {	
						  // 创建机器人
				        Robot robot = new Robot();
				        // 设置默认休眠时间
				        robot.setAutoDelay(5000);
						Object size = ProgressSingleton.get(videoName + "size");					
						size = size == null ? 100 : size;
						Object progress = ProgressSingleton.get(videoName + "progress");				
						progress = progress == null ? 0 : progress; 		
						//System.out.println("progress   "+progress+"size   "+size);
						long progressint = new Long(progress.toString());
						long sizeint =new Long(size.toString());
						int proess = (int)(progressint * 100.0 / sizeint);
						//第一个参数必须与eventName一致，第二个参数data必须与eventClass一致
						//System.out.println("%   "+proess);
						client.sendEvent("fileUpload", Integer.toString(proess));
					}
				}
			}			
		});
		//客户断连接断开时触发
		server.addDisconnectListener(socketListener);
	}
	@RequestMapping(value="/start",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void start() {
		//启动服务
		System.out.println("socket start");
		server.start();
	}	
	@RequestMapping(value="/stop",produces="application/json;charset=utf-8", method={RequestMethod.POST,RequestMethod.GET})
	@ResponseBody
	public void stop() {
		System.out.println("socket stop");
		server.stop();
	}
	/*
	public static void main(String[] args) {
		SocketServer server = new SocketServer();
		server.start();
	}*/

}
