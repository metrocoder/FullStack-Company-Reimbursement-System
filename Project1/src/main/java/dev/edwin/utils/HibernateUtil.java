package dev.edwin.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	// we only ever want one sessionfactory
	// the SessionFactory Interface is resposbile for making the intitial database connection
	// and setting up the mappings between the entity and the table
	private static SessionFactory sf;
	
	private HibernateUtil() {};
	
	public static SessionFactory getSessionFactory() {
		
		if(sf == null) {
			
			Configuration cfg = new Configuration();// this constructor with no arguments is programmed to look for that 
			// configuration file and populate this cfg object with the information
			sf = cfg.configure().buildSessionFactory();
		}
		return sf;
	}
	

}
