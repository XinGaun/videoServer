package com.service.serviceImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.dao.CouponDao;
import com.entity.Coupon;
import com.entity.UseCoupon;
import com.service.CouponService;
import com.util.Count;
import com.util.PageHelper;
import com.util.PaginationBean;
import com.util.UUID;
@Service
@SuppressWarnings("unchecked")
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;

	@Override
	public String addCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return couponDao.addCoupon(coupon)-1 == 0 ? "添加成功" : "添加失败";
	}

	@Override
	public String addDiscountsUse(UseCoupon userCoupon) {
		// TODO Auto-generated method stub
		return couponDao.addDiscountsUse(userCoupon)-1 == 0 ? "添加成功" : "添加失败";
	}
	@Override
	public String queryCoupon(String data) {
		// TODO Auto-generated method stub
		//System.out.println(data);
		PageHelper<Coupon> map = JSON.parseObject(data, PageHelper.class);
		Coupon coupon = JSON.parseObject(data, Coupon.class);
		map.setTotal(couponDao.queryCouponCount(coupon));
		map.setData(convertData(couponDao.queryCoupon(coupon)));
		return JSON.toJSONString(map);
	}
	private List<Coupon> convertData(List<Coupon> couponList) {
		for(Coupon coupon : couponList) {
			coupon.setDiscountsValue(coupon.getDiscountsValid() == 0 ? "有效" : "无效");
		}
		return couponList;
	}
	@Override
	public List<Coupon> queryCoupon(Integer discountsId) {
		// TODO Auto-generated method stub
		return couponDao.queryCouponById(discountsId);
	}

	@Override
	public String deleteCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return coupon.getDiscountsValid() == null || coupon.getDiscountsValid() == 0 ? (couponDao.deleteCoupon(coupon.getDiscountsId())-1 == 0 ? "删除成功" : "删除失败") : (couponDao.delCoupon(coupon)-1 == 0 ? "失效成功" : "失效失败");
	}

	@Override
	public List<Coupon> queryCouponByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return couponDao.queryCouponByUserId(userId);
	}
	/**
	 * 据年级查询课程分类信息
	 */
	@Override
	public String queryvideoFormClass(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = couponDao.queryvideoFormClass(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryvideoFormClass success"));
	}
	/**
	 * 根据课程分类ID查询所属课程信息
	 */
	@Override
	public String queryCoursesTabAll(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = couponDao.queryCoursesTabAll(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryCoursesTabAll success"));
	}
	/**
	 * 添加优惠码信息
	 */
	@Transactional
	public String addDiscountsTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		map.put("discounts_id", -1);
		map.put("discounts_money", map.get("discounts_money")+".00");
		int flog = couponDao.addDiscountsTab(map);
		if(flog>0) {
			int num = Integer.parseInt(map.get("add_num").toString());
			ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
			for(int i=0;i<num;i++) {
				HashMap<String,Object> temMap = new HashMap<String,Object>();
				temMap.put("discounts_id", map.get("discounts_id"));
				temMap.put("discounts_code", UUID.GetGUID());
				list.add(temMap);
			}
			couponDao.addDiscountsNumberTab(list);
			return JSON.toJSONString(Count.counts(null, -1, map,200,"addDiscountsTab success"));
		}else {
			return JSON.toJSONString(Count.counts(null, -1, map,400,"addDiscountsTab error"));
		}
	}
	/**
	 * 查询优惠卷信息
	 */
	@Override
	public String queryDiscountsTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int totalRows = couponDao.queryDiscountsTabCount(map);
		PaginationBean page = new PaginationBean();
		page.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		page.setCurrentPage(Integer.parseInt(map.get("currPage").toString()));
		page.setTotalRows(totalRows);
		page.repaginate();
		map.put("startNum", page.getStartNum());
		map.put("endIndex", page.getEndIndex());
		ArrayList<HashMap<String,Object>> list = couponDao.queryDiscountsTab(map);
		HashMap<String,Object> hashMap = new HashMap<String,Object>();
		hashMap.put("Code", 200);
		hashMap.put("listObject", list);
		hashMap.put("totalRows", page.getTotalRows());
		return JSON.toJSONString(hashMap);
	}
	/**
	 * 修改优惠卷信息
	 */
	@Override
	public String updateDiscountsTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		if(map.get("discounts_money").toString().indexOf(".")<=-1) {
			map.put("discounts_money", map.get("discounts_money")+".00");
		}
		int flog = couponDao.updateDiscountsTab(map);
		if(flog>0){
			return JSON.toJSONString(Count.counts(null, -1, map,200,"updateDiscountsTab success"));
		}
		return JSON.toJSONString(Count.counts(null, -1, map,400,"updateDiscountsTab error"));
	}
	/**
	 * 根据优惠卷ID查询优惠码信息
	 */
	@Override
	public String queryDiscountsNumberTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		ArrayList<HashMap<String,Object>> list = couponDao.queryDiscountsNumberTab(map);
		return JSON.toJSONString(Count.counts(list, -1, map,200,"queryDiscountsNumberTab success"));
	}
	/**
	 * 根据优惠卷ID追加优惠码信息
	 */
	@Transactional
	public String addDiscountsNumberTab(String data) {
		HashMap<String,Object> map = JSON.parseObject(data, HashMap.class);
		int num = Integer.parseInt(map.get("add_num").toString());
		ArrayList<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>();
		for(int i=0;i<num;i++) {
			HashMap<String,Object> temMap = new HashMap<String,Object>();
			temMap.put("discounts_id", map.get("discounts_id"));
			temMap.put("discounts_code", UUID.GetGUID());
			list.add(temMap);
		}
		couponDao.addDiscountsNumberTab(list);
		return JSON.toJSONString(Count.counts(null, -1, map,200,"addDiscountsNumberTab success"));
	}
	
	

}
