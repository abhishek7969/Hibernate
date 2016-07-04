package org.amit.topic.transients.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTestNew {

	public static void main(String[] args) {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
	
		UserDetails ud = (UserDetails) session.get(UserDetails.class, 1);
		
		session.getTransaction().commit();
		session.close();
		
		ud.setUserName("updating user after session is closed");
		
		
		session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(ud);//object coming from the another session
		
		ud.setUserName("updating user inside persistance state");
		
		session.getTransaction().commit();
		session.close();
		
	}

}
