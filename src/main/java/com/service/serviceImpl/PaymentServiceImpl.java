package com.service.serviceImpl;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.OrderTabDao;
import com.entity.OrderTab;
import com.service.PaymentService;
import com.util.Authentication;

@Service
@SuppressWarnings("unchecked")
public class PaymentServiceImpl implements PaymentService{
	private String pivStr = "-----BEGIN PRIVATE KEY-----\r\n" + 
			"MIICeQIBADANBgkqhkiG9w0BAQEFAASCAmMwggJfAgEAAoGBAM9L1IZPj9cwsnFz\r\n" + 
			"tRFTPttAIRPW96D5Us6NPUB5It+5t2KVy8SB7lo3LoCfJBM+yGS2BHD+4WDsfPho\r\n" + 
			"t2R6Zci24zo7FBDItUUzIl735jglRFFrbvv5MD98Zl15PGVx5dAuJcwSxkIN0qeP\r\n" + 
			"qn0U0DyvjCKvC74Poqtb+34MINkTAgMBAAECgYEAxgM/bVTOp9XCfpDyYyxLnI+z\r\n" + 
			"iQoM3N2MdfWAjvenkmIKhMdmL72VeuO/LenWQfP05A7iSzWNAFKmRXtxwy8PzWO1\r\n" + 
			"UHvaWrw9axMwNB97lFEYhSUPv4v0F/7kaF5crN2oQcSgbnePqdzaD0PP2oA/qa0I\r\n" + 
			"d4GzJzAC0R9NfqBf1cECQQD1kY8kIkn10e6Gzu4Q7CW9duuZjJBtLL8p2iDMsVbl\r\n" + 
			"w/EDmquvjbrk3vVMuaxkixzwGN1XLq+TTsi+H7XA8MUDAkEA2BoTxYfcVuH3pJVt\r\n" + 
			"4J+NJ/brdfPnUNFsb6VS7uJXsiZ4cmZ5N0jYw7NWidY7uN+P00Q9zUPupkrVwmHB\r\n" + 
			"1142sQJBALubHJQqbf6TB3uOE2pyPtLkS1HfhWcizFiZAH3g7dZTP4nVXFyeFq5L\r\n" + 
			"d3PKVd3qOY1kMZUtYY1UnyBA8YYZaykCQQDG4FDb0+mih7jZXa/OLefBJMuTNNDn\r\n" + 
			"nqQVp2dIc0NTr3XfipD5oO/kQrJcja1OuWfqfP4HXwJNRcetaTv0UT8xAkEAzFZ1\r\n" + 
			"k0lj7nQSgx/wNG8uVC/mMed1/aIOhFgKJheCsporYgyP7CkOO5HV7lvq2DS1pFk2\r\n" + 
			"1lS4mVXpqUoQMQ1Qyw==\r\n" + 
			"-----END PRIVATE KEY-----\r\n" + 
			"";
	private String TAG = "cloudscale";//标识符
	private Logger logger = Logger.getLogger(PaymentServiceImpl.class);
	@Autowired
	private OrderTabDao orderTabDao;//调用订单Service层接口
	
