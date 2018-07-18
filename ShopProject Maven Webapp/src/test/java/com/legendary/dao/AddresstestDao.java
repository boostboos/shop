package com.legendary.dao;
import static org.junit.Assert.*;

import java.util.Random;

import org.junit.Test;

import com.legendary.dao.AddressDaoI;
import com.legendary.dao.AddressDaoImpl;
import com.legendary.entity.Address;
import com.legendary.entity.PageBean;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class AddresstestDao {
	AddressDaoI address=new AddressDaoImpl();

	@Test
	public void testAddAddress() {
		Random random=new Random();
		Address addr=new Address();
		addr.setMeid(random.nextInt()%100);
		addr.setAddressinfo(random.nextInt()%100+"");
		address.addAddress(addr);
		}

	@Test
	public void testEditAddress() {
		Address addr=new Address();
		addr.setMeid(100);
		addr.setAddressinfo("100");
		addr.setAid(2);
		address.editAddress(addr);
	}

	@Test
	public void testDeleteAddress() {
		address.deleteAddress(2);
	}

	@Test
	public void testLoad() {
	}

	@Test
	public void testQuery() {
	}

}
