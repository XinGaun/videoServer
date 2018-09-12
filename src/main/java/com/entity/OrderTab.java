package com.entity;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 订单表实体类
 * @author vip
 *
 */
public class OrderTab {
	private Integer orde_id;//订单ID
	private String orde_total_val;//总价
	private String orde_status;//订单状态
	private Integer buye_id;//买家ID
	private String orde_addr;//送货地址
	private String orde_phone;//联系电话
	private String pay_status;//支付状态
	private String pay_type;//支付方式
	private Integer fina_tab;//财务记录ID
	private String orde_date;//下单时间
	private String pay_date;//支付时间
	private String orde_remark;//订单备注
	private String delivery_type;//配送方式
	private Integer deli_id;//配送单ID
	private Integer staf_deli_id;//配送员ID
	private Integer inst_id;//安装单ID
	private Integer staf_insf_id;//安装员ID
	private Integer ware_id;//出库仓库ID
	private String sell_type;//销售方式
	private Integer staf_sell_id;//销售员ID
	private String orde_invoice;//发票编号
	private ArrayList<CommodityTab> CommodityList;
	private ArrayList<ArrayList<HashMap<String,Object>>> SaleList;
	private String deli_name;
	private String jdde_name;
	
	private Integer disc_id;
	
	
	public Integer getDisc_id() {
		return disc_id;
	}
	public void setDisc_id(Integer disc_id) {
		this.disc_id = disc_id;
	}
	public ArrayList<ArrayList<HashMap<String, Object>>> getSaleList() {
		return SaleList;
	}
	public void setSaleList(ArrayList<ArrayList<HashMap<String, Object>>> saleList) {
		SaleList = saleList;
	}
	public String getDeli_name() {
		return deli_name;
	}
	public void setDeli_name(String deli_name) {
		this.deli_name = deli_name;
	}
	public String getJdde_name() {
		return jdde_name;
	}
	public void setJdde_name(String jdde_name) {
		this.jdde_name = jdde_name;
	}
	public ArrayList<CommodityTab> getCommodityList() {
		return CommodityList;
	}
	public void setCommodityList(ArrayList<CommodityTab> commodityList) {
		CommodityList = commodityList;
	}
	public Integer getOrde_id() {
		return orde_id;
	}
	public void setOrde_id(Integer orde_id) {
		this.orde_id = orde_id;
	}
	public String getOrde_total_val() {
		return orde_total_val;
	}
	public void setOrde_total_val(String orde_total_val) {
		this.orde_total_val = orde_total_val;
	}
	public String getOrde_status() {
		return orde_status;
	}
	public void setOrde_status(String orde_status) {
		this.orde_status = orde_status;
	}
	public Integer getBuye_id() {
		return buye_id;
	}
	public void setBuye_id(Integer buye_id) {
		this.buye_id = buye_id;
	}
	public String getOrde_addr() {
		return orde_addr;
	}
	public void setOrde_addr(String orde_addr) {
		this.orde_addr = orde_addr;
	}
	public String getOrde_phone() {
		return orde_phone;
	}
	public void setOrde_phone(String orde_phone) {
		this.orde_phone = orde_phone;
	}
	public String getPay_status() {
		return pay_status;
	}
	public void setPay_status(String pay_status) {
		this.pay_status = pay_status;
	}
	public String getPay_type() {
		return pay_type;
	}
	public void setPay_type(String pay_type) {
		this.pay_type = pay_type;
	}
	public Integer getFina_tab() {
		return fina_tab;
	}
	public void setFina_tab(Integer fina_tab) {
		this.fina_tab = fina_tab;
	}
	public String getOrde_date() {
		return orde_date;
	}
	public void setOrde_date(String orde_date) {
		this.orde_date = orde_date;
	}
	public String getPay_date() {
		return pay_date;
	}
	public void setPay_date(String pay_date) {
		this.pay_date = pay_date;
	}
	public String getOrde_remark() {
		return orde_remark;
	}
	public void setOrde_remark(String orde_remark) {
		this.orde_remark = orde_remark;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public Integer getDeli_id() {
		return deli_id;
	}
	public void setDeli_id(Integer deli_id) {
		this.deli_id = deli_id;
	}
	public Integer getStaf_deli_id() {
		return staf_deli_id;
	}
	public void setStaf_deli_id(Integer staf_deli_id) {
		this.staf_deli_id = staf_deli_id;
	}
	public Integer getInst_id() {
		return inst_id;
	}
	public void setInst_id(Integer inst_id) {
		this.inst_id = inst_id;
	}
	public Integer getStaf_insf_id() {
		return staf_insf_id;
	}
	public void setStaf_insf_id(Integer staf_insf_id) {
		this.staf_insf_id = staf_insf_id;
	}
	public Integer getWare_id() {
		return ware_id;
	}
	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}
	public String getSell_type() {
		return sell_type;
	}
	public void setSell_type(String sell_type) {
		this.sell_type = sell_type;
	}
	public Integer getStaf_sell_id() {
		return staf_sell_id;
	}
	public void setStaf_sell_id(Integer staf_sell_id) {
		this.staf_sell_id = staf_sell_id;
	}
	public String getOrde_invoice() {
		return orde_invoice;
	}
	public void setOrde_invoice(String orde_invoice) {
		this.orde_invoice = orde_invoice;
	}
	
}
