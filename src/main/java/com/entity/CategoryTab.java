package com.entity;
/**
 * 品类表实体类
 * @author vip
 *
 */
public class CategoryTab {
	private Integer cate_id;//ID
	private String cate_name;//品类名称
	private int cate_superior;//父类ID
	private Integer cate_weight;//排序权重
	private String lock_status;//锁定状态
	public Integer getCate_id() {
		return cate_id;
	}
	public void setCate_id(Integer cate_id) {
		this.cate_id = cate_id;
	}
	public String getCate_name() {
		return cate_name;
	}
	public void setCate_name(String cate_name) {
		this.cate_name = cate_name;
	}
	
	public int getCate_superior() {
		return cate_superior;
	}
	public void setCate_superior(int cate_superior) {
		this.cate_superior = cate_superior;
	}
	public Integer getCate_weight() {
		return cate_weight;
	}
	public void setCate_weight(Integer cate_weight) {
		this.cate_weight = cate_weight;
	}
	public String getLock_status() {
		return lock_status;
	}
	public void setLock_status(String lock_status) {
		this.lock_status = lock_status;
	}
	
	
	
}
