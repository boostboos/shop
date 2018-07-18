package com.legendary.service;

import com.legendary.dao.MembersDaoI;
import com.legendary.dao.MembersDaoImpl;
import com.legendary.dao.DaoFactory;
import com.legendary.dao.GoodsDaoI;
import com.legendary.entity.Members;
import com.legendary.entity.PageBean;

public class MemberService {
	MembersDaoI mdi = new MembersDaoImpl();
	public boolean addMember(Members member) {
		mdi.addMember(member);
		return true;
	}
	public Members load(int id) {
		return mdi.load(id);
	}
	public void edit(Members member) {
		mdi.editMember(member);
	}
	public void delete(int meid) {
		mdi.deleteMember(meid);
	}
	public PageBean<Members> query(Members criteria, int pc, int ps) {
		return mdi.query(criteria,pc,ps);
	}
	
	public Members login(Members member) {
		
		String sql = "username='"+member.getUsername()+"' AND "+
				"passwd='"+ member.getPasswd()+"'";
					System.out.println(sql);
		return mdi.find(sql);
	}
	public Members find(Members member) {
		
		String sql = "username='"+member.getUsername()+"'";
					System.out.println(sql);
		return mdi.find(sql);
	}

}
