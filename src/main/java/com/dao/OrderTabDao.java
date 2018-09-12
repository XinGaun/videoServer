package com.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Mapper;

import com.entity.OrderTab;
/**
 * 订单Dao层接口
 * @author vip
 *
 */
@Mapper
public interface OrderTabDao {
	/**
	 * 添加订单信息
	 * @param orderTab
	 * @return
	 */
	public int addOrderTab(HashMap<String,Object> orderTab);
	/**
	 * 查询订单信息
	 * @param hashMap
	 * @return
	 */
	public ArrayList<HashMap<String,Object>> queryOrderTab(HashMap<String,Object> hashMap);
	/**
	 * 查询订单信息总数
	 * @param hashMap
	 * @return
	 */
	public int queryOrderTabCount(HashMap<String,Object> hashMap);
	/**
	 * 更新订单信息
	 * @param orderTab
	 * @return
	 */
	public int updateOrderTab(OrderTab orderTab);
	/**
	 * 删除订单信息
	 * @param orde_id
	 * @return
	 */
	public int deleteOrderTab(int orde_id);
	/**
	 * 添加财务记录
	 */
	public int addFinancialTab(HashMap<String,Object> map);
	/**
	 * 财务记录更新
	 */
	public int updateFinancialTab(HashMap<String,Object> map);
	/**
	 * 财务记录更新付款后
	 */
	public int updateFinancialTabEnd(HashMap<String,Object> map);
	
	
	/**
	 * 后端购物商品下单
	 */
	public int addOrderBack(HashMap<String,Object> map);
	/**
	 * 删除订单下的所属商品销售记录
	 */
	public int deleteOrderRecord(HashMap<String,Object> map);
	/**
	 * 删除所属订单的财务记录信息
	 */
	public int deleteOrderFinancial(HashMap<String,Object> map);
	/**
	 * 添加买家信息
	 */
	public int addBuyerTab(HashMap<String,Object> map);
	/**
	 * 添加送货地址信息
	 */
	public int addDeliverYaddrTab(HashMap<String,Object> map);
	/**
	 * 添加配送单信息
	 */
	public int addOrderDeliverTab(HashMap<String,Object> map);
	/**
	 * 更新配送单信息
	 * @param map
	 * @return
	 */
	public int updateOrderDeliverTab(HashMap<String,Object> map);
	/**
	 * 商城前端查询用户个人订单详情
	 */
	public ArrayList<OrderTab> queryBuyerOrder(HashMap<String,Object> map);
	/**
	 * 商城前端查询用户单独订单详情
	 */
	public OrderTab queryBuyerOrderDetails(HashMap<String,Object> map);
	/**
	 * 根据订单ID查询商品销售记录
	 */
	public ArrayList<HashMap<String,Object>> querySaleOrderID(HashMap<String,Object> map);
	/**
	 * 撤销订单时查询订单信息
	 */
	public HashMap<String,Object> queryOrderId(HashMap<String,Object> map);
	/**
	 * 撤销订单时查询财务记录信息
	 */
	public HashMap<String,Object> queryFinancialTabOredrID(HashMap<String,Object> map);
	/**
	 * 更新订单为撤销状态
	 */
	public int updateOrderID(HashMap<String,Object> map);
	/**
	 * 更新订单关联配送单信息
	 */
	public int updateOrdeIDDeli(HashMap<String,Object> map);
	/**
	 * 更新订单关联安装单信息
	 */
	public int updateOrdeIDInst(HashMap<String,Object> map);
}
