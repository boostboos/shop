package com.legendary.service;

import java.util.List;

import com.legendary.dao.CommentsDaoI;
import com.legendary.dao.CommentsDaoImpl;
import com.legendary.entity.CommentHelper;
import com.legendary.entity.Comments;

public class CommentService {
	CommentsDaoI cdi = new CommentsDaoImpl();
	
	public void add(Comments comment) {
		cdi.addComments(comment);
	}
	public List<CommentHelper> find(String oid) {
		
		return cdi.find(oid);
	}
	public List<Comments> find(Integer gid) {
		return cdi.find(gid);
	}
	
	

}
