package com.legendary.dao;


import java.util.List;

import com.legendary.entity.Address;
import com.legendary.entity.PageBean;

public interface AddressDaoI {
	public boolean addAddress(Address address);
	public boolean editAddress(Address address);
	public boolean deleteAddress(int id);
	public PageBean<Address> findAll(int pc, int ps);
	public Address load(int aid);
	public List<Address> query(int meid);
}
