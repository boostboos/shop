package com.legendary.service;

import java.util.List;

import com.legendary.dao.AddressDaoI;
import com.legendary.dao.AddressDaoImpl;
import com.legendary.dao.DaoFactory;
import com.legendary.entity.Address;
import com.legendary.entity.PageBean;

public class AddressService {
	AddressDaoI adri = new AddressDaoImpl();
	public void addAddress(Address address) {
		adri.addAddress(address);
	}
	
	public Address load(int aid) {
		return adri.load(aid);
	}
	
	public void edit(Address address) {
		adri.editAddress(address);
	}
	public void delete(int aid) {
		adri.deleteAddress(aid);
	}
	public List<Address> query(int meid) {
		System.out.println(meid+"service");
		return adri.query(meid);
	}
}
