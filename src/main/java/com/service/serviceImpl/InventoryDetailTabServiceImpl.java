package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.ComeWarehouseTabDao;
import com.dao.CommodityTabDao;
import com.dao.DeliverTabDao;
import com.dao.InventoryDetailTabDao;
import com.dao.SalesRecordTabDao;
import com.dao.StaffTabDao;
import com.dao.WarehouseTabDao;
import com.entity.DeliverTab;
import com.entity.InventoryDetailTab;
import com.service.InventoryDetailTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 库存明细表Service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class InventoryDetailTabServiceImpl implements InventoryDetailTabService {
	@Autowired
	private InventoryDetailTabDao inventoryDetailTabDao;//调用库存明细表Dao层接口
	@Autowired 
	private WarehouseTabDao warehouseTabDao;//调用仓库Dao层接口
	@Autowired
	private CommodityTabDao commodityTabDao;//调用商品Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口
	@Autowired
	private ComeWarehouseTabDao comeWarehouseTabDao;//调用出库单Dao层接口
	@Autowired
	private DeliverTabDao deliverTabDao;//调用配送单Dao层接口
	@Autowired
	private SalesRecordTabDao recordTabDao;//调用商品销售记录Dao层接口
	private Logger logger = Logger.getLogger(InventoryDetailTabServiceImpl.class);
	/**
	 * 添加库存明细信息
	 */
	@Override
	public String addInventoryDetailTab(String data) {
		logger.info("/addInventoryDetailTab data: "+data);
		InventoryDetailTab inventoryDetailTab = JSON.parseObject(data, InventoryDetailTab.class);
		int flog = inventoryDetailTabDao.addInventoryDetailTab(inventoryDetailTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询库存明细信息
	 */
	@Override
	public String queryInventoryDetailTab(String data) {
		logger.info("/queryInventoryDetailTab data: "+data);
		logger.info("/queryInstallUnitTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap= Page.page(hashMap);
		ArrayList<HashMap<String,Object>> list = inventoryDetailTabDao.queryInventoryDetailTab(hashMap);
		for(int i =0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> warehouse = warehouseTabDao.queryWarehouseTab(list.get(i));
			list.get(i).put("comm_putaway_id",list.get(i).get("comm_id"));
			list.get(i).put("comm_id", null);
			ArrayList<HashMap<String,Object>> commodity = commodityTabDao.queryCommodityTab(list.get(i));
			HashMap<String,Object> stfmap = new HashMap<String,Object>();
			stfmap.put("staf_id", list.get(i).get("staf_id"));
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(stfmap);
			if(list.get(i).containsKey("come_ware_id")) {
				ArrayList<HashMap<String,Object>> comeWarehouse = comeWarehouseTabDao.queryComeWarehouseTab(list.get(i));
				list.get(i).put("comeWarehouse", comeWarehouse);
			}
			list.get(i).put("warehouse", warehouse);
			list.get(i).put("commodity", commodity);
			list.get(i).put("staff", staff);
		}
		int count = inventoryDetailTabDao.queryInventoryDetailTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		logger.info("/queryInventoryDetailTab data:1111 "+data);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryInstallUnitTab success"));
	}
	/**
	 * 更新库存明细信息
	 */
	@Override
	public String updateInventoryDetailTab(String data) {
		logger.info("/updateInventoryDetailTab data: "+data);
		InventoryDetailTab inventoryDetailTab = JSON.parseObject(data, InventoryDetailTab.class);
		int flog = inventoryDetailTabDao.updateInventoryDetailTab(inventoryDetailTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除库存明细信息
	 */
	@Transactional
	public String deleteInventoryDetailTab(String data) {
		logger.info("/deleteInventoryDetailTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int inve_id = list.get(i);
			int flog = inventoryDetailTabDao.deleteInventoryDetailTab(inve_id);
			if(flog<=0) {
				retlist.add(inve_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 通过配送单ID查询库存详情信息
	 */
	@Override
	public String queryDeliIdInventoryDetailTab(String data) {
		logger.info("/queryDeliIdInventoryDetailTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> deliver = deliverTabDao.queryDeliverTab(hashMap);
		HashMap<String,Object> commMap = new HashMap<String,Object>();
		commMap.put("page",100000);
		commMap.put("nums",0);
		for(int i=0;i<deliver.size();i++) {
			ArrayList<HashMap<String,Object>> record = recordTabDao.querySalesRecordTab(deliver.get(i));
			commMap.put("comm_id", record.get(i).get("comm_id"));
		}
		return queryInventoryDetailTab(JSON.toJSONString(commMap));
	}
	/**
	 * 入库
	 */
	@SuppressWarnings("unused")
	@Transactional
	public String purchaseAccess(String data) {
		logger.info("/purchaseAccess data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data, HashMap.class);
		hashMap.put("inve_join_date", DateUtil.getNowDate());
		hashMap.put("inve_alter_date", DateUtil.getNowDate());
		if(hashMap.containsKey("chan_id")) {//退换货入库
			return ChangingPurchaseAccess(hashMap);
		}
		int num = Integer.parseInt(hashMap.get("num").toString());	
		if(hashMap.containsKey("purc_id")) {//更新采购单
			hashMap.put("purc_id", null);
			//查询采购单信息
			/*HashMap<String,Object> purcMap = inventoryDetailTabDao.queryPurchaseTab(hashMap);
			if(!purcMap.get("purc_status").equals("创建")&&!purcMap.get("purc_status").equals("部分完成")) {
				return JSON.toJSONString("error submit again!");
			}
			if(purcMap.containsKey("purc_need_id")) {//更新采购需求信息
				//查询采购需求信息
				HashMap<String,Object> purcNeedMap = inventoryDetailTabDao.querypurchaseNeedTab(purcMap);
				int acc_num = Integer.parseInt(purcNeedMap.get("acc_num").toString());
				int purc_need_num = Integer.parseInt(purcNeedMap.get("purc_need_num").toString());
				acc_num = acc_num+num;
				purcNeedMap.put("acc_num", acc_num);
				if((purc_need_num-acc_num)<=0) {
					purcNeedMap.put("purc_need_status","全部完成");
					purcMap.put("purc_status","全部完成");
				}else {
					purcNeedMap.put("purc_need_status","部分完成");
					purcMap.put("purc_status","部分完成");
				}
				//查询是否有缺货登记记录,有就更改状态
				ArrayList<HashMap<String,Object>> reglist= inventoryDetailTabDao.queryregistration(purcMap);
				if(reglist.size()>0) {//更新缺货登记记录状态
					reglist.get(0).put("want_status", purcMap.get("purc_status"));
					inventoryDetailTabDao.updateregistration(reglist.get(0));//更新缺货登记记录
				}
				//更新采购需求信息
				inventoryDetailTabDao.updatepurchaseNeedTab(purcNeedMap);
			}
			//更新采购单状态
			inventoryDetailTabDao.updatePurchaseTab(purcMap);*/
			InventoryDetailTab idt =new InventoryDetailTab();
			//2添加库存明细
			for(int i=0;i<num;i++) {
				hashMap.put("inve_id",-1);
				hashMap.put("cargo_id", null);
				inventoryDetailTabDao.addRuKuInventoryDetailTabs(hashMap);//2. 将货物状态由在途改为在库
				idt.setCargo_id(hashMap.get("inve_id").toString());
				idt.setInve_id(Integer.parseInt(hashMap.get("inve_id").toString()));
				hashMap.put("cargo_id", hashMap.get("inve_id").toString());
				inventoryDetailTabDao.updateInventoryDetailTab(idt);
				//hashMap.put("cargo_id", hashMap.get("inve_id").toString());
				inventoryDetailTabDao.addinventoryAlterTab(hashMap);//1. 对每个货物ID生成一个入库记录，记录对应的出库单ID和其他相关单据ID
			}
			hashMap.put("bourn_ware_id", hashMap.get("warehouse_id"));
		}
		//入库流程
		if(hashMap.containsKey("come_ware_id")) {//调拨入库
			ArrayList<String> commIdList = JSON.parseObject(JSON.toJSONString(hashMap.get("comm_id")),ArrayList.class);
			//InventoryDetailTab idt =new InventoryDetailTab();
			for(int i=0;i<commIdList.size();i++) {
				HashMap<String,Object> commMap = JSON.parseObject(JSON.toJSONString(commIdList.get(i)),HashMap.class);
				hashMap.put("comm_id",commMap.get("comm_id"));
				hashMap.put("cargo_id",commMap.get("cargo_id"));
				hashMap.put("inve_alter_code",commMap.get("inve_alter_code"));
				int flog = inventoryDetailTabDao.addRuKuInventoryDetailTab(hashMap);//2. 将货物状态由在途改为在库
				flog = inventoryDetailTabDao.addinventoryAlterTab(hashMap);//1. 对每个货物ID生成一个入库记录，记录对应的出库单ID和其他相关单据ID
			}
			ArrayList<HashMap<String,Object>> stocklist = inventoryDetailTabDao.queryStockTab(hashMap);//3. 扣减在途量，增加在库量
			//修改目标仓库库存量
			int stoc_count = Integer.parseInt(stocklist.get(0).get("stoc_count").toString());
			int ship_count = Integer.parseInt(stocklist.get(0).get("ship_count").toString());
			ship_count = ship_count-num;
			stoc_count = stoc_count+num;
			stocklist.get(0).put("ship_count", ship_count);
			stocklist.get(0).put("stoc_count", stoc_count);
			inventoryDetailTabDao.updateStockTab(stocklist.get(0));

			//修改源仓库在途量
			HashMap<String,Object> souMap = new HashMap<String,Object>();
			souMap.put("source_ware_id", hashMap.get("source_ware_id"));
			souMap.put("comm_id", hashMap.get("comm_id"));
			ArrayList<HashMap<String,Object>> Sustocklist = inventoryDetailTabDao.querySouStockTab(souMap);
			int ship_counts = Integer.parseInt(Sustocklist.get(0).get("ship_count").toString());
			ship_counts = ship_counts-num;
			Sustocklist.get(0).put("ship_count", ship_counts);
			inventoryDetailTabDao.updateStockTab(Sustocklist.get(0));
			return JSON.toJSONString("success");
		}


		ArrayList<HashMap<String,Object>> stocklist = inventoryDetailTabDao.queryStockTab(hashMap);//3. 扣减在途量，增加在库量

		if(hashMap.containsKey("source_ware_id")) {


			HashMap<String,Object> souMap = new HashMap<String,Object>();
			souMap.put("source_ware_id", hashMap.get("source_ware_id"));
			souMap.put("comm_id", hashMap.get("comm_id"));
			ArrayList<HashMap<String,Object>> Sustocklist = inventoryDetailTabDao.querySouStockTab(souMap);
			int ship_count = Integer.parseInt(Sustocklist.get(0).get("ship_count").toString());
			ship_count = ship_count-num;
			Sustocklist.get(0).put("ship_count", ship_count);
			inventoryDetailTabDao.updateStockTab(Sustocklist.get(0));
		}
		int flog = -1;

		if(stocklist.size()==0) {
			hashMap.put("bum", 0);
			flog = inventoryDetailTabDao.addStockTab(hashMap);
		}else {
			if (hashMap.containsKey("purc_id")) {
				int stoc_count = Integer.parseInt(stocklist.get(0).get("stoc_count").toString());
				stoc_count = stoc_count+num;
				stocklist.get(0).put("stoc_count", stoc_count);
				flog = inventoryDetailTabDao.updateStockTab(stocklist.get(0));
			}else {
				int stoc_count = Integer.parseInt(stocklist.get(0).get("stoc_count").toString());
				int ship_count = Integer.parseInt(stocklist.get(0).get("ship_count").toString());
				//
				ship_count = ship_count-num;
				stoc_count = stoc_count+num;
				stocklist.get(0).put("ship_count", ship_count);
				stocklist.get(0).put("stoc_count", stoc_count);
				flog = inventoryDetailTabDao.updateStockTab(stocklist.get(0));
			}
		}

		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 退换货入库
	 * @return
	 */
	public String ChangingPurchaseAccess(HashMap<String,Object> map) {	
		HashMap<String,Object> chanMap = comeWarehouseTabDao.queryChangeTab(map);
		ArrayList<HashMap<String,Object>> saleList  = inventoryDetailTabDao.querySalesRecordTab(map);
		//1.判断是否换货,换货生成新的配送单
		if(null!=chanMap&&chanMap.get("chan_sign").equals("换货")) {
			chanMap.put("chan_status","待发货");
			//2.修改退换货单状态
			comeWarehouseTabDao.updateChangeTab(chanMap);//更新退换货单状态
			//3.修改商品销售记录
			for(int i=0;i<saleList.size();i++) {
				saleList.get(i).put("chan_id",chanMap.get("chan_id"));
				comeWarehouseTabDao.updateSalesRecordTab(saleList.get(i));
				//4.修改库存明细信息
				if(chanMap.get("cargo_status").equals("不影响二次销售")) {//是否影响二次销售
					saleList.get(i).put("inve_status","在库");
					saleList.get(i).put("inve_cause", "入库");
				}else {
					saleList.get(i).put("inve_status","报废");
					saleList.get(i).put("inve_cause", "报废");
				}
				saleList.get(i).put("staf_id", map.get("staff_id"));
				saleList.get(i).put("ware_id", map.get("warehouse_id"));
				comeWarehouseTabDao.updateInventoryDetailTab(saleList.get(i));
				//5.添加库存变更记录
				saleList.get(i).put("inve_alter_cause", "换货入库");
				comeWarehouseTabDao.addInventoryAlterTabChange(saleList.get(i));
			}
			//6.修改库存量信息
			ArrayList<Integer> commIdList = JSON.parseObject(JSON.toJSONString(chanMap.get("comm_id")), ArrayList.class);
			ArrayList<Integer> numList = JSON.parseObject(JSON.toJSONString(chanMap.get("chan_num")), ArrayList.class);
			HashMap<String,Object> HashMap = new HashMap<String, Object>();
			HashMap.put("warehouse_id",map.get("warehouse_id"));
			for(int i=0;i<commIdList.size();i++) {
				HashMap.put("comm_id", commIdList.get(i));
				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(HashMap);//查询库存量
				if(stockMap==null) {
					HashMap.put("bourn_ware_id", map.get("warehouse_id"));
					comeWarehouseTabDao.addStockTab(HashMap);
					stockMap = comeWarehouseTabDao.querystockMap(HashMap);//查询库存量
				}
				if(chanMap.get("cargo_status").equals("不影响二次销售")) {//是否影响二次销售
					int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
					int nums = numList.get(i);
					stoc_count = stoc_count +nums;
					stockMap.put("stoc_count", stoc_count);
					comeWarehouseTabDao.updatestockMap(stockMap);
				}else {
					int scrap_count =  Integer.parseInt(stockMap.get("scrap_count").toString());
					int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
					scrap_count =scrap_count +numList.get(i);
					stockMap.put("scrap_count", scrap_count);
					stockMap.put("stoc_count", stoc_count);
					comeWarehouseTabDao.updatestockMap(stockMap);
				}		
			}
			//查询是否有配送单信息
			HashMap<String,Object> DeliverMap= inventoryDetailTabDao.queryDeliverTab(chanMap);
			if(null!=DeliverMap) {//有配送单生成新的配送单信息
				DeliverTab deliverTab = new DeliverTab();
				deliverTab.setOrde_id(Integer.parseInt(DeliverMap.get("orde_id").toString()));
				deliverTab.setJdde_id(Integer.parseInt(DeliverMap.get("jdde_id").toString()));
				deliverTab.setDeli_addr(DeliverMap.get("deli_addr").toString());
				deliverTab.setDeli_phone(DeliverMap.get("deli_phone").toString());
				deliverTab.setDeli_name(DeliverMap.get("deli_name").toString());
				//deliverTab.setStaf_id(Integer.parseInt(DeliverMap.get("staf_id").toString()));
				deliverTab.setDeli_status("创建");
				deliverTab.setChan_id(Integer.parseInt(chanMap.get("chan_id").toString()));
				
				deliverTabDao.addDeliverTab(deliverTab);
			}
			return JSON.toJSONString("success");
			
		}else {
			chanMap.put("chan_status","待退款");
			//2.修改退换货单状态
			comeWarehouseTabDao.updateChangeTab(chanMap);//更新退换货单状态
			//3.修改商品销售记录
			for(int i=0;i<saleList.size();i++) {
				saleList.get(i).put("chan_id",chanMap.get("chan_id"));
				comeWarehouseTabDao.updateSalesRecordTab(saleList.get(i));
				//4.修改库存明细信息
				if(chanMap.get("cargo_status").equals("不影响二次销售")) {//是否影响二次销售
					saleList.get(i).put("inve_status","在库");
					saleList.get(i).put("inve_cause", "入库");
				}else {
					saleList.get(i).put("inve_status","报废");
					saleList.get(i).put("inve_cause", "报废");
				}
				saleList.get(i).put("staf_id", map.get("staff_id"));
				saleList.get(i).put("ware_id", map.get("warehouse_id"));
				comeWarehouseTabDao.updateInventoryDetailTab(saleList.get(i));
				//5.添加库存变更记录
				saleList.get(i).put("inve_alter_cause", "退货入库");
				comeWarehouseTabDao.addInventoryAlterTabChange(saleList.get(i));
			}
			//6.修改库存量信息
			ArrayList<Integer> commIdList = JSON.parseObject(JSON.toJSONString(chanMap.get("comm_id")), ArrayList.class);
			ArrayList<Integer> numList = JSON.parseObject(JSON.toJSONString(chanMap.get("chan_num")), ArrayList.class);
			HashMap<String,Object> HashMap = new HashMap<String, Object>();
			HashMap.put("warehouse_id",map.get("warehouse_id"));
			for(int i=0;i<commIdList.size();i++) {
				HashMap.put("comm_id", commIdList.get(i));
				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(HashMap);//查询库存量
				if(stockMap==null) {
					HashMap.put("bourn_ware_id", map.get("warehouse_id"));
					comeWarehouseTabDao.addStockTab(HashMap);
					stockMap = comeWarehouseTabDao.querystockMap(HashMap);//查询库存量
				}
				if(chanMap.get("cargo_status").equals("不影响二次销售")) {//是否影响二次销售
					int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
					int nums = numList.get(i);
					stoc_count = stoc_count +nums;
					stockMap.put("stoc_count", stoc_count);
					comeWarehouseTabDao.updatestockMap(stockMap);
				}else {
					int scrap_count =  Integer.parseInt(stockMap.get("scrap_count").toString());
					int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
					scrap_count =scrap_count +numList.get(i);
					stockMap.put("scrap_count", scrap_count);
					stockMap.put("stoc_count", stoc_count);
					comeWarehouseTabDao.updatestockMap(stockMap);
				}		
			}
			return JSON.toJSONString("success");
			
		}
	}

}
