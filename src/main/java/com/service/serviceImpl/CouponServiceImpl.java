package com.service.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Coupon;
import com.dao.CouponDao;
import com.service.CouponService;
@Service("CouponService")
public class CouponServiceImpl implements CouponService {
	@Autowired
	private CouponDao couponDao;
	
	

}
