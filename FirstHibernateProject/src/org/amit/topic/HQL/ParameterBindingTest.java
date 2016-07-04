package org.amit.topic.HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ParameterBindingTest {

	public static void main(String[] args) {
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i =1;i<=10;i++){
			UserDetails1 ud = new UserDetails1();
			ud.setUserName("User"+i);
			session.save(ud);
		}
		
		int userId =5;
		String manupulatedInput = "5 or 1 =1";
		
		/**
		 * This is actually a potential security problem.this leads to sql query injection.
		 * an hacker use this kind of way, to add value to the query , to manipulate the input to get the data,
		 * hacker can bypass out where clause and inject there own where clause, and can do what ever they want.
		 * Solution to do parameter substitution.
		 */
		
		//Query query = session.createQuery("from UserDetails1 where userId >"+ manupulatedInput);
		//Query query = session.createQuery("from UserDetails1 where userId >"+ userId); 
		
//		Query query = session.createQuery("from UserDetails1 where userId > ? and userName = ?"); 
//		query.setInteger(0,userId);
//		query.setString(1,"User10");
		
		Query query = session.createQuery("from UserDetails1 where userId > :userId and userName = :UserName"); 
		query.setInteger("userId", userId);
		query.setString("UserName", "User10");
		
		List<UserDetails1> users =(List<UserDetails1>)query.list();  
		
		System.out.println("size of the list = "+ users.size());
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails1 ud : users){
			System.out.println(ud.getUserName());
		}
		

	}

}
