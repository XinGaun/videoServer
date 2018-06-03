package com.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Coupon;
import com.entity.UseCoupon;
import com.dao.CouponDao;
import com.service.CouponService;
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
	public List<Coupon> quaryCoupon(Integer discountsId) {
		// TODO Auto-generated method stub
		
		return discountsId == null ? couponDao.queryCoupon() : couponDao.queryCouponById(discountsId);
	}

	@Override
	public String deleteCoupon(Coupon coupon) {
		// TODO Auto-generated method stub
		return coupon.getDiscountsValid() == null || coupon.getDiscountsValid() == 0 ? (couponDao.deleteCoupon(coupon.getDisCountsId())-1 == 0 ? "删除成功" : "删除失败") : (couponDao.delCoupon(coupon)-1 == 0 ? "失效成功" : "失效失败");
	}

	@Override
	public List<Coupon> queryCouponByUserId(Integer userId) {
		// TODO Auto-generated method stub
		return couponDao.queryCouponByUserId(userId);
	}
	
	

}
