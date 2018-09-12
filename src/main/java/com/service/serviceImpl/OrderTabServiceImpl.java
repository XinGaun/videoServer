package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.ComeWarehouseTabDao;
import com.dao.InstallTabDao;
import com.dao.OrderTabDao;
import com.dao.SalesRecordTabDao;
import com.entity.InstallTab;
import com.entity.OrderTab;
import com.service.ComeWarehouseTabService;
import com.service.OrderTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 订单Service层接口
 * @author vip
 *
 */
@Service
@SuppressWarnings("unchecked")
public class OrderTabServiceImpl implements OrderTabService {
	@Autowired
	private ComeWarehouseTabService comeWarehouseTabService;//调用出库单Service层信息
	@Autowired
	private OrderTabDao orderTabDao;//调用订单Dao层接口
	@Autowired
	private InstallTabDao installTabDao;//调用安装单Dao层接口
	@Autowired
	private SalesRecordTabDao recordTabDao;//调用商品销售记录Dao层接口
	private Logger logger = Logger.getLogger(OrderTabServiceImpl.class);

	/**
	 * 添加订单
	 */
	@Transactional
	public String addOrderTab(String data) {
		logger.info("/addOrderTab data: "+data);
		HashMap<String,Object> orderTab = JSON.parseObject(data, HashMap.class);
		orderTab.put("fina_id", -1);
		int flag= orderTabDao.addFinancialTab(orderTab);
		orderTab.put("orde_id", -1);
		int flog = orderTabDao.addOrderTab(orderTab);
		flag = orderTabDao.updateFinancialTab(orderTab);//更新财务记录
		Integer orde_id = Integer.parseInt(orderTab.get("orde_id").toString());
		ArrayList<String> recordTab = JSON.parseObject(orderTab.get("recordTab").toString(),ArrayList.class);
		for(int i=0;i<recordTab.size();i++) {

			HashMap<String,Object> recoMap = JSON.parseObject(JSON.toJSONString(recordTab.get(i)), HashMap.class);
			int num = Integer.parseInt(recoMap.get("sale_num").toString());
			recoMap.put("orde_id",orde_id);
			//recoMap.put("comm_putaway_id", recoMap.get("comm_id"));
			for(int s=0;s<num;s++) {
				recordTabDao.addSalesRecordTab(recoMap);
			}	
		}
		//添加配送单
		if(orderTab.get("delivery_type").equals("配送")) {
			HashMap<String,Object> Delivery = new HashMap<String,Object>();
			Delivery.put("orde_id",orde_id);
			Delivery.put("jdde_id",orderTab.get("jdde_id"));
			Delivery.put("deli_contacts",orderTab.get("deli_contacts"));
			Delivery.put("deli_status","未激活");
			Delivery.put("deli_addr",orderTab.get("orde_addr"));
			Delivery.put("deli_make_date",orderTab.get("deli_make_date"));
			Delivery.put("deli_remark",orderTab.get("orde_remark"));
			Delivery.put("deli_phone",orderTab.get("orde_phone"));
			Delivery.put("deli_name",orderTab.get("deli_contacts"));
			orderTabDao.addOrderDeliverTab(Delivery);//添加配送单
		}
		HashMap<String,Object> map = new HashMap<String,Object>();
		map.put("fina_id", orderTab.get("fina_id"));
		map.put("orde_id", orde_id);
		if(flog>0&&flag>0) {
			return JSON.toJSONString(Count.counts(null, 0,map,200,"addOrderTab success"));
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询订单
	 */
	@Override
	public String queryOrderTab(String data) {
		logger.info("/queryOrderTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = orderTabDao.queryOrderTab(hashMap);
		int count = orderTabDao.queryOrderTabCount(hashMap);
		//list=Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryOrderTab success"));
	}
	/**
	 * 更新订单
	 */
	@Override
	public String updateOrderTab(String data) {
		logger.info("/updateOrderTab data: "+data);
		OrderTab orderTab = JSON.parseObject(data, OrderTab.class);
		int flog = orderTabDao.updateOrderTab(orderTab);
		if(null!=orderTab.getOrde_status()&&orderTab.getOrde_status().equals("撤销")) {
			HashMap<String,Object> map = new HashMap<String, Object>();
			map.put("orde_id", orderTab.getOrde_id());
			map.put("deli_status", orderTab.getOrde_status());
			map.put("inst_status", orderTab.getOrde_status());
			orderTabDao.updateOrdeIDDeli(map);
			orderTabDao.updateOrdeIDInst(map);
		}
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除订单
	 */
	@Transactional
	public String deleteOrderTab(String data) {
		logger.info("/deleteOrderTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int orde_id = list.get(i);
			int flog = orderTabDao.deleteOrderTab(orde_id);
			if(flog<=0) {
				retlist.add(orde_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 后端购物结算订单
	 */
	@Transactional
	public String addOrderBack(String data) {
		logger.info("/addOrderBack data: "+data);
		HashMap<String,Object> orderTab = JSON.parseObject(data, HashMap.class);
		orderTab.put("pay_date", DateUtil.getNowDate());
		orderTab.put("orde_date", DateUtil.getNowDate());
		//1.添加买家信息
		orderTab.put("buye_id", -1);
		orderTabDao.addBuyerTab(orderTab);
		//2.如果有收货地址
		//if(orderTab.containsKey("deli_addr")) {
		orderTabDao.addDeliverYaddrTab(orderTab);
		//}
		//3.添加财务记录
		orderTab.put("fina_id", -1);
		int flag= orderTabDao.addFinancialTab(orderTab);//添加财务记录
		orderTab.put("orde_id", -1);
		//4.添加订单
		int flog = orderTabDao.addOrderBack(orderTab);
		flag = orderTabDao.updateFinancialTab(orderTab);//更新财务记录
		//5.如果有配送单
		Integer orde_id = Integer.parseInt(orderTab.get("orde_id").toString());
		if(orderTab.containsKey("deli_addr")) {
			orderTab.put("deli_id", -1);
			flag=orderTabDao.addOrderDeliverTab(orderTab);
			OrderTab tab = new OrderTab();
			tab.setOrde_id(orde_id);
			tab.setDeli_id(Integer.parseInt(orderTab.get("deli_id").toString()));
			orderTabDao.updateOrderTab(tab);//更新订单记录
		}
		//预约安装信息
		if(orderTab.containsKey("install")) {
			InstallTab installTab = new InstallTab();
			installTab.setOrde_id(orde_id);
			installTab.setInst_unit_id(Integer.parseInt(orderTab.get("inst_unit_id").toString()));
			installTab.setInst_addr(orderTab.get("inst_addr").toString());
			installTab.setInst_phone(orderTab.get("inst_phone").toString());
			installTab.setInst_name(orderTab.get("inst_name").toString());
			installTab.setInst_status("创建");
			installTab.setInst_make_date(orderTab.get("inst_make_date").toString());
			installTab.setStaf_id(Integer.parseInt(orderTab.get("staf_sell_id").toString()));
			installTab.setInst_id(-1);
			installTabDao.addInstallTab(installTab);//添加安装单信息
			OrderTab orderTab2 = new OrderTab();
			orderTab2.setOrde_id(orde_id);
			orderTab2.setInst_id(installTab.getInst_id());
			orderTabDao.updateOrderTab(orderTab2);//更新订单信息
		}
		int temp = -1;
		if(null!=orderTab.get("plus")&&orderTab.get("plus").equals("1")) {
			temp = 1;
		}
		ArrayList<String> recordTab = JSON.parseObject(orderTab.get("recordTab").toString(),ArrayList.class);
		for(int i=0;i<recordTab.size();i++) {
			HashMap<String,Object> recoMap = JSON.parseObject(JSON.toJSONString(recordTab.get(i)), HashMap.class);
			int index = Integer.parseInt(recoMap.get("sale_num").toString());
			recoMap.put("orde_id",orde_id);
			for(int s=0;s<index;s++) {
				//System.out.println(JSON.toJSON(recoMap));
				if(temp>0) {
					float real_price=Float.parseFloat(recoMap.get("real_price").toString());
					int real_prices= (int)(real_price+1);
					recoMap.put("real_price", real_prices+".00");
					temp=-1;
					recordTabDao.addSalesRecordTab(recoMap);//6.添加商品销售记录
					recoMap.put("real_price", (int)real_price+".00");
				}else {
					recordTabDao.addSalesRecordTab(recoMap);//6.添加商品销售记录
				}
				
				
			}
		}
		//如果需要出库
		if(orderTab.containsKey("removal")) {
			HashMap<String,Object> chukuMap = new HashMap<String,Object>();
			chukuMap.put("orde_id", orde_id);
			chukuMap.put("come_ware_cause","配送");
			chukuMap.put("staff_id",orderTab.get("staf_sell_id"));
			chukuMap.put("orde_index",0);
			chukuMap.put("inve_alter_type","出库");
			chukuMap.put("inve_alter_date",DateUtil.getNowDate());
			chukuMap.put("warehouse_id",orderTab.get("warehouse_id"));
			chukuMap.put("inve_alter_cause","配送");

			String result = comeWarehouseTabService.departLibrary(JSON.toJSONString(chukuMap));
			if(result.equals("The goods less than")) {
				int s = 1/0;
			}

		}
		if(flog>0&&flag>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除未结算订单信息
	 */
	@Transactional
	public String deleteOrderBack(String data) {
		logger.info("/deleteOrderBack data: "+data);
		HashMap<String,Object> orderTab = JSON.parseObject(data, HashMap.class);
		int flog = orderTabDao.deleteOrderFinancial(orderTab);
		flog = orderTabDao.deleteOrderRecord(orderTab);
		int orde_id = Integer.parseInt(orderTab.get("orde_id").toString());
		flog = orderTabDao.deleteOrderTab(orde_id);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 后台购物结算订单
	 */
	@Transactional
	public String settleOrder(String data) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * 商城前端查询用户个人订单详情
	 */
	@Override
	public String queryBuyerOrder(String data) {
		logger.info("/queryBuyerOrder data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<OrderTab> list = null;
		list= orderTabDao.queryBuyerOrder(map);	
		return Count.resultMap(list, 200,"queryBuyerOrder success", map);
	}
	/**
	 * 商城前端查询用户个人通过订单ID订单详情
	 */
	@Override
	public String queryBuyerOrderDetails(String data) {
		logger.info("/queryBuyerOrderDetails data: "+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		OrderTab orderTab = orderTabDao.queryBuyerOrderDetails(map);
		ArrayList<ArrayList<HashMap<String,Object>>> arrayList = new ArrayList<ArrayList<HashMap<String,Object>>>();
		ArrayList<HashMap<String,Object>> SaleMap = orderTabDao.querySaleOrderID(map);
		//HashMap<String,Object> SaleHashMap = new HashMap<String,Object>();

		for(int i=0;i<SaleMap.size();i++) {
			if(arrayList.size()==0) {
				ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
				list.add(SaleMap.get(i));
				arrayList.add(list);
			}else {
				int flog = -1;
				for(int s=0;s<arrayList.size();s++) {
					if(arrayList.get(s).get(0).get("comm_putaway_id")==SaleMap.get(i).get("comm_putaway_id")) {
						flog =1;
						arrayList.get(s).add(SaleMap.get(i));
						break;
					}
				}
				if(flog==-1) {
					ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
					list.add(SaleMap.get(i));
					arrayList.add(list);
				}
			}
		}
		orderTab.setSaleList(arrayList);
		HashMap<String,Object> resultMap = new HashMap<String,Object>();
		resultMap.put("code", 200);
		resultMap.put("orderTab", orderTab);
		resultMap.put("msg", "queryBuyerOrderDetails success");
		return JSON.toJSONString(resultMap);
	}



}
