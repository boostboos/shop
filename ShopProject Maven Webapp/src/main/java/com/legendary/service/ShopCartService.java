package com.legendary.service;

import com.legendary.dao.ShoppingcartDaoI;
import com.legendary.dao.ShoppingcartDaoImpl;
import com.legendary.entity.GoodsDetail;
import com.legendary.entity.PageBean;
import com.legendary.entity.ShopCartItem;
import com.legendary.entity.Shoppingcart;

public class ShopCartService {
	
	ShoppingcartDaoI sdi = new ShoppingcartDaoImpl();
	public void add(Shoppingcart shopcart) {
		sdi.addShoppingcart(shopcart);
	}
	public PageBean<ShopCartItem> query(ShopCartItem criteria, int pc, int ps) {
		return sdi.query(criteria,pc,ps);
	}
	public Shoppingcart load(int meid, int gdid) {
		return sdi.load(meid, gdid);
	}
	public void edit(Shoppingcart sc) {
		sdi.editShoppingcart(sc);
	}
	
	public void delete(int meid,int gdid) {
		sdi.deleteShoppingcart(meid, gdid);
	}
	

}
