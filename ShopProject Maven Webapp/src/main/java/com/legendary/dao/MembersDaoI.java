package com.legendary.dao;

import com.legendary.entity.Admins;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;

public interface MembersDaoI {
	public boolean addMember(Members member);
	public boolean editMember(Members member);
	public boolean deleteMember(int id);
	public Members load(int id);
	public Members find(String where);
	public PageBean<Members> query(Members criteria, int pc, int ps);
}
