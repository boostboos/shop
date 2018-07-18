package com.legendary.dao;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.legendary.entity.PageBean;
import com.legendary.entity.SubCatalogs;

public class SubCatalogsImplTest {
	SubCatalogsImpl scli = new SubCatalogsImpl();
	Random rand = new Random();
	
	@Test
	public void testAddSubCatalogs() {
		SubCatalogs subCatalogs = new SubCatalogs();
		for (int i = 0; i < 100; i++) {
			subCatalogs.setCid(rand.nextInt()%2);
			subCatalogs.setScname(rand.nextInt()%1000+"");
			subCatalogs.setSubcata(rand.nextInt()%1000+"");
			scli.addSubCatalogs(subCatalogs);
		}
	}

	@Test
	public void testEditSubCatalogs() {
		SubCatalogs subCatalogs = new SubCatalogs();
		subCatalogs.setCid(1);
		subCatalogs.setScname("2");
		subCatalogs.setSubcata("3");
		subCatalogs.setScid(1);
		scli.editSubCatalogs(subCatalogs);
	}

	@Test
	public void testDeleteSubCatalogs() {
		scli.deleteSubCatalogs(1);
	}

	@Test
	public void testFindAll() {
		List<SubCatalogs> list = scli.findAllByCid(0);
		for (SubCatalogs subCatalogs : list) {
			System.out.println(subCatalogs);
		}
		System.out.println(list.size());
	}

	@Test
	public void testLoad() {
		SubCatalogs sc = scli.load(2);
		System.out.println(sc);
	}

	@Test
	public void testQuery() {
		SubCatalogs sc = new SubCatalogs();
		PageBean<SubCatalogs> pb = scli.query(sc, 1, 10);
		List<SubCatalogs> list = pb.getBeanList();
		for (SubCatalogs subCatalogs : list) {
			System.out.println(subCatalogs);
		}
		
	}

	@Test
	public void testDeleteAll() {
		scli.deleteAll(0);
	}

}
