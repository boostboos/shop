package com.legendary.dao;

import static org.junit.Assert.*;

import java.math.BigDecimal;
import java.util.Random;

import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;
import com.legendary.entity.Roles;

import org.junit.Test;

public class GoodsDetailDaoImplTest {
	
	public GoodsDetail goodDetail = new GoodsDetail();
	public Random random = new Random();
	public GoodsDetailDaoImpl gddi = new GoodsDetailDaoImpl();
	@Test
	public void testAddGoodDetail() {
		
		for (int i = 0; i <100; i++) {
			goodDetail.setSpecdetail(random.nextInt()%10000+"");
			goodDetail.setPurchprice(BigDecimal.valueOf(random.nextDouble()*1000));
			goodDetail.setSellprice(BigDecimal.valueOf(random.nextDouble()*1000));
			goodDetail.setMarketprice(BigDecimal.valueOf(random.nextDouble()*1000));
			goodDetail.setNumber(random.nextInt()%100);
			goodDetail.setGid(random.nextInt()%100);
			gddi.addGoodDetail(goodDetail);
		}
	}

	@Test
	public void testEditGoodDetail() {
		goodDetail.setSpecdetail("1,3");
		goodDetail.setPurchprice(BigDecimal.valueOf(345));
		goodDetail.setSellprice(BigDecimal.valueOf(234));
		goodDetail.setMarketprice(BigDecimal.valueOf(123));
		goodDetail.setNumber(1);
		goodDetail.setGid(202);
		goodDetail.setGdid(1);
		gddi.editGoodDetail(goodDetail);
	}

	@Test
	public void testDeleteGoodDetail() {
		gddi.deleteGoodDetail(3);
	}

	@Test
	public void testLoad() {
		GoodsDetail g = gddi.load(11);
		System.out.println(g.toString());
	}

	@Test
	public void testQuery() {
		GoodsDetail criteria = new GoodsDetail();
		PageBean<GoodsDetail> rb =  gddi.query(criteria, 1, 10);
	 	for (GoodsDetail r : rb.getBeanList()) {
	 		System.out.println(r.toString());
		}
	}

}
