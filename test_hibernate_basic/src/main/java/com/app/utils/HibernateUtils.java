package com.app.utils;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;


public class HibernateUtils {
	private static SessionFactory factory;
	//static init block to create singleton SF
	//Configuration --> configure --> buildSessionFactory
	
	static {
		//build SF
		System.out.println("in static init block");//empty config object
		factory = new Configuration()
				.configure()//read props from hibernate configuration file
				//populate the configuration
				//populated with the properties from 
				//hibernate.cfg.xml
				.buildSessionFactory();
		//build instance of SF from the populated(filled up) config
		System.out.println("SF created");
	}
	public static SessionFactory getFactory() {
		return factory;
	}
}
