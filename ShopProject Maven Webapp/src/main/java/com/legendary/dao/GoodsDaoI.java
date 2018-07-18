package com.legendary.dao;


import java.util.List;

import com.legendary.entity.Goods;
import com.legendary.entity.PageBean;

public interface GoodsDaoI {
	public boolean addGoods(Goods goods);
	public boolean editGoods(Goods goods);
	public boolean deleteGoods(int id);
	public PageBean<Goods> findAll(int pc, int ps);
	public Goods load(int id);
	public PageBean<Goods> query(Goods criteria, int pc, int ps);
	public List<Goods> findAll();
}
