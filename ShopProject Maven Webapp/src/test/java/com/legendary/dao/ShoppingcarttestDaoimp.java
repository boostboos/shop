package com.legendary.dao;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.legendary.dao.ShoppingcartDaoI;
import com.legendary.dao.ShoppingcartDaoImpl;
import com.legendary.entity.Comments;
import com.legendary.entity.PageBean;
import com.legendary.entity.ShopCartItem;
import com.legendary.entity.Shoppingcart;

public class ShoppingcarttestDaoimp {
	private static final Comments Shoppingcart = null;
	ShoppingcartDaoI shopping=new ShoppingcartDaoImpl();

	@Test

	public void testAddShoppingcart() {
		Random random = new Random();
		Shoppingcart shop = new Shoppingcart();
    	for (int i = 0; i < 10; i++) {
			shop.setMeid(random.nextInt()%100);
			shop.setGdid(random.nextInt()%100);
			shop.setNumber(random.nextInt()%100);
			shop.setTypes(random.nextInt()%100);
			shopping.addShoppingcart(shop);
		}
	}

	@Test
	public void testEditShoppingcart() {
		Shoppingcart shop = new Shoppingcart();
		shop.setGdid(11);
		shop.setNumber(11);
		shop.setTypes(11);
		shop.setMeid(1);
		shopping.editShoppingcart(shop);
	}

	@Test
	public void testDeleteShoppingcart() {
		shopping.deleteShoppingcart( 2, 39);
	}

	@Test
	public void testFindAll() {
		List<Shoppingcart> scList = shopping.findAll();
		for (Shoppingcart shoppingcart : scList) {
			System.out.println(shoppingcart);
		}
		
	}

	@Test
	public void testLoad() {
		Shoppingcart shoppingcart =shopping.load(1,2);
		System.out.println(shoppingcart.toString());
	}
	@Test
	public void testQuery() {
		ShopCartItem sci = new ShopCartItem();
		sci.setMeid(2);
		PageBean<ShopCartItem> pb = shopping.query(sci, 1, 10);
		for (ShopCartItem item : pb.getBeanList()) {
			System.out.println(item);
		}
	}
}
