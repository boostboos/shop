package com.legendary.dao;

import java.util.List;

import com.legendary.entity.PageBean;
import com.legendary.entity.ShopCartItem;
import com.legendary.entity.Shoppingcart;

public interface ShoppingcartDaoI {
	public boolean addShoppingcart(Shoppingcart shoppingcart);
	public boolean editShoppingcart(Shoppingcart shoppingcart);
	public boolean deleteShoppingcart(int meid,int gdid);
	public Shoppingcart load(int meid,int gdid);
	public List<Shoppingcart> findAll();
	public PageBean<ShopCartItem> query(ShopCartItem criteria, int pc, int ps);

}
