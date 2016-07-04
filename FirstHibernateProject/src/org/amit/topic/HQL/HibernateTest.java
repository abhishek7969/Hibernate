package org.amit.topic.HQL;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i =1;i<=10;i++){
			UserDetails1 ud = new UserDetails1();
			ud.setUserName("User"+i);
			session.save(ud);
		}
		
		Query query = session.createQuery("from UserDetails1"); //org.hibernate.Query; why this import?
		query.setFirstResult(5); //start of result set., i.e 5th record will be the first result. starts from 0
		query.setMaxResults(4); //allows to tell hibernate, max number of record need to be pulled.
		
		
		
		List<UserDetails1> users =(List<UserDetails1>)query.list();  //pull even the userId , which we don't want.
		
		System.out.println("size of the list = "+ users.size());
		
		session.getTransaction().commit();
		session.close();
		
		for(UserDetails1 ud : users){
			System.out.println(ud.getUserName());
		}
	}
}
