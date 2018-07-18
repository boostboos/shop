package com.legendary.dao;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Test;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.RolesDaoI;
import com.legendary.dao.RolesDaoImpl;
import com.legendary.entity.PageBean;
import com.legendary.entity.Roles;
import com.legendary.service.RoleService;

public class RolesDaoImplTest {
	RolesDaoI rdi = new RolesDaoImpl();
	@Test
	public void testAddRoles() {
		Random random = new Random();
		Roles roles = new Roles();
		for (int i = 0; i < 100; i++) {
			roles.setAuthority(random.nextInt()%8);
			roles.setRemark(random.nextInt()%10000+"");
			roles.setRoleName(random.nextInt()%1000+"");
			rdi.addRoles(roles);
		}
	}

	@Test
	public void testEditRoles() {
		Roles roles = new Roles();
		roles.setAuthority(1);
		roles.setRemark(1+"");
		roles.setRoleName(1+"");
		roles.setRid(107);
		rdi.editRoles(roles);
	}

	@Test
	public void testDeleteRoles() {
		rdi.deleteRoles(107);
	}

	@Test
	public void testFindAll() {
		
		RolesDaoI rdi = DaoFactory.getRolesDao();
	 	PageBean<Roles> rb =  rdi.findAll(1, 10);
	 	for (Roles r : rb.getBeanList()) {
	 		System.out.println(r.toString());
		}
	}

	@Test
	public void testLoad() {
		
		Roles r = rdi.load(112);
		System.out.println(r.toString());
	}

}
