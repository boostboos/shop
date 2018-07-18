package com.legendary.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import org.junit.Test;

import com.legendary.entity.Goods;
import com.legendary.entity.PageBean;
import com.legendary.entity.Roles;

public class GoodsDaoImplTest {
	GoodsDaoI gdi = DaoFactory.getGoodsDao();
	
	Goods good = new Goods();
	Random random = new Random();
	@Test
	public void testAddGoods() {
	}

	@Test
	public void testEditGoods() {
	}

	@Test
	public void testDeleteGoods() {
		gdi.deleteGoods(1);
	}

	@Test
	public void testFindAll() {
	 	PageBean<Goods> rb =  gdi.findAll(1, 10);
	 	for (Goods r : rb.getBeanList()) {
	 		System.out.println(r.toString());
		}
	}

	@Test
	public void testLoad() {

		Goods g = gdi.load(11);
		System.out.println(g.toString());
	}

	@Test
	public void testQuery() {
		
	}

}
