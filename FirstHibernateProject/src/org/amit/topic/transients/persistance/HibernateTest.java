package org.amit.topic.transients.persistance;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {

	public static void main(String[] args) {
		
		UserDetails ud = new UserDetails();
		ud.setUserName("Fist user");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		
		
	   /** this is a two step process, to instantiate the object and the 
		* second step is to pass this object to session.save().
		* If we don't save the object the userdetails object would be in the transient state.
		* when we call session.save on the object it become persistance object. hibernate track the obj and save it.
		* before an object is handed over to hibernate it is a transient object, hibernate dosnot track this object.
		* oject becomes detached , once session.close() is calles
		*/
		session.save(ud);
	
		
		/**
		 * one we pass the object to the session.save method, any change we make to that object , will go as an update.
		 * calling two update will result in following query.
		 * Hibernate: insert into USER_NEW (userName) values (?)
		 * Hibernate: update USER_NEW set userName=? where userId=?
		 * why?
		 * hibernate figures it out , what least number of update it needs to do, to reflect the change.
		 */

		ud.setUserName("updated user");  //update obj after the save? NOTE not asking hibernate to save the obj!!
		ud.setUserName("update Again");
		
		session.getTransaction().commit();
		session.close();

	}

}
/**									|<-------session-------------->|
*									| 			 get();(read)      |
* 								    |			  |	               |
*												  |	
*		     ___________	                 _____|________					_____________
-->new()--> |Transient  |---->              |persistent   |	----->		   |Detached     |
		    |___________|session.save()     |_____________|session.close() |_____________|
		    			              <<----
						     session.delete()
*/



