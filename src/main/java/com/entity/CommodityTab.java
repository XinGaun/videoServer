package com.entity;


/**
 * 商品表实体类
 * @author vip
 *
 */
public class CommodityTab {
	private Integer comm_id;//商品ID
	private String comm_type;//销售类型
	private int comm_cate_id;//品类ID
	private int comm_supp_id;//供应商ID
	private int comm_brand_id;//品牌ID
	private String comm_name;//商品名称
	private String comm_model;//型号
	private String comm_unit;//单位
	private String comm_price;//线上原价
	private String comm_current_price;//线上现价
	private String offline_price;//线下价格
	private String comm_main_img;//主视图照片
	private String comm_else_img;//其他照片列表
	private String comm_details;//商品详情
	private int comm_putaway_id;//上架ID
	private String comm_status;//上架状态
	private int comm_weight;//排序权重
	private String lock_status;//锁定状态
	private String comm_specification;//商品规格
	
	
	private Integer sale_id;
	private String sale_price;
	private Integer sale_num;
	private String real_price;
	private String discounts_id;
	
	
	private Integer disc_id;
	
	public Integer getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(Integer disc_id) {
		this.disc_id = disc_id;
	}
	public String getReal_price() {
		return real_price;
	}
	public void setReal_price(String real_price) {
		this.real_price = real_price;
	}
	public Integer getSale_id() {
		return sale_id;
	}
	public void setSale_id(Integer sale_id) {
		this.sale_id = sale_id;
	}
	public String getSale_price() {
		return sale_price;
	}
	public void setSale_price(String sale_price) {
		this.sale_price = sale_price;
	}
	public Integer getSale_num() {
		return sale_num;
	}
	public void setSale_num(Integer sale_num) {
		this.sale_num = sale_num;
	}
	public String getDiscounts_id() {
		return discounts_id;
	}
	public void setDiscounts_id(String discounts_id) {
		this.discounts_id = discounts_id;
	}
	public String getComm_specification() {
		return comm_specification;
	}
	public void setComm_specification(String comm_specification) {
		this.comm_specification = comm_specification;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	
	public String getComm_type() {
		return comm_type;
	}
	public void setComm_type(String comm_type) {
		this.comm_type = comm_type;
	}
	public String getOffline_price() {
		return offline_price;
	}
	public void setOffline_price(String offline_price) {
		this.offline_price = offline_price;
	}
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	public int getComm_cate_id() {
		return comm_cate_id;
	}
	public void setComm_cate_id(int comm_cate_id) {
		this.comm_cate_id = comm_cate_id;
	}
	public int getComm_supp_id() {
		return comm_supp_id;
	}
	public void setComm_supp_id(int comm_supp_id) {
		this.comm_supp_id = comm_supp_id;
	}
	public int getComm_brand_id() {
		return comm_brand_id;
	}
	public void setComm_brand_id(int comm_brand_id) {
		this.comm_brand_id = comm_brand_id;
	}
	public String getComm_name() {
		return comm_name;
	}
	public void setComm_name(String comm_name) {
		this.comm_name = comm_name;
	}
	public String getComm_model() {
		return comm_model;
	}
	public void setComm_model(String comm_model) {
		this.comm_model = comm_model;
	}
	public String getComm_unit() {
		return comm_unit;
	}
	public void setComm_unit(String comm_unit) {
		this.comm_unit = comm_unit;
	}
	public String getComm_price() {
		return comm_price;
	}
	public void setComm_price(String comm_price) {
		this.comm_price = comm_price;
	}
	public String getComm_current_price() {
		return comm_current_price;
	}
	public void setComm_current_price(String comm_current_price) {
		this.comm_current_price = comm_current_price;
	}
	public String getComm_main_img() {
		return comm_main_img;
	}
	public void setComm_main_img(String comm_main_img) {
		this.comm_main_img = comm_main_img;
	}
	public String getComm_else_img() {
		return comm_else_img;
	}
	public void setComm_else_img(String comm_else_img) {
		this.comm_else_img = comm_else_img;
	}
	public String getComm_details() {
		return comm_details;
	}
	public void setComm_details(String comm_details) {
		this.comm_details = comm_details;
	}
	public int getComm_putaway_id() {
		return comm_putaway_id;
	}
	public void setComm_putaway_id(int comm_putaway_id) {
		this.comm_putaway_id = comm_putaway_id;
	}
	public String getComm_status() {
		return comm_status;
	}
	public void setComm_status(String comm_status) {
		this.comm_status = comm_status;
	}
	public int getComm_weight() {
		return comm_weight;
	}
	public void setComm_weight(int comm_weight) {
		this.comm_weight = comm_weight;
	}
}
