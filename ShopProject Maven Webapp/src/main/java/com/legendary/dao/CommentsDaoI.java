package com.legendary.dao;

import java.util.List;

import com.legendary.entity.CommentHelper;
import com.legendary.entity.Comments;
import com.legendary.entity.PageBean;

public interface CommentsDaoI {
	public boolean addComments(Comments comments);
	public boolean editComments(Comments comments);
	public boolean deleteComments(int id);
	public PageBean<Comments> findAll(int pc, int ps);
	public Comments load(int id);
	public PageBean<Comments> query(Comments criteria, int pc, int ps);
	public List<CommentHelper> find(String oid);
	public List<Comments> find(Integer gid);
	

}
