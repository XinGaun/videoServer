package com.service;

import java.io.IOException;

public interface PaymentService {
	/**
	 * 拉起支付接口
	 * @param data
	 * @return
	 * @throws IOException
	 */
	public String arousePayment(String data)  throws IOException;
	/**
	 * 付款回复接口
	 * 
	 */
	public String callbackOrder(String data);
	/**
	 * 线上退款接口
	 */
	public String onlineRefund(String data);
	/**
	 * 前端商城撤销订单
	 * @param data
	 * @return
	 */
	public String revocationOrder(String data);
}
