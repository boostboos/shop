package com.legendary.dao;

import static org.junit.Assert.*;

import java.sql.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.dbutils.QueryRunner;
import org.junit.Test;

import com.legendary.common.TxQueryRunner;
import com.legendary.service.LogService;

public class test {

	@Test
	public void test(){

		LogService ls = new LogService();
		ls.addLogs(1, "货物", 1);
	}
}
