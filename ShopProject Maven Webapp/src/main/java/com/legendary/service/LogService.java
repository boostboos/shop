package com.legendary.service;

import java.sql.Date;
import java.text.SimpleDateFormat;

import com.legendary.dao.DaoFactory;
import com.legendary.dao.LogsDaoI;
import com.legendary.entity.Logs;
import com.legendary.entity.PageBean;

public class LogService {
	LogsDaoI ldi = (LogsDaoI) DaoFactory.getDao("LogsDaoI");
	public void addLogs(int operateType, String content, int uid) {
		String result="";
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(new java.util.Date().getTime());
		
		System.out.println(df.format(date));
		switch (operateType) {
		case 1:
			result="用户:"+uid+"执行了添加"+content+"操作,在"+df.format(date);
			break;
		case 2:
			result="用户:"+uid+"执行了删除"+content+"操作,在"+df.format(date);
			break;
		case 3:
			result="用户:"+uid+"执行了修改"+content+"操作,在"+df.format(date);
			break;
		case 4:
			result="用户:"+uid+"执行了查询"+content+"操作,在"+df.format(date);
			break;
		default:
			result="用户:"+uid+"对"+content+"执行了未知操作,在"+df.format(date);
			break;
		}
		Logs log = new Logs();
		log.setContent(result);
		log.setUid(uid);
		log.setOperateDate(date);
		log.setOperateType(operateType);
		ldi.addLog(log);
	}
	public void delete(int lid) {
		ldi.deleteLog(lid);
	}
	public PageBean<Logs> query(Logs criteria, int pc, int ps) {
		return ldi.query(criteria,pc,ps);
	}
}
