package org.amit.Hibernate;

import java.util.Date;

import org.amit.codemyday.dto.UserDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		UserDetails userDetails1 = new UserDetails();
		userDetails1.setUserName("First User");	
		
		userDetails1.setAddress("Bangalore");
		userDetails1.setJoinDate(new Date());
		userDetails1.setDescription("New Decription");
		
		UserDetails userDetails2 = new UserDetails();
		userDetails2.setUserName("Second User");	
		
		userDetails2.setAddress("Patna");
		userDetails2.setJoinDate(new Date());
		userDetails2.setDescription("New Decription ");
		
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		
		session.beginTransaction();
		session.save(userDetails1);
		session.save(userDetails2);
		session.getTransaction().commit();
		
		session.close();
		userDetails1 = null;
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		userDetails1 = (UserDetails)session.get(UserDetails.class, 1);
		
		System.out.println("user name---" + userDetails1.getUserName());
		System.out.println("user Address---" + userDetails1.getAddress());
		
	}
}
