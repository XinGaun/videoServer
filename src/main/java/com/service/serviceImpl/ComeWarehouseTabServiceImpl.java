package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.ComeWarehouseTabDao;
import com.dao.StaffTabDao;
import com.entity.ComeWarehouseTab;
import com.service.ComeWarehouseTabService;
import com.util.Count;
import com.util.DateUtil;
import com.util.Page;
/**
 * 出库单Service层接口实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class ComeWarehouseTabServiceImpl implements ComeWarehouseTabService {
	@Autowired
	private ComeWarehouseTabDao comeWarehouseTabDao;//调用出库单Dao层接口
	@Autowired
	private StaffTabDao staffTabDao;//调用员工Dao层接口

	private Logger logger = Logger.getLogger(ComeWarehouseTabServiceImpl.class);
	/**
	 * 添加出库单
	 */
	@Override
	public String addComeWarehouseTab(String data) {
		logger.info("/addComeWarehouseTab data: "+data);
		ComeWarehouseTab comeWarehouseTab = JSON.parseObject(data, ComeWarehouseTab.class);
		int flog = comeWarehouseTabDao.addComeWarehouseTab(comeWarehouseTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 查询出库单信息
	 */
	@Override
	public String queryComeWarehouseTab(String data) {
		logger.info("/queryComeWarehouseTab data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap = Page.page(hashMap);
		int flog=-1;
		if(hashMap.containsKey("deli_id")) {		
			ArrayList<HashMap<String,Object>> orderList = comeWarehouseTabDao.queryOrderTab(hashMap);
			if(orderList!=null&&orderList.size()>0&&orderList.get(0).containsKey("come_ware_id")) {
				hashMap.put("come_ware_id", orderList.get(0).get("come_ware_id"));
				flog=1;
			}
		}
		ArrayList<HashMap<String,Object>> list = comeWarehouseTabDao.queryComeWarehouseTab(hashMap);
		/*if(flog==-1) {
			list = new ArrayList<HashMap<String,Object>>();
		}*/
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> staff = staffTabDao.queryStaffTab(list.get(i));
			list.get(i).put("staff", staff);
		}
		int count =comeWarehouseTabDao.queryComeWarehouseTabCount(hashMap);
		//list = Count.count(list, count, hashMap);
		return JSON.toJSONString(Count.counts(list, count, hashMap,200,"queryComeWarehouseTab success"));
	}
	/**
	 * 更新出库单信息
	 */
	@Override
	public String updateComeWarehouseTab(String data) {
		logger.info("/updateComeWarehouseTab data: "+data);
		ComeWarehouseTab comeWarehouseTab = JSON.parseObject(data, ComeWarehouseTab.class);
		int flog = comeWarehouseTabDao.updateComeWarehouseTab(comeWarehouseTab);
		if(flog>0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString("error");
	}
	/**
	 * 删除出库单
	 */
	@Transactional
	public String deleteComeWarehouseTab(String data) {
		logger.info("/deleteComeWarehouseTab data: "+data);
		ArrayList<Integer> list = JSON.parseObject(data, ArrayList.class);
		ArrayList<Integer> retlist = new ArrayList<Integer>();
		for(int i=0;i<list.size();i++) {
			int come_ware_id = list.get(i);
			int flog = comeWarehouseTabDao.deleteComeWarehouseTab(come_ware_id);
			if(flog<=0) {
				retlist.add(come_ware_id);
			}
		}
		if(retlist.size()==0) {
			return JSON.toJSONString("success");
		}
		return JSON.toJSONString(retlist);
	}
	/**
	 * 出库
	 */
	@Transactional
	public String departLibrary(String data) {
		logger.info("/departLibrary data: "+data);
		HashMap<String,Object> hashMap = JSON.parseObject(data,HashMap.class);
		hashMap.put("come_ware_id", -1);
		hashMap.put("come_ware_date", DateUtil.getNowDate());
		hashMap.put("inve_alter_date", DateUtil.getNowDate());
		int addComeWarehouse = comeWarehouseTabDao.addComeWarehouseTabMap(hashMap);//添加出库单
		if(hashMap.containsKey("deli_id")) {//是否为配送出库
			return DistributionOfWarehouse(hashMap);
		}

		if(hashMap.containsKey("shop_id")) {//判断是否出样出库
			ArrayList<String> RecordList = JSON.parseObject(JSON.toJSONString(hashMap.get("comm_id")), ArrayList.class);
			HashMap<String,Object> reMap = new HashMap<String,Object>();
			for(int i=0;i<RecordList.size();i++) {
				HashMap<String,Object> commMap = JSON.parseObject(JSON.toJSONString(RecordList.get(i)), HashMap.class);
				reMap.put("comm_id", commMap.get("comm_id"));
				reMap.put("warehouse_id", hashMap.get("warehouse_id"));
				reMap.put("num", commMap.get("nums"));
				ArrayList<HashMap<String,Object>> reList = comeWarehouseTabDao.queryInventoryAlter(reMap);
				hashMap.put("comm_id", reMap.get("comm_id"));

				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(hashMap);//查询库存量
				int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
				int sample_count = Integer.parseInt(stockMap.get("sample_count").toString());
				int nums = Integer.parseInt(commMap.get("nums")+"");
				stoc_count = stoc_count -nums;
				sample_count = sample_count+nums;
				stockMap.put("stoc_count", stoc_count);
				stockMap.put("sample_count", sample_count);
				comeWarehouseTabDao.updatestockMap(stockMap);
				//查询库存量
				for(int s=0;s<reList.size();s++) {//添加库存变更记录
					hashMap.put("cargo_id",reList.get(s).get("cargo_id"));
					hashMap.put("inve_alter_code", reList.get(s).get("inve_code"));
					comeWarehouseTabDao.addinventoryAlterTab(hashMap); //对每个货物ID生成一个出库记录，记录对应出库单ID和其他相关单据ID
					comeWarehouseTabDao.updateDnventorydetailTab(hashMap);//修改库存明细出库标记
				}

				return JSON.toJSONString("success");
			}
		}

		/*if(hashMap.containsKey("chan_id")) {//判断是否为退换货出库
			HashMap<String,Object> chanMap = comeWarehouseTabDao.queryChangeTab(hashMap);
			if(chanMap.containsKey("deli_id")) {//更新配送单信息
				comeWarehouseTabDao.updateDeliver(chanMap);
				chanMap.put("chen_status","换货配送中");
				comeWarehouseTabDao.updateChangeTab(chanMap);
			}
			//查询需要出库的商品ID和数量
			ArrayList<HashMap<String,Object>> RecordList = comeWarehouseTabDao.queryRecord(chanMap);
			HashMap<String,Object> reMap = new HashMap<String,Object>();
			for(int i=0;i<RecordList.size();i++) {
				reMap.put("comm_id", RecordList.get(i).get("comm_id"));
				reMap.put("warehouse_id", hashMap.get("warehouse_id"));
				reMap.put("num", chanMap.get("chan_num"));
				ArrayList<HashMap<String,Object>> reList = comeWarehouseTabDao.queryInventoryAlter(reMap);
				hashMap.put("comm_id", reMap.get("comm_id"));

				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(hashMap);//查询库存量
				int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
				int ship_count = Integer.parseInt(stockMap.get("ship_count").toString());
				int nums = Integer.parseInt(chanMap.get("chan_num")+"");
				stoc_count = stoc_count -nums;
				ship_count = ship_count+nums;
				stockMap.put("stoc_count", stoc_count);
				stockMap.put("ship_count", ship_count);
				comeWarehouseTabDao.updatestockMap(stockMap);
				//查询库存量
				for(int s=0;s<reList.size();s++) {//添加库存变更记录
					hashMap.put("cargo_id",reList.get(s).get("cargo_id"));
					hashMap.put("inve_alter_code", reList.get(s).get("inve_code"));
					comeWarehouseTabDao.addinventoryAlterTab(hashMap); //对每个货物ID生成一个出库记录，记录对应出库单ID和其他相关单据ID
					comeWarehouseTabDao.updateDnventorydetailTab(hashMap);//修改库存明细出库标记
				}

				return JSON.toJSONString("success");
			}
		}*/
		if(hashMap.containsKey("orde_id")) {//判断是否为订单出库
			HashMap<String,Object> orderMap = comeWarehouseTabDao.queryOrderID(hashMap);
			if(orderMap.containsKey("deli_id")) {//更新配送单信息
				if(hashMap.containsKey("orde_index")) {
					orderMap.put("status", "创建");
				}else {
					orderMap.put("status", "配送中");
				}
				comeWarehouseTabDao.updateDeliver(orderMap);
				//更新订单状态	
				
					hashMap.put("status", "配送中");


			}else {
				//更新订单状态	
				hashMap.put("status", "已收货");
			}
			comeWarehouseTabDao.updateOrder(hashMap);
			//查询需要出库的商品ID和数量
			ArrayList<HashMap<String,Object>> RecordList = comeWarehouseTabDao.queryRecord(orderMap);
			HashMap<String,Object> reMap = new HashMap<String,Object>();
			reMap.put("inve_alter_type",hashMap.get("inve_alter_type"));
			reMap.put("staff_id",hashMap.get("staff_id"));//获取员工ID
			reMap.put("inve_alter_date",hashMap.get("inve_alter_date"));//出库日期
			reMap.put("come_ware_id", hashMap.get("come_ware_id"));//添加出库单号

			for(int i=0;i<RecordList.size();i++) {
				reMap.put("comm_id", RecordList.get(i).get("comm_id"));
				reMap.put("warehouse_id", hashMap.get("warehouse_id"));
				reMap.put("sale_id", RecordList.get(i).get("sale_id"));
				//reMap.put("num", RecordList.get(i).get("sale_num"));
				//查询符合订单的货物ID
				HashMap<String,Object> cargoIDMap = comeWarehouseTabDao.queryInventoryDetailTabCargoId(reMap);
				try {
					reMap.put("cargo_id", cargoIDMap.get("cargo_id"));
				} catch (Exception e) {
					// TODO: handle exception
					e.getMessage();
					return "The goods less than";
				}

				//添加货物ID到商品销售记录ID
				comeWarehouseTabDao.updateSalesRecordTab(reMap);
				//将库存明细根据货物ID状态改为出库
				comeWarehouseTabDao.updateDnventorydetailTab(reMap);
				//添加库存变更信息
				hashMap.put("cargo_id",cargoIDMap.get("cargo_id"));
				hashMap.put("inve_alter_code",cargoIDMap.get("inve_code"));
				hashMap.put("comm_id", reMap.get("comm_id"));
				comeWarehouseTabDao.addinventoryAlterTab(hashMap); //对每个货物ID生成一个出库记录，记录对应出库单ID和其他相关单据ID
				//查询库存存量

				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(hashMap);//查询库存量
				int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
				//int ship_count = Integer.parseInt(stockMap.get("ship_count").toString());
				int nums = 1;
				stoc_count = stoc_count -nums;
				//ship_count = ship_count+nums;
				stockMap.put("stoc_count", stoc_count);
				//stockMap.put("ship_count", ship_count);
				comeWarehouseTabDao.updatestockMap(stockMap);	
			}

			return JSON.toJSONString("success");
		}
		if(hashMap.containsKey("bourn_ware_id")) {//调拨出库
			int num = Integer.parseInt(hashMap.get("num").toString());
			ArrayList<Integer> commIdList = JSON.parseObject(JSON.toJSONString(hashMap.get("comm_id")),ArrayList.class);
			HashMap<String,Object> paMap = new HashMap<String,Object>();
			paMap.put("num", num);
			for(int i=0;i<commIdList.size();i++) {
				HashMap<String,Object> commList = JSON.parseObject(JSON.toJSONString(commIdList.get(i)), HashMap.class);
				//查询出库需要的货物ID
				paMap.put("comm_id", commList.get("comm_id"));
				paMap.put("warehouse_id", hashMap.get("warehouse_id"));
				ArrayList<HashMap<String,Object>> reList = comeWarehouseTabDao.queryInventoryAlter(paMap);
				hashMap.put("comm_id", commList.get("comm_id"));
				for(int s=0;s<reList.size();s++) {//添加库存变更记录
					hashMap.put("cargo_id",reList.get(s).get("cargo_id"));
					int ss = comeWarehouseTabDao.addinventoryAlterTab(hashMap); //对每个货物ID生成一个出库记录，记录对应出库单ID和其他相关单据ID
					ss= comeWarehouseTabDao.updateDnventorydetailTab(hashMap);//修改库存明细出库标记
					comeWarehouseTabDao.addmdinventoryDetailtab(hashMap);//5.目的仓库增加货物在途记录
				}

			}
			HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(hashMap);//查询库存量
			int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
			int ship_count = Integer.parseInt(stockMap.get("ship_count").toString());

			stoc_count = stoc_count -num;
			ship_count = ship_count+num;
			stockMap.put("stoc_count", stoc_count);
			stockMap.put("ship_count", ship_count);
			int updatestock = comeWarehouseTabDao.updatestockMap(stockMap);
			int flog = -1;				
			HashMap<String,Object> stockMdMap = comeWarehouseTabDao.queryMdstockMap(hashMap);//6.目的仓库增加在途量	
			if(stockMdMap==null) {
				comeWarehouseTabDao.addStockTab(hashMap);
				stockMdMap = comeWarehouseTabDao.queryMdstockMap(hashMap);
			}
			ship_count =  Integer.parseInt(stockMdMap.get("ship_count").toString());
			ship_count=ship_count+num;
			stockMdMap.put("ship_count", ship_count);
			flog = comeWarehouseTabDao.updateMdstockMap(stockMdMap);

			//if(hashMap.containsKey("")){}
			if(addComeWarehouse>0&&updatestock>0&&flog>0) {
				return JSON.toJSONString("success");
			}
			return JSON.toJSONString("error");
		}
		return JSON.toJSONString("error");



		//int addinventory = comeWarehouseTabDao.addinventoryDetailtab(hashMap);//3.将源仓库对应货物的明细记录打上出库标记

	}
	/**
	 * 换货配送出库
	 * @param hashMap
	 * @return
	 */
	@Transactional
	public String DistributionOfWarehouse(HashMap<String,Object> hashMap) {
		logger.info("/DistributionOfWarehouse data: "+JSON.toJSONString(hashMap));
		//1.查询配送单信息和退换货ID
		HashMap<String,Object> DeliMap = comeWarehouseTabDao.queryDeliverTab(hashMap);	
		hashMap.put("chan_id", DeliMap.get("chan_id"));
		if(DeliMap.get("chan_id")!=null&&DeliMap.containsKey("chan_id")) {
			//2.更新退换货单状态
			DeliMap.put("chan_status","完成");
			comeWarehouseTabDao.updateChangeTabStatus(DeliMap);
			//3.查询需要出库的商品销售记录
			ArrayList<HashMap<String,Object>> saleList = comeWarehouseTabDao.queryChanIdSaleRecordTab(DeliMap);
			for(int i=0;i<saleList.size();i++) {
				hashMap.put("comm_id", saleList.get(i).get("comm_id"));
				HashMap<String,Object> cargoIDMap = comeWarehouseTabDao.queryInventoryDetailTabCargoId(hashMap);
				saleList.get(i).put("cargo_id", cargoIDMap.get("cargo_id"));
				//4.添加新的商品销售记录
				comeWarehouseTabDao.addSaleRecordTab(saleList.get(i));
				//5.将库存明细根据货物ID状态改为出库
				hashMap.put("cargo_id", saleList.get(i).get("cargo_id"));
				comeWarehouseTabDao.updateDnventorydetailTab(hashMap);
				//6.对每个货物ID生成一个出库记录，记录对应出库单ID和其他相关单据ID
				hashMap.put("orde_id", saleList.get(i).get("orde_id"));
				comeWarehouseTabDao.addinventoryAlterTab(hashMap); 
				//7.查询库存存量并修改
				HashMap<String,Object> stockMap = comeWarehouseTabDao.querystockMap(hashMap);//查询库存量
				int stoc_count = Integer.parseInt(stockMap.get("stoc_count").toString());
				int nums = 1;
				stoc_count = stoc_count -nums;
				stockMap.put("stoc_count", stoc_count);
				comeWarehouseTabDao.updatestockMap(stockMap);
			}
			//8.更新配送单信息
			DeliMap.put("status", "配送中");
			int flog = comeWarehouseTabDao.updateDeliver(DeliMap);
			if(flog>0) {
				return JSON.toJSONString("success");
			}	
		}
		return JSON.toJSONString("error");
	}

}
