package com.service;



import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.CommodityTab;

/**
 * 商品Service层接口
 * @author vip
 *
 */
public interface CommodityTabService {
	/**
	 * 添加商品
	 * @param req
	 * @param res
	 * @param comm_id	商品ID
	 * @param comm_main_img	主视图照片
	 * @param comm_else_img 其他照片列表
	 * @param comm_specification 商品规格
	 * @param comm_cate_id 品类ID
	 * @param comm_supp_id 供应商ID
	 * @param comm_brand_id 品牌ID
	 * @param comm_name 商品名称
	 * @param comm_model 型号
	 * @param comm_unit 单位
	 * @param comm_price 原价
	 * @param comm_current_price 现价
	 * @param comm_details 商品详情
	 * @param comm_status 上架状态
	 * @param comm_weight 排序权重
	 * @return
	 */
	public String addCommodityTab(@RequestParam("comm_main_imgs") MultipartFile comm_main_imgs,@RequestParam("comm_else_imgs") MultipartFile[] comm_else_imgs,CommodityTab commodityTab);
	/**
	 * 查询商品
	 * @param data
	 * @return
	 */
	public String queryCommodityTab(String data);
	/**
	 * 更新商品信息
	 */
	public String updateCommodityTab(@RequestParam(value="comm_main_imgs",required=false) MultipartFile comm_main_img,@RequestParam(value="comm_else_imgs",required=false) MultipartFile[] comm_else_img,CommodityTab commodityTab);
	/**
	 * 删除商品
	 * @param data
	 * @return
	 */
	public String deleteCommodityTab(String data);
	/**
	 * 根据商品IDNAME模糊搜索
	 * 
	 */
	public String queryCommName(String data);
	/**
	 * 前端查询商品信息
	 */
	public String quertFrontCommodityTab(String data);
	/**
	 * 后端查询商品购物信息
	 */
	public String queryCommodityTabBack(String data);
	/**
	 * 总实例添加商品接口
	 */
	public String addPushCommodityTab(@RequestParam("comm_main_imgs") MultipartFile comm_main_imgs,@RequestParam("comm_else_imgs") MultipartFile[] comm_else_imgs,CommodityTab commodityTab);
	/**
	 * 更新总实例商品信息并推送
	 * @return
	 */
	public String updatePushCommodityTab(@RequestParam(value="comm_main_imgs",required=false) MultipartFile comm_main_img,@RequestParam(value="comm_else_imgs",required=false) MultipartFile[] comm_else_img,CommodityTab commodityTab);
	/**
	 * 总实例删除商品信息
	 * @param data
	 * @return
	 */
	public String deletePushCommodityTab(String data);
}
