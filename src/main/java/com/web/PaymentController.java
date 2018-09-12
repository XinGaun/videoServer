package com.web;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.PaymentService;

/**
 * 订单信息API
 * @author vip
 *
 */
@Controller
@ResponseBody
@RequestMapping("/hangrano2o/Payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;
	/**
	 * 支付接口
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/arousePayment",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String arousePayment(@RequestBody String data) throws IOException {	 
		return paymentService.arousePayment(data);
	}
	/**
	 * 支付接口
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/callbackOrder",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String callbackOrder(@RequestBody String data){	
		return paymentService.callbackOrder(data);
	}
	/**
	 * 前端订单撤销接口
	 * @param data
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping(value="/revocationOrder",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String revocationOrder(@RequestBody String data){	
		return paymentService.revocationOrder(data);
	}
}
