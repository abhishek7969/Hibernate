package org.amit.topic.NamedQuery;



import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class NamedQueryTest {

	public static void main(String[] args) {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		for(int i =1;i<=10;i++){
			NamedQueryUserDetails ud = new NamedQueryUserDetails();
			ud.setUserName("User"+i);
			session.save(ud);
		}
		
		
		Query query = session.getNamedQuery("UserDetails.ById");
		query.setInteger(0, 2);
		

		List<NamedQueryUserDetails> users =(List<NamedQueryUserDetails>)query.list();  //pull even the userId , which we don't want.
		
		System.out.println("size of the list = "+ users.size());
		
		session.getTransaction().commit();
		session.close();
		
		for(NamedQueryUserDetails ud : users){
			System.out.println(ud.getUserName());
		}
		
				

	}

}
