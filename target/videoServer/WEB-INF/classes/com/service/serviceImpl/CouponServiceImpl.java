package com.service.serviceImpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSON;
import com.dao.CouponDao;
import com.entity.Coupon;
import com.entity.UseCoupon;
import com.service.CouponService;
import com.util.PageHelper;
@Service
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
		System.out.println(data);
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
	
	

}
