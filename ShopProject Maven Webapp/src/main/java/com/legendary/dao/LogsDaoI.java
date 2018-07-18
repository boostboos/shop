package com.legendary.dao;

import com.legendary.entity.Logs;
import com.legendary.entity.PageBean;

public interface LogsDaoI {
	public boolean addLog(Logs log);
	public boolean deleteLog(int id);
	public PageBean<Logs> query(Logs criteria, int pc, int ps);

}
