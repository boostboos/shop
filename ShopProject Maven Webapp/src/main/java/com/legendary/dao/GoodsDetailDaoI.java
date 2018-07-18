package com.legendary.dao;

import java.util.List;

import com.legendary.entity.Goods;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;

public interface GoodsDetailDaoI {
	public boolean addGoodDetail(GoodsDetail goodDetail);
	public boolean editGoodDetail(GoodsDetail goodDetail);
	public boolean deleteGoodDetail(int gdid);
	public GoodsDetail load(int gdid);
	public PageBean<GoodsDetail> query(GoodsDetail criteria, int pc, int ps);
	public boolean deleteAllGoodDetail(int gid);
	public List<GoodsDetail> findAll(int gid);

}
