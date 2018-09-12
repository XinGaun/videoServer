package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.ExampleTabDao;
import com.dao.StatementDao;
import com.entity.ExampleTab;
import com.entity.PullStatement;
import com.service.StatementService;
import com.util.Count;
import com.util.HttpReq;

/**
 * 报表信息service层实现类
 * @author vip
 *
 */
@SuppressWarnings("unchecked")
@Service
public class StatementServiceImpl implements StatementService {
	@Autowired
	private StatementDao statementDao;
	@Autowired
	private ExampleTabDao exampleTabDao;//调用分实例接口
	private Logger logger = Logger.getLogger(StatementServiceImpl.class);
	@Override
	public String queryStatement(String data) {
		logger.info("/queryStatement :"+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		String start_date = null;
		String ending_date=null;
		if(map.containsKey("start_date")) {
			start_date = map.get("start_date").toString();
		}
		if(map.containsKey("ending_date")) {
			ending_date = map.get("ending_date").toString();
		}

		//查询品类信息
		ArrayList<HashMap<String,Object>> list = statementDao.queryCategoryList(map);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> commModelList =  statementDao.queryCommodityModel(list.get(i));			
			for(int j=0;j<commModelList.size();j++) {
				commModelList.get(j).put("start_date",start_date);
				commModelList.get(j).put("ending_date",ending_date);
				ArrayList<HashMap<String,Object>> hashmapson = statementDao.queryCommoditySales(commModelList.get(j));
				commModelList.get(j).put("sumList", hashmapson);
			}
			list.get(i).put("commModelList", commModelList);
			ArrayList<HashMap<String,Object>> arrayList = statementDao.queryCategoryList(list.get(i));//二级
			for(int s=0;s<arrayList.size();s++) {//二级品类
				ArrayList<HashMap<String,Object>> arrayList2 = statementDao.queryCategoryList(arrayList.get(s));//三级
				for(int w=0;w<arrayList2.size();w++) {//三级
					ArrayList<HashMap<String,Object>> commModelList2 =  statementDao.queryCommodityModel(arrayList2.get(w));
					for(int q=0;q<commModelList2.size();q++) {
						commModelList2.get(q).put("start_date",start_date);
						commModelList2.get(q).put("ending_date",ending_date);
						ArrayList<HashMap<String,Object>> hashmapson = statementDao.queryCommoditySales(commModelList2.get(q));
						commModelList2.get(q).put("sumList", hashmapson);
					}
					arrayList2.get(w).put("commModelList", commModelList2);
				}
				arrayList.get(s).put("list", arrayList2);
				ArrayList<HashMap<String,Object>> commModelList2 =  statementDao.queryCommodityModel(arrayList.get(s));
				for(int q=0;q<commModelList2.size();q++) {
					commModelList2.get(q).put("start_date",start_date);
					commModelList2.get(q).put("ending_date",ending_date);
					ArrayList<HashMap<String,Object>> hashmapson = statementDao.queryCommoditySales(commModelList2.get(q));
					commModelList2.get(q).put("sumList", hashmapson);
				}
				arrayList.get(s).put("commModelList", commModelList2);
			}
			list.get(i).put("list", arrayList);
		}
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryStatement success"));
	}
	/**
	 * 查询库存量信息
	 */
	@Override
	public String queryStockList() {
		logger.info("/queryStockList");
		HashMap<String,Object> map = new HashMap<String,Object>();
		ArrayList<HashMap<String,Object>> list = statementDao.queryCategoryList(map);
		for(int i=0;i<list.size();i++) {
			ArrayList<HashMap<String,Object>> commModelList =  statementDao.queryCommodityModel(list.get(i));
			for(int j=0;j<commModelList.size();j++) {
				HashMap<String,Object> stockMap = statementDao.queryStockList(commModelList.get(j));
				commModelList.get(j).put("stock", stockMap);
			}
			list.get(i).put("commModelList", commModelList);
			ArrayList<HashMap<String,Object>> arrayList = statementDao.queryCategoryList(list.get(i));//二级
			for(int s=0;s<arrayList.size();s++) {//二级品类
				ArrayList<HashMap<String,Object>> commModelList2 =  statementDao.queryCommodityModel(arrayList.get(s));
				for(int q=0;q<commModelList2.size();q++) {
					HashMap<String,Object> stockMap = statementDao.queryStockList(commModelList2.get(q));
					commModelList2.get(q).put("stock", stockMap);
				}
				arrayList.get(s).put("commModelList", commModelList2);
				ArrayList<HashMap<String,Object>> arrayList2 = statementDao.queryCategoryList(arrayList.get(s));//三级
				for(int w=0;w<arrayList2.size();w++) {//三级
					ArrayList<HashMap<String,Object>> commModelList3 =  statementDao.queryCommodityModel(arrayList2.get(w));
					for(int q=0;q<commModelList3.size();q++) {
						//System.out.println(i+":"+q);
						HashMap<String,Object> stockMap = statementDao.queryStockList(commModelList3.get(q));
						commModelList3.get(q).put("stock", stockMap);
					}
					arrayList2.get(w).put("commModelList", commModelList3);
				}
				arrayList.get(s).put("list", arrayList2);
			}
			list.get(i).put("list", arrayList);
		}
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryStockList success"));
	}
	/**
	 * queryPullStatementList
	 */
	@Override
	public String queryPullStatementListCate(String data) {
		logger.info("/queryPullStatementList :"+data);
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(new HashMap<String, Object>());//查询分实例信息
		logger.info("exampleList :"+ JSON.toJSONString(exampleList));
		String result = null;
		ArrayList<ArrayList<String>> arrStr = new ArrayList<ArrayList<String>>();
		try {
			for(int i=0;i<exampleList.size();i++) {

				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/Statement/queryPullCateModelList", "POST",data);
				//HashMap<String,Object> resuMap = JSON.parseObject(result, HashMap.class);
				//logger.info("result httpPush :"+ JSON.toJSONString(resuMap.get("list")));
				ArrayList<String> strList= JSON.parseObject(result, ArrayList.class);
				arrStr.add(strList);


			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int i=0;i<arrStr.size();i++) {
			arrayList.addAll(arrStr.get(i));
		}
		Set<String> setCate1 = new HashSet<String>();
		Set<HashMap<String,Object>> setCate2 = new HashSet<HashMap<String,Object>>();
		Set<HashMap<String,Object>> set = new HashSet<HashMap<String,Object>>();
		Set<HashMap<String,Object>> set2 = new HashSet<HashMap<String,Object>>();
		for(int i=0;i<arrayList.size();i++) {
			HashMap<String,Object> map = JSON.parseObject(JSON.toJSONString(arrayList.get(i)), HashMap.class);
			HashMap<String,Object> cate1Model = new HashMap<String, Object>();
			cate1Model.put("cate_name1", map.get("cate_name1"));
			cate1Model.put("comm_model1", map.get("comm_model1"));
			setCate1.add(map.get("cate_name1").toString());
			set.add(cate1Model);

			HashMap<String,Object> cate1Name2 = new HashMap<String, Object>();
			cate1Name2.put("cate_name1", map.get("cate_name1"));
			cate1Name2.put("cate_name2", map.get("cate_name2"));
			setCate2.add(cate1Name2);

			HashMap<String,Object> cate1Mode2 = new HashMap<String, Object>();
			cate1Mode2.put("cate_name2", map.get("cate_name2"));
			cate1Mode2.put("comm_model2", map.get("comm_model2"));
			set2.add(cate1Mode2);
		}
		ArrayList<HashMap<String,Object>> allList = new ArrayList<HashMap<String,Object>>();
		for(String string : setCate1) {
			HashMap<String,Object> HashMaps = new HashMap<String, Object>();
			ArrayList<String> listS = new ArrayList<String>();
			HashMaps.put("cate_name", string);
			ArrayList<HashMap<String,Object>> listson = new ArrayList<HashMap<String,Object>>();
			for(HashMap<String,Object> maps : set) {
				if(HashMaps.get("cate_name").equals(maps.get("cate_name1"))) {
					if(null!=maps.get("comm_model1")&&maps.get("comm_model1")!="") {
						listS.add(maps.get("comm_model1").toString());
					}
				}

				for(HashMap<String,Object> maps2 :setCate2) {
					if(null!=maps2.get("cate_name2")&&HashMaps.get("cate_name").equals(maps2.get("cate_name1"))) {
						Set<String> setlist = new HashSet<String>();
						for(HashMap<String,Object> maps3:set2) {
							if(null!=maps3.get("comm_model2")&&null!=maps2.get("cate_name2")&&maps2.get("cate_name2").equals(maps3.get("cate_name2"))) {
								setlist.add(maps3.get("comm_model2").toString());
							}
						}
						maps2.put("ModelList", setlist);
						maps2.put("cate_name1",null);
						listson.add(maps2);
					}
				}

			}
			if(listson.size()>0){
				HashMaps.put("lsit", listson);
			}
			HashMaps.put("comm_model", listS);
			allList.add(HashMaps);
		}







		return JSON.toJSONString(allList);
	}
	/**
	 * 总实例查询分实力品类商品型号信息
	 */
	@Override
	public String queryPullCateModelList() {
		logger.info("/queryPullCateModelList");
		//查询品类信息
		ArrayList<HashMap<String,Object>> list = statementDao.queryPullStatementsCate(new HashMap<String,Object>());
		return JSON.toJSONString(list);
	}
	/**
	 * 总实例查询分实例销量信息
	 */
	public String queryPullCateModeSalelList(String data) {
		logger.info("/queryPullCateModeSalelList :"+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<String> listMap = JSON.parseObject(JSON.toJSONString(map.get("list")),ArrayList.class);
		HashMap<String,Object> maps = new HashMap<String, Object>();
		maps.put("start_date",map.get("start_date"));
		maps.put("ending_date",map.get("ending_date"));
		ArrayList<HashMap<String,Object>> ListMap = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<listMap.size();i++) {
			HashMap<String,Object> IndexMap = JSON.parseObject(JSON.toJSONString(listMap.get(i)), HashMap.class);
			maps.put("comm_model",IndexMap.get("comm_model"));
			ArrayList<HashMap<String,Object>> arrayList = statementDao.queryPullCateModeSalelList(maps);
			for(int s=0;s<arrayList.size();s++) {
				if(arrayList.get(s).get("sell_type").equals("线上")) {	
					IndexMap.put("online", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}else if(arrayList.get(s).get("sell_type").equals("门店")) {
					IndexMap.put("shop", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}else if(arrayList.get(s).get("sell_type").equals("员工销售")) {
					IndexMap.put("salesstaff", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}else if(arrayList.get(s).get("sell_type").equals("现场服务")) {
					IndexMap.put("fieldservice", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}else if(arrayList.get(s).get("sell_type").equals("团购")) {
					IndexMap.put("groupbuying", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}else if(arrayList.get(s).get("sell_type").equals("工程")) {
					IndexMap.put("project", arrayList.get(s).get("count"));
					IndexMap.put("sum",arrayList.get(s).get("sum"));
					continue;
				}
			}
			ListMap.add(IndexMap);
		}
		return JSON.toJSONString(ListMap);
	}
	/**
	 * 总实例调用分实例获取销量信息
	 */
	@Override
	public String queryFenShiLiSaleList(String data) {
		logger.info("/queryFenShiLiSaleList :"+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(map);//查询分实例信息
		logger.info("exampleList :"+ JSON.toJSONString(exampleList));
		String result = null;
		ArrayList<ArrayList<String>> arrStr = new ArrayList<ArrayList<String>>();
		try {
			for(int i=0;i<exampleList.size();i++) {

				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/Statement/queryPullCateModeSalelList", "POST",data);
				//HashMap<String,Object> resuMap = JSON.parseObject(result, HashMap.class);
				//logger.info("result httpPush :"+ JSON.toJSONString(resuMap.get("list")));
				ArrayList<String> strList= JSON.parseObject(result, ArrayList.class);
				arrStr.add(strList);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		ArrayList<String> arrayList = new ArrayList<String>();
		for(int i =0;i<arrStr.size();i++) {		
			ArrayList<String> tempMap = JSON.parseObject(JSON.toJSONString(arrStr.get(i)), ArrayList.class);
			arrayList.addAll(tempMap);
		}
		ArrayList<HashMap<String,Object>> list =new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<arrayList.size();i++) {
			HashMap<String,Object> hashMap = JSON.parseObject(JSON.toJSONString(arrayList.get(i)), HashMap.class);
			if(i==0) {
				list.add(hashMap);
				continue;
			}
			int index =-1;
			for(int s =0;s<list.size();s++) {	
				if(list.get(s).get("comm_model").equals(hashMap.get("comm_model"))) {
					index=1;
					int online = Integer.parseInt(list.get(s).get("online").toString())+Integer.parseInt(hashMap.get("online").toString());
					int shop = Integer.parseInt(list.get(s).get("shop").toString())+Integer.parseInt(hashMap.get("shop").toString());
					int salesstaff = Integer.parseInt(list.get(s).get("salesstaff").toString())+Integer.parseInt(hashMap.get("salesstaff").toString());
					int fieldservice = Integer.parseInt(list.get(s).get("fieldservice").toString())+Integer.parseInt(hashMap.get("fieldservice").toString());
					int groupbuying = Integer.parseInt(list.get(s).get("groupbuying").toString())+Integer.parseInt(hashMap.get("groupbuying").toString());
					int project = Integer.parseInt(list.get(s).get("project").toString())+Integer.parseInt(hashMap.get("project").toString());
					int sum = Integer.parseInt(list.get(s).get("sum").toString())+Integer.parseInt(hashMap.get("sum").toString());
					list.get(s).put("online", online);
					list.get(s).put("shop", shop);
					list.get(s).put("salesstaff", salesstaff);
					list.get(s).put("fieldservice", fieldservice);
					list.get(s).put("groupbuying", groupbuying);
					list.get(s).put("project", project);
					list.get(s).put("sum", sum);
				}
			}
			if(index==-1) {
				list.add(hashMap);
			}
		}
		return JSON.toJSONString(list);
	}
	/**
	 * 总实例查询子实例库存信息
	 */
	@Override
	public String queryPullStockList(String data) {
		logger.info("/queryPullStockList :"+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<String> List = JSON.parseObject(JSON.toJSONString(map.get("list")),ArrayList.class);
		ArrayList<HashMap<String,Object>> queryList = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<List.size();i++) {
			HashMap<String,Object> hashMap = JSON.parseObject(JSON.toJSONString(List.get(i)),HashMap.class);
			HashMap<String,Object> arrayList = statementDao.queryPullStockList(hashMap);
			//System.out.println(JSON.toJSONString(hashMap));
			if(null!=arrayList&&arrayList.size()>0) {
				arrayList.put("comm_model", hashMap.get("comm_model"));
				queryList.add(arrayList);
			}else {
				arrayList = new HashMap<String, Object>();
				arrayList.put("comm_model", hashMap.get("comm_model"));
				queryList.add(hashMap);
			}
		}
		return JSON.toJSONString(queryList);
	}
	/**
	 * 总实例查询自实例自实例查询库存量接口
	 */
	@Override
	public String queryStockLists(String data) {
		logger.info("/queryStockList :"+data);
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<ExampleTab> exampleList = exampleTabDao.queryExampleTab(map);//查询分实例信息
		logger.info("exampleList :"+ JSON.toJSONString(exampleList));
		String result = null;
		ArrayList<ArrayList<String>> arrStr = new ArrayList<ArrayList<String>>();
		try {
			for(int i=0;i<exampleList.size();i++) {

				result = HttpReq.httpRequest(exampleList.get(i).getExample_IP()+"/hangrano2o/Statement/queryPullStockList", "POST",data);
				//HashMap<String,Object> resuMap = JSON.parseObject(result, HashMap.class);
				//logger.info("result httpPush :"+ JSON.toJSONString(resuMap.get("list")));
				ArrayList<String> strList= JSON.parseObject(result, ArrayList.class);
				arrStr.add(strList);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		ArrayList<HashMap<String,Object>> hashMap = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<arrStr.size();i++) {
			ArrayList<String> arrayList = JSON.parseObject(JSON.toJSONString(arrStr.get(i)), ArrayList.class);
			for(int s=0;s<arrayList.size();s++) {
				HashMap<String,Object> tempMap = JSON.parseObject(JSON.toJSONString(arrayList.get(s)), HashMap.class);
				hashMap.add(tempMap);
			}
		}
		ArrayList<HashMap<String,Object>> lists =new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<hashMap.size();i++) {
			if(i==0) {
				lists.add(hashMap.get(i));
				continue;
			}
			int index =-1;
			for(int s=0;s<lists.size();s++) {
				if(hashMap.get(i).get("comm_model").equals(lists.get(s).get("lists"))) {
					index =1;
					int stoc_count = Integer.parseInt(hashMap.get(i).get("stoc_count").toString())+Integer.parseInt(lists.get(s).get("stoc_count").toString());
					int lock_count = Integer.parseInt(hashMap.get(i).get("lock_count").toString())+Integer.parseInt(lists.get(s).get("lock_count").toString());
					int scrap_count = Integer.parseInt(hashMap.get(i).get("scrap_count").toString())+Integer.parseInt(lists.get(s).get("scrap_count").toString());
					int ship_count = Integer.parseInt(hashMap.get(i).get("ship_count").toString())+Integer.parseInt(lists.get(s).get("ship_count").toString());
					int sample_count = Integer.parseInt(hashMap.get(i).get("sample_count").toString())+Integer.parseInt(lists.get(s).get("sample_count").toString());
					lists.get(s).put("stoc_count", stoc_count);
					lists.get(s).put("lock_count", lock_count);
					lists.get(s).put("scrap_count", scrap_count);
					lists.get(s).put("ship_count", ship_count);
					lists.get(s).put("sample_count", sample_count);
				}
			}
			if(index==-1) {
				lists.add(hashMap.get(i));
			}
		}
		return JSON.toJSONString(lists);
	}
	/**
	 * 分实例查询自己进货记录
	 */
	@Override
	public String queryPurchasesList(String data) {
		logger.info("/queryPurchasesList :"+data);
		HashMap<String,Object> dataMap = JSON.parseObject(data, HashMap.class);
		ArrayList<String> StringList = JSON.parseObject(JSON.toJSONString(dataMap.get("list")), ArrayList.class);
		ArrayList<HashMap<String,Object>> sumList = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<StringList.size();i++) {
			HashMap<String,Object> HashMap = new HashMap<String, Object>();
			HashMap.put("start_date",dataMap.get("start_date"));
			HashMap.put("ending_date",dataMap.get("ending_date"));
			HashMap.put("comm_model", StringList.get(i));
			ArrayList<HashMap<String,Object>> tempList = statementDao.queryPurchasesList(HashMap);
			HashMap.put("start_date",null);
			HashMap.put("ending_date",null);
			HashMap.put("list", tempList);
			sumList.add(HashMap);
		}
		return JSON.toJSONString(sumList);
	}
	/**
	 * 自实例查询自己品类型号信息
	 */
	@Override
	public String queryCategoryModel() {
		logger.info("/queryCategoryModel ");
		ArrayList<HashMap<String,Object>> list = statementDao.queryPullStatementsCate(new HashMap<String,Object>());
		Set<String> setCate1 = new HashSet<String>();
		Set<HashMap<String,Object>> setCate2 = new HashSet<HashMap<String,Object>>();
		Set<HashMap<String,Object>> set = new HashSet<HashMap<String,Object>>();
		Set<HashMap<String,Object>> set2 = new HashSet<HashMap<String,Object>>();
		for(int i=0;i<list.size();i++) {
			HashMap<String,Object> cate1Model = new HashMap<String, Object>();
			cate1Model.put("cate_name1", list.get(i).get("cate_name1"));
			cate1Model.put("comm_model1", list.get(i).get("comm_model1"));
			setCate1.add(list.get(i).get("cate_name1").toString());
			set.add(cate1Model);

			HashMap<String,Object> cate1Name2 = new HashMap<String, Object>();
			cate1Name2.put("cate_name1", list.get(i).get("cate_name1"));
			cate1Name2.put("cate_name2", list.get(i).get("cate_name2"));
			setCate2.add(cate1Name2);

			HashMap<String,Object> cate1Mode2 = new HashMap<String, Object>();
			cate1Mode2.put("cate_name2", list.get(i).get("cate_name2"));
			cate1Mode2.put("comm_model2", list.get(i).get("comm_model2"));
			set2.add(cate1Mode2);
		}
		ArrayList<HashMap<String,Object>> allList = new ArrayList<HashMap<String,Object>>();
		for(String string : setCate1) {
			HashMap<String,Object> HashMaps = new HashMap<String, Object>();
			ArrayList<String> listS = new ArrayList<String>();
			HashMaps.put("cate_name", string);
			ArrayList<HashMap<String,Object>> listson = new ArrayList<HashMap<String,Object>>();
			for(HashMap<String,Object> maps : set) {
				if(HashMaps.get("cate_name").equals(maps.get("cate_name1"))) {
					if(null!=maps.get("comm_model1")&&maps.get("comm_model1")!="") {
						listS.add(maps.get("comm_model1").toString());
					}
				}

				for(HashMap<String,Object> maps2 :setCate2) {
					if(null!=maps2.get("cate_name2")&&HashMaps.get("cate_name").equals(maps2.get("cate_name1"))) {
						Set<String> setlist = new HashSet<String>();
						for(HashMap<String,Object> maps3:set2) {
							if(null!=maps3.get("comm_model2")&&null!=maps2.get("cate_name2")&&maps2.get("cate_name2").equals(maps3.get("cate_name2"))) {
								setlist.add(maps3.get("comm_model2").toString());
							}
						}
						maps2.put("ModelList", setlist);
						maps2.put("cate_name1",null);
						listson.add(maps2);
					}
				}
				
			}
			if(listson.size()>0){
				HashMaps.put("lsit", listson);
			}
			HashMaps.put("comm_model", listS);
			allList.add(HashMaps);
		}
		return JSON.toJSONString(allList);
	}
	/**
	 * 子实例提供给总实例查询商品销售记录
	 */
	@Override
	public String queryOfferSalesRecordList(String data) {
		logger.info("/queryOfferSalesRecordList data: "+data);
		HashMap<String,Object> Map = JSON.parseObject(data, HashMap.class);
		ArrayList<String> List = JSON.parseObject(JSON.toJSONString(Map.get("list")), ArrayList.class);
		ArrayList<HashMap<String,Object>> resultList = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<List.size();i++) {
			HashMap<String,Object> HashMap = new HashMap<String,Object>();
			HashMap.put("comm_model", List.get(i));
			HashMap.put("start_date",Map.get("start_date"));
			HashMap.put("ending_date",Map.get("ending_date"));
			ArrayList<HashMap<String,Object>> tempList = statementDao.queryOfferSalesRecordList(HashMap);
			HashMap.put("list", tempList);
			HashMap.remove("start_date");
			HashMap.remove("ending_date");
			resultList.add(HashMap);
		}
		return JSON.toJSONString(resultList);
	}
	/**
	 * 总实例查询商品销售记录报表
	 */
	@Override
	public String queryInstanceSalesRecord(String data) {
		logger.info("/queryInstanceSalesRecord data: "+data);
		HashMap<String,Object> Map = JSON.parseObject(data,HashMap.class);
		ArrayList<Integer> exampleList = JSON.parseObject(JSON.toJSONString(Map.get("exampleList")), ArrayList.class);
		ArrayList<ExampleTab> ExampleTabList = new ArrayList<ExampleTab>();
		for(int i=0;i<exampleList.size();i++) {
			HashMap<String,Object> tempMap = new HashMap<String,Object>();
			tempMap.put("example_id", exampleList.get(i));
			ArrayList<ExampleTab> tab =exampleTabDao.queryExampleTab(tempMap);
			ExampleTabList.add(tab.get(0));
		}
		ArrayList<HashMap<String,Object>> arrStr = new ArrayList<HashMap<String,Object>>();
		String result =null;
		try {
			for(int i=0;i<ExampleTabList.size();i++) {

				result = HttpReq.httpRequest(ExampleTabList.get(i).getExample_IP()+"/hangrano2o/Statement/queryOfferSalesRecordList", "POST",data);
				//HashMap<String,Object> resuMap = JSON.parseObject(result, HashMap.class);
				//logger.info("result httpPush :"+ JSON.toJSONString(resuMap.get("list")));
				ArrayList<String> strList= JSON.parseObject(result, ArrayList.class);
				HashMap<String,Object> tempMap = new HashMap<String,Object>();
				tempMap.put("name", ExampleTabList.get(i).getExample_name());
				tempMap.put("list", strList);
				arrStr.add(tempMap);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return JSON.toJSONString(arrStr);
	}
	/**
	 * 自实例提供给总实例查询库存信息报表
	 */
	@Override
	public String queryInstanceStockList(String data) {
		logger.info("/queryInstanceStockList data: "+data);
		HashMap<String,Object> Map = JSON.parseObject(data, HashMap.class);
		ArrayList<String> List = JSON.parseObject(JSON.toJSONString(Map.get("list")), ArrayList.class);
		ArrayList<HashMap<String, Object>> resultList = new ArrayList<HashMap<String, Object>>();
		for(int i=0;i<List.size();i++) {
			HashMap<String,Object> tempMap = new HashMap<String,Object>();
			tempMap.put("comm_model",List.get(i));
			if(Map.containsKey("start_date")) {
				tempMap.put("start_date", Map.get("start_date"));
			}
			if(Map.containsKey("ending_date")) {
				tempMap.put("ending_date", Map.get("ending_date"));
			}
			int put_count = statementDao.queryPurchasePutCount(tempMap);
			int push_count =statementDao.queryStockRemovalCount(tempMap);
			HashMap<String,Object> resultMap = statementDao.queryModelStockList(tempMap);
			if(Map.containsKey("start_date")) {
				tempMap.remove("start_date");
			}
			if(Map.containsKey("ending_date")) {
				tempMap.remove("ending_date");
			}
			tempMap.put("put_count", put_count);
			tempMap.put("push_count", push_count);
			if(null!=resultMap&&resultMap.containsKey("stoc_count")) {
				tempMap.put("stoc_count", resultMap.get("stoc_count"));
				tempMap.put("scrap_count", resultMap.get("scrap_count"));
				tempMap.put("sample_count", resultMap.get("sample_count"));
			}else {
				tempMap.put("stoc_count", 0);
				tempMap.put("scrap_count",0);
				tempMap.put("sample_count",0);
			}
			resultList.add(tempMap);
		}
		return JSON.toJSONString(resultList);
	}
	/**
	 * 总实例查询自实例库存信息报表
	 */
	@Override
	public String queryTotalInstanceStock(String data) {
		logger.info("/queryTotalInstanceStock data: "+data);
		HashMap<String,Object> Map = JSON.parseObject(data,HashMap.class);
		ArrayList<Integer> exampleList = JSON.parseObject(JSON.toJSONString(Map.get("exampleList")), ArrayList.class);
		ArrayList<ExampleTab> ExampleTabList = new ArrayList<ExampleTab>();
		for(int i=0;i<exampleList.size();i++) {
			HashMap<String,Object> tempMap = new HashMap<String,Object>();
			tempMap.put("example_id", exampleList.get(i));
			ArrayList<ExampleTab> tab =exampleTabDao.queryExampleTab(tempMap);
			ExampleTabList.add(tab.get(0));
		}
		ArrayList<HashMap<String,Object>> arrStr = new ArrayList<HashMap<String,Object>>();
		String result =null;
		try {
			for(int i=0;i<ExampleTabList.size();i++) {

				result = HttpReq.httpRequest(ExampleTabList.get(i).getExample_IP()+"/hangrano2o/Statement/queryInstanceStockList", "POST",data);
				//HashMap<String,Object> resuMap = JSON.parseObject(result, HashMap.class);
				//logger.info("result httpPush :"+ JSON.toJSONString(resuMap.get("list")));
				ArrayList<String> strList= JSON.parseObject(result, ArrayList.class);
				HashMap<String,Object> tempMap = new HashMap<String,Object>();
				tempMap.put("name", ExampleTabList.get(i).getExample_name());
				tempMap.put("list", strList);
				arrStr.add(tempMap);

			}
		} catch (Exception e) {
			// TODO: handle exception
			e.getMessage();
		}
		return JSON.toJSONString(arrStr);
	};

}
