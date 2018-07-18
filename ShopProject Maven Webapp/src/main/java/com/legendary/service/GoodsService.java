package com.legendary.service;

import java.sql.Date;
import java.util.List;
import java.util.Map;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.GoodsDaoI;
import com.legendary.entity.Goods;
import com.legendary.entity.PageBean;

public class GoodsService {

	GoodsDetailService gds = new GoodsDetailService();
	GoodsDaoI gdi = (GoodsDaoI) DaoFactory.getDao("GoodsDaoI");
	public void addGoods(Goods goods) {
		gdi.addGoods(goods);
	}
	public Goods load(int id) {
		return gdi.load(id);
	}
	public void edit(Goods goods) {
		System.out.println("edit:"+goods);
		gdi.editGoods(goods);
	}
	public void delete(int gid) {
		gdi.deleteGoods(gid);
		gds.deleteAll(gid);
	}
	public PageBean<Goods> query(Goods criteria, int pc, int ps) {
		return gdi.query(criteria,pc,ps);
	}
	public List<Goods> findAll() {
		return gdi.findAll();
	}
	
	
	
}
