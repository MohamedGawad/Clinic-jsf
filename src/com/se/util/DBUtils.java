package com.se.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DBUtils
{

	static Properties prop = new Properties();
	static InputStream input = null;
	static Configuration config;
	static SessionFactory factory;
	static
	{
		try
		{

			// ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			// prop.load(ec.getResourceAsStream("/config.properties"));
			// config = new Configuration().setProperty("hibernate.connection.url",
			// prop.getProperty("url")).setProperty("hibernate.connection.username",
			// prop.getProperty("username")).setProperty("hibernate.connection.password", prop.getProperty("password"));
			config = new Configuration();
			config.configure("com/se/util/hibernate1.cfg.xml");
			// StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder()
			// .applySettings(config.getProperties());
			factory = config.buildSessionFactory();

		}catch(Exception ex)
		{
			ex.printStackTrace();
		}finally
		{
			if(input != null)
			{
				try
				{
					input.close();
				}catch(IOException e)
				{
					e.printStackTrace();
				}
			}
		}
	}

	public static SessionFactory getSessionFactory()
	{

		return factory;

	}

	public static Session openSession()
	{
		try
		{
			return getSessionFactory().openSession();
		}catch(Exception e)
		{
			return null;
		}
	}

	public static boolean closeSession(Session session)
	{
		try
		{
			if(session != null && session.isOpen())
				session.close();
			return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}

	public static <T> T save(Session session, Object object)
	{

		try
		{
			Transaction tx = session.beginTransaction();
			T pk = (T) session.save(object);
			tx.commit();
			return pk;
		}catch(Exception e)
		{
			e.printStackTrace();
			return null;
		}

	}

	public static boolean saveOrUpdate(Session session, Object object)
	{

		try
		{
			Transaction tx = session.beginTransaction();
			session.saveOrUpdate(object);
			tx.commit();
			return true;

		}catch(Exception e)
		{
			e.printStackTrace();
			return false;

		}

	}

	public static boolean update(Session session, Object object)
	{

		try
		{
			Transaction tx = session.beginTransaction();
			session.update(object);
			tx.commit();
			return true;

		}catch(Exception e)
		{
			e.printStackTrace();
			return false;

		}

	}

	public static boolean delete(Session session, Object object)
	{

		try
		{
			Transaction tx = session.beginTransaction();
			session.delete(object);
			tx.commit();
			return true;

		}catch(Exception e)
		{
			e.printStackTrace();
			return false;

		}

	}

}
