package com.yudao.test.dao;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.dao.AabDao;
import com.yudao.test.BaseTest;

public class AabDaoTest extends BaseTest{
	@Autowired
	private AabDao dao;
	@Test
	public void test() {
		dao.queryAab();
	}
}
