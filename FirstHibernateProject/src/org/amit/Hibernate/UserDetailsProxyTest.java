package org.amit.Hibernate;

import org.amit.codemyday.dto.NewAddress;
import org.amit.codemyday.dto.UserDetailsProxy;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UserDetailsProxyTest {

	public static void main(String[] args) {
		UserDetailsProxy userDetails1 = new UserDetailsProxy();
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
		userDetails1 = (UserDetailsProxy) session.get(UserDetailsProxy.class, 1); //lazy by default, gives proxy class
		session.close();
		System.out.println("proxy object size "+userDetails1.getListOfAddr().size()); //uses hibernate proxy class to get all the list of address;  
	}
}
