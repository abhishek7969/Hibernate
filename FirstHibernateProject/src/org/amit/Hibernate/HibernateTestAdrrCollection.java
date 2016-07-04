package org.amit.Hibernate;

import org.amit.codemyday.dto.NewAddress;
import org.amit.codemyday.dto.UserDetails;
import org.amit.codemyday.dto.UserDetailsAdrrCollection;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestAdrrCollection {

	public static void main(String[] args) {
		UserDetailsAdrrCollection userDetails1 = new UserDetailsAdrrCollection();
		userDetails1.setUserName("First User");	
		
		NewAddress addrHome = new NewAddress();
		addrHome.setCity("pat");
		addrHome.setPincode("800008");
		addrHome.setState("Bihar");
		addrHome.setStreet("patna");
		
		
		NewAddress addrOffice = new NewAddress();
		addrOffice.setCity("blr");
		addrOffice.setPincode("560066");
		addrOffice.setState("Karnataka");
		addrOffice.setStreet("siddhapura");
		
		userDetails1.getListOfAddr().add(addrHome);
		userDetails1.getListOfAddr().add(addrOffice);

		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails1);
		session.getTransaction().commit();
		
		session.close();
		userDetails1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
	
		
	}
}
