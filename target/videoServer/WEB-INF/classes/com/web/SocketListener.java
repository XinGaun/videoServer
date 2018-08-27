package com.web;

import com.corundumstudio.socketio.AckRequest;
import com.corundumstudio.socketio.SocketIOClient;
import com.corundumstudio.socketio.SocketIOServer;
import com.corundumstudio.socketio.listener.ConnectListener;
import com.corundumstudio.socketio.listener.DataListener;
import com.corundumstudio.socketio.listener.DisconnectListener;

public class SocketListener implements ConnectListener ,DisconnectListener,DataListener<String>{

	private SocketIOServer server;

	public SocketListener(SocketIOServer server){
		this.server = server;
	}

	@Override
	public void onConnect(SocketIOClient client) {
		Integer clientSize = server.getAllClients().size();
		System.out.println("刚连上一个客户端，总共有" + clientSize + "客户端连接成功。");
	}

	@Override
	public void onDisconnect(SocketIOClient client) {
		Integer clientSize = server.getAllClients().size();
		System.out.println("刚离开一个客户端，总共有" + clientSize + "客户端连接成功。");
	}

	@Override
	public void onData(SocketIOClient client, String data, AckRequest ackSender)
			throws Exception {
		System.out.println("刚有一个数据从客户端过来" + data);
		ackSender.sendAckData("服务端消息收到!-----");
	}

}
