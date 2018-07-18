package com.legendary.dao;
import static org.junit.Assert.*;

import java.util.List;
import java.util.Random;

import org.junit.Test;

import com.legendary.dao.CommentsDaoI;
import com.legendary.dao.CommentsDaoImpl;
import com.legendary.entity.CommentHelper;
import com.legendary.entity.Comments;
import com.legendary.entity.PageBean;


public class ComtestDaoImpl {
//	private static final Comments comments = null;
	CommentsDaoI com = new CommentsDaoImpl();
	
	@Test
	public void testFindComments() {
		List<CommentHelper> comments = com.find("1531052382734");
		System.out.println(comments);
	}

	
	@Test
	public void testAddComments() {
		Random random=new Random();
		Comments co=new Comments();
		for(int i=0;i<10;i++)
		{
			co.setMeid(random.nextInt()%100);
			co.setGid(random.nextInt()%100);
			co.setInfo(random.nextInt()%100+"");
			com.addComments(co);
		}
	}

	@Test
	public void testEditComments() {
		Comments co=new Comments();
		co.setMeid(1);
		co.setGid(1);
		co.setInfo("1");
		co.setCid(2);
		com.editComments(co);
	}

	@Test
	public void testDeleteComments() {
		com.deleteComments(10);
	}


	@Test
	public void testLoad() {
		Comments comm=com.load(1);
		System.out.print(comm.toString());
	}

	@Test
	public void testQuery() {
		Comments comments=new Comments();
		PageBean<Comments> comm = com.query(comments, 1, 10);
		for(Comments p: comm.getBeanList())
		{
			System.out.println(p.toString());
		}
	}

}
