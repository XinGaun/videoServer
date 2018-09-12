package com.entity;
/**
 * 库存量表实体类
 * @author vip
 *
 */
public class StockTab {
	private Integer stoc_id;
	private Integer ware_id;
	private Integer comm_id;
	private Integer stoc_count;
	private Integer lock_count;
	private Integer scrap_count;
	private Integer ship_count;
	private Integer sample_count;
	
	public Integer getSample_count() {
		return sample_count;
	}
	public void setSample_count(Integer sample_count) {
		this.sample_count = sample_count;
	}
	public Integer getStoc_id() {
		return stoc_id;
	}
	public void setStoc_id(Integer stoc_id) {
		this.stoc_id = stoc_id;
	}
	public Integer getWare_id() {
		return ware_id;
	}
	public void setWare_id(Integer ware_id) {
		this.ware_id = ware_id;
	}
	public Integer getComm_id() {
		return comm_id;
	}
	public void setComm_id(Integer comm_id) {
		this.comm_id = comm_id;
	}
	public Integer getStoc_count() {
		return stoc_count;
	}
	public void setStoc_count(Integer stoc_count) {
		this.stoc_count = stoc_count;
	}
	public Integer getLock_count() {
		return lock_count;
	}
	public void setLock_count(Integer lock_count) {
		this.lock_count = lock_count;
	}
	public Integer getScrap_count() {
		return scrap_count;
	}
	public void setScrap_count(Integer scrap_count) {
		this.scrap_count = scrap_count;
	}
	public Integer getShip_count() {
		return ship_count;
	}
	public void setShip_count(Integer ship_count) {
		this.ship_count = ship_count;
	}
	
}