	/**
	 * 唤起支付接口
	 * @throws IOException 
	 */
	@Override
	public String arousePayment(String data) throws IOException {
		HashMap<String,Object> retnmap = new HashMap<String,Object>();
		logger.info("/arousePayment data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		/*if(map.get("platform").equals("weixin")) {
			
			return JSON.toJSONString(map);
		}*/
		//map.put("call_back_url","http://test.cloud-scale.cn:2019/hangrano2o/Payment/callbackOrder");
		String pivStrs = pivStr.substring(28, pivStr.indexOf("-----END PRIVATE KEY-----"));
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date = dateFormat.format(new Date());
		String str = "CLOUDSCALE-CHECKOUT-"+date;
		String port ="http://test.cloud-scale.cn/3rd/"+TAG+"/payment/checkout";
		String httpResult = Authentication.HttpPostAuthentication(TAG, pivStrs, port, map,str);
		//HashMap<String,Object> retnmap = new HashMap<String,Object>();
		retnmap.put("code", 200);
		retnmap.put("data", httpResult);
		retnmap.put("msg","arousePayment success");
		return JSON.toJSONString(retnmap);
	}
	/**
	 * 调用付款回复接口
	 */
	@Override
	public String callbackOrder(String data) {
		logger.info("/callbackOrder data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data,HashMap.class);
		OrderTab orderTab = new OrderTab();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date = dateFormat.format(new Date());
		orderTab.setPay_date(date);
		orderTab.setOrde_id(Integer.parseInt(map.get("trade_no").toString()));
		orderTab.setPay_status("已支付");
		orderTab.setOrde_status("备货");
		orderTabDao.updateOrderTab(orderTab);//更新订单信息
		map.put("orde_id", orderTab.getOrde_id());
		map.put("pay_date", date);
		orderTabDao.updateFinancialTabEnd(map);//更新财务记录	
		orderTabDao.updateOrderDeliverTab(map);//更新配送单信息
		HashMap<String,Object> hashmap = new HashMap<String,Object>();
		hashmap.put("code", 200);
		hashmap.put("msg", "callbackOrder success");
		return JSON.toJSONString(hashmap);
	}
	/**
	 * 线上退款接口
	 */
	@Override
	public String onlineRefund(String data) {
		logger.info("/onlineRefund data: "+data);
		HashMap<String,Object> parameter = new HashMap<String,Object>();
		parameter.put("trade_no","我的退款单号");
		HashMap<String,Object> PlatformRefund = new HashMap<String,Object>();
		PlatformRefund.put("platform","alipay或者weixin");
		ArrayList<String> refunds = new ArrayList<String>();
		return null;
	}
	/**
	 * 前端商城撤销订单
	 */
	@Transactional
	public String revocationOrder(String data) {
		String pivStrs = pivStr.substring(28, pivStr.indexOf("-----END PRIVATE KEY-----"));
		DateFormat dateFormat = new SimpleDateFormat("yyyyMMdd");
		String date = dateFormat.format(new Date());
		String str = "CLOUDSCALE-CHECKOUT-"+date;
		String port ="http://test.cloud-scale.cn/3rd/"+TAG+"/payment/refund";
		
		
		
		logger.info("/revocationOrder data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		HashMap<String,Object> OrderMap = orderTabDao.queryOrderId(map);//查询订单信息
		HashMap<String,Object> retnmap = new HashMap<String,Object>();
		if(null!=OrderMap&&OrderMap.size()>0&&OrderMap.get("pay_status").equals("已支付")&&!OrderMap.get("orde_status").equals("已撤销")) {
			HashMap<String,Object> finaMap = orderTabDao.queryFinancialTabOredrID(OrderMap);
			HashMap<String,Object> refundMap = new HashMap<String,Object>();
			HashMap<String,Object> platformRefundMap = new HashMap<String,Object>();
			ArrayList<String> refundsList = new ArrayList<String>();
			refundMap.put("trade_no", refundMap.get("orde_id"));
			
			//判断退款方式
			if(OrderMap.get("pay_type").equals("weixin")) {
				platformRefundMap.put("platform","weixin");
				String refunds = finaMap.get("pay_number")+";"+finaMap.get("fina_id")+";"+finaMap.get("fina_id")+";"+finaMap.get("fina_money")+";"+finaMap.get("fina_money")+";"+"web_shop"; 
				refundsList.add(refunds);
				platformRefundMap.put("refunds", refundsList);
				refundMap.put("refund", platformRefundMap);
				try {
					String httpResult = Authentication.HttpPostAuthentication(TAG, pivStrs, port, refundMap,str);
					orderTabDao.updateOrderID(OrderMap);
					//添加财务记录信息
					retnmap.put("code", 200);
					retnmap.put("data", httpResult);
					retnmap.put("msg","revocationOrder success");
					return JSON.toJSONString(retnmap);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					retnmap.put("code", 500);
					retnmap.put("data", "");
					retnmap.put("msg","revocationOrder error :"+e.getMessage());
					return JSON.toJSONString(retnmap);
				}
			}else if(OrderMap.get("pay_type").equals("alipay")){
				platformRefundMap.put("platform","alipay");
				String refunds = finaMap.get("pay_number")+"^"+finaMap.get("fina_money")+"^订单撤销退款^web_shop";
				refundsList.add(refunds);
				platformRefundMap.put("refunds", refundsList);
				refundMap.put("refund", platformRefundMap);
				try {
					String httpResult = Authentication.HttpPostAuthentication(TAG, pivStrs, port, refundMap,str);	
					orderTabDao.updateOrderID(OrderMap);
					retnmap.put("code", 200);
					retnmap.put("data", httpResult);
					retnmap.put("msg","arousePayment success");
					return JSON.toJSONString(retnmap);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					retnmap.put("code", 500);
					retnmap.put("data", "");
					retnmap.put("msg","revocationOrder error :"+e.getMessage());
					return JSON.toJSONString(retnmap);
				}
			}
			return JSON.toJSONString("error: Wrong refund method!");
		}else if(!OrderMap.get("pay_status").equals("已支付")) {
			orderTabDao.updateOrderID(OrderMap);
			retnmap.put("code", 200);
			retnmap.put("data", "");
			retnmap.put("msg","revocationOrder success");
			return JSON.toJSONString(retnmap);
		}
		else {
			logger.info("/revocationOrder return: error Invalid order number!");
			retnmap.put("code", 400);
			retnmap.put("data", "");
			retnmap.put("msg","revocationOrder error : Invalid order number!");
			return JSON.toJSONString(retnmap);
		}
	}
}
