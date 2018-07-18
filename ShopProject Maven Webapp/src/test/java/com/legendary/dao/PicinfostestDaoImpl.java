package com.legendary.dao;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import javax.sound.sampled.ReverbType;

import org.junit.Test;

import com.legendary.dao.PicinfosDaoI;
import com.legendary.dao.PicinfosDaoImpl;
import com.legendary.entity.Comments;
import com.legendary.entity.PageBean;
import com.legendary.entity.Picinfos;
import com.legendary.entity.Shoppingcart;

public class PicinfostestDaoImpl {
	PicinfosDaoI picinfos=new PicinfosDaoImpl();
	
	@Test
	public void testFindAll(){
	}
	
	@Test
	public void testAddPicinfos() {
		Random random = new Random();
		Picinfos pic=new Picinfos();
		for(int i=0;i<10;i++)
		{
			pic.setGid(random.nextInt()%100);
			pic.setPicinfo(random.nextInt()%100+"");
			picinfos.addPicinfos(pic);
		}
	}

	@Test
	public void testEditPicinfos() {
		Picinfos pic=new Picinfos();
		pic.setGid(100);
		pic.setPicinfo("xxx");
		pic.setPid("asdf");
		picinfos.editPicinfos(pic);
	}

	@Test
	public void testDeletePicinfos() {
		picinfos.deletePicinfos("2");
	}

	@Test
	public void testQuery() {
		Picinfos pici=new Picinfos();
		PageBean<Picinfos> piList = picinfos.query(pici, 1, 10);
		for(Picinfos p:piList.getBeanList())
		{
			System.out.println(p.toString());
		}
	}

	@Test
	public void testLoad() {
		Picinfos picinfo =picinfos.load("123");
		System.out.println(picinfo.toString());
	}



}
