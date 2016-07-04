package org.amit.Hibernate;

import org.amit.codemyday.dto.NewAddress;
import org.amit.codemyday.dto.NewUserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestNew {

	public static void main(String[] args) {
		NewUserDetails ud1 = new NewUserDetails();
		ud1.setUserName("First_User");
		
		NewAddress addrHome = new NewAddress();
		addrHome.setCity("pat");
		addrHome.setPincode("800008");
		addrHome.setState("Bihar");
		addrHome.setStreet("patna");
		ud1.setHome_Address(addrHome);
		
		
		NewAddress addrOffice = new NewAddress();
		addrOffice.setCity("blr");
		addrOffice.setPincode("560066");
		addrOffice.setState("Karnataka");
		addrOffice.setStreet("siddhapura");
		ud1.setOffice_Address(addrOffice);
		
	
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(ud1);
		session.getTransaction().commit();
		session.close();
	}
}
