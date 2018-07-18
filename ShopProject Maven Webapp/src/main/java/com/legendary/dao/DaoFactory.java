package com.legendary.dao;


import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class DaoFactory {
	private static Properties properties = null;
	static {
		try {
			InputStream in = DaoFactory.class.getClassLoader()
					.getResourceAsStream("dao.properties");
			properties = new Properties();
			properties.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static AdminsDaoI getAdminDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.AdminsDaoI");
		try {
			Class clazz = Class.forName(daoClassName);
			return (AdminsDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public static GoodsDaoI getGoodsDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.GoodsDaoI");
		System.out.println(daoClassName);
		try {
			Class clazz = Class.forName(daoClassName);
			return (GoodsDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static Object getDao(String daoName) {
		String daoClassName = properties.getProperty(daoName);
		System.out.println(daoClassName);
		try {
			Class clazz = Class.forName(daoClassName);
			return clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static RolesDaoI getRolesDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.RolesDaoI");
		System.out.println(daoClassName);
		try {
			Class clazz = Class.forName(daoClassName);
			return (RolesDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static CatalogsDaoI getCatalogsDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.CatalogsDaoI");
		try {
			Class clazz = Class.forName(daoClassName);
			return (CatalogsDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static SpecificationDaoI getSpecificationDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.SpecificationDaoI");
		try {
			Class clazz = Class.forName(daoClassName);
			return (SpecificationDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public static SpecificationDetailDaoI getSpecificationDetailDao() {
		String daoClassName = properties.getProperty("com.legendary.dao.SpecificationDetailDaoI");
		System.out.println(daoClassName);
		try {
			Class clazz = Class.forName(daoClassName);
			return (SpecificationDetailDaoI)clazz.newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
