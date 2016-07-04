package org.amit.topic.curdOperations;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		for(int i =0;i<10;i++){
			UserDetails ud = new UserDetails();
			ud.setUserName("User"+i);
			session.save(ud);
		}
		
		UserDetails userDetails = (UserDetails)session.get(UserDetails.class, 5);
		
		userDetails.setUserName("Updated User");
		
		session.update(userDetails);
		
		
		
		//session.delete(userDetails);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("user details is "+userDetails.getUserName());
	}

}
