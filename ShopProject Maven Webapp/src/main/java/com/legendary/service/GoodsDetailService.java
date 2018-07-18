package com.legendary.service;

import java.util.List;

import org.apache.commons.collections.Factory;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.GoodsDaoI;
import com.legendary.dao.GoodsDetailDaoI;
import com.legendary.dao.GoodsDetailDaoImpl;
import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;

public class GoodsDetailService {
	GoodsDetailDaoI gddi = (GoodsDetailDaoI) DaoFactory.getDao("GoodsDetailDaoI");

 	PictureService ps = new PictureService();
	public void addGoods(GoodsDetail goodsDetail) {
		gddi.addGoodDetail(goodsDetail);
	}
	public GoodsDetail load(int gdid) {
		return gddi.load(gdid);
	}
	public void edit(GoodsDetail goods) {
		gddi.editGoodDetail(goods);
	}
	public void delete(int gdid) {
		gddi.deleteGoodDetail(gdid);
	}
	
	public void deleteAll(int gid) {
		gddi.deleteAllGoodDetail(gid);
		ps.deleteAllByGid(gid);
	}
	public PageBean<GoodsDetail> query(GoodsDetail criteria, int pc, int ps) {
		return gddi.query(criteria,pc,ps);
	}
	
	public List<GoodsDetail> findAll(int gid) {
		return gddi.findAll(gid);
	}
}
