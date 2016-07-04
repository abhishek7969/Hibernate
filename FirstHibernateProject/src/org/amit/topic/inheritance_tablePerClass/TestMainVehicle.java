package org.amit.topic.inheritance_tablePerClass;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMainVehicle {

	public static void main(String[] args) {
		
		Vehicle v = new Vehicle();
		v.setVehicleName("car");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setVehicleName("DUKE KTM");
		tw.setSteeringHandler("Steering handle bike");
		
		FourWheeler fw = new FourWheeler();
		fw.setVehicleName("BMW");
		fw.setStreeringWheel("steering wheel BMW");
		
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(v);
		session.save(tw);
		session.save(fw);
		
		session.getTransaction().commit();
		session.close();

	}

}
