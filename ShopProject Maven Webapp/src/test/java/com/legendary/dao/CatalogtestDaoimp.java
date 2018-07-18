package com.legendary.dao;

import static org.junit.Assert.*;

import java.awt.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.legendary.dao.CatalogsDaoI;
import com.legendary.dao.CatalogsDaoimpl;
import com.legendary.entity.Catalogs;
import com.legendary.entity.PageBean;
import com.legendary.service.CataService;
import com.mchange.v2.c3p0.impl.NewPooledConnection;

public class CatalogtestDaoimp {
	
	CatalogsDaoI cat=new CatalogsDaoimpl();

	Random random = new Random();
	Catalogs catalogs = new Catalogs();
	@Test
	public void testAddCata() {
		for (int i = 0; i < 100; i++) {
			catalogs.setCatalogName(random.nextInt()%1000+"");
			catalogs.setSortld(1);
			catalogs.setRemark(random.nextInt()%1000+"");
			cat.addCata(catalogs);
		}
	}

	@Test
	public void testEditCata() {
			catalogs.setCatalogName("1");
			catalogs.setSortld(2);
			catalogs.setRemark("3");
		    catalogs.setCid(4);
			cat.editCata(catalogs);

	}

	@Test
	public void testDeleteCata() {
		cat.deleteCata(4);
	}

	@Test
	public void testFindAll() {
	 	for (Catalogs r : cat.findAll()) {
	 		System.out.println(r.toString());
		}
	}

	@Test
	public void testLoad() {
		System.out.println(cat.load(5));
	}

	@Test
	public void testQuery() {
		Catalogs catalogs= new Catalogs();
	 	PageBean<Catalogs> rb =  cat.query(catalogs, 1, 10);
	 	for (Catalogs r : rb.getBeanList()) {
	 		System.out.println(r.toString());
		}
	}

}
