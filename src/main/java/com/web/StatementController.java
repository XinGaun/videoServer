package com.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
/**
 * 报表API
 * @author 87518
 *
 */

import com.service.StatementService;
@RequestMapping("/hangrano2o/Statement")
@ResponseBody
@Controller
public class StatementController {
	@Autowired
	private StatementService statementService;
	/**
	 * 查询报表信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStatement",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStatement(@RequestBody String data) {
		return statementService.queryStatement(data);
	}
	/**
	 * 查询报库存信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStockList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStockList() {
		return statementService.queryStockList();
	}
	/**
	 * 总实例查询报库存信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPullStatementListCate",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPullStatementListCate(@RequestBody String data) {
		return statementService.queryPullStatementListCate(data);
	}
	/**
	 * 查询品类信息商品型号接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPullCateModelList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPullCateModelList() {
		return statementService.queryPullCateModelList();
	}
	/**
	 * 查询销售记录信息接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPullCateModeSalelList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPullCateModeSalelList(@RequestBody String data) {
		return statementService.queryPullCateModeSalelList(data);
	}
	/**
	 * 总实例调用分实例获取销量信息
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryFenShiLiSaleList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryFenShiLiSaleList(@RequestBody String data) {
		return statementService.queryFenShiLiSaleList(data);
	}
	/**
	 * 总实例查询自实例自实例查询库存量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPullStockList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPullStockList(@RequestBody String data) {
		return statementService.queryPullStockList(data);
	}
	/**
	 * 总实例查询库存量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryStockLists",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryStockLists(@RequestBody String data) {
		return statementService.queryStockLists(data);
	}
	/**
	 * 总实例查询库存量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryPurchasesList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryPurchasesList(@RequestBody String data) {
		return statementService.queryPurchasesList(data);
	}
	/**
	 * 总实例查询库存量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryCategoryModel",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryCategoryModel() {
		return statementService.queryCategoryModel();
	}
	/**
	 * 自实例提供实例查询销售量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryOfferSalesRecordList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryOfferSalesRecordList(@RequestBody String data) {
		return statementService.queryOfferSalesRecordList(data);
	}
	/**
	 * 总实例查询销售量接口
	 * @param data
	 * @return
	 */
	@RequestMapping(value="/queryInstanceSalesRecord",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInstanceSalesRecord(@RequestBody String data) {
		return statementService.queryInstanceSalesRecord(data);
	}
	/**
	 * 自实例通过商品型号查询库存信息
	 */
	@RequestMapping(value="/queryInstanceStockList",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryInstanceStockList(@RequestBody String data) {
		return statementService.queryInstanceStockList(data);
	}
	/**
	 * 总实例查询自实例库存信息报表
	 */
	@RequestMapping(value="/queryTotalInstanceStock",produces="application/json;charset=utf-8",method=RequestMethod.POST)
	public String queryTotalInstanceStock(@RequestBody String data) {
		return statementService.queryTotalInstanceStock(data);
	}
}
