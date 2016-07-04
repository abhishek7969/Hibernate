package org.amit.topic.inheritance_singalTable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestMainVehicle {

	public static void main(String[] args) {
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("Car");
		
		TwoWheeler tw = new TwoWheeler();
		tw.setVehicleName("Bike");
		tw.setSteeringHandler("Bike Steering handler");
		
		FourWheeler fw = new FourWheeler();
		fw.setVehicleName("porsh");
		fw.setStreeringWheel("Steering wheel of porsh");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(vehicle);
		session.save(tw);
		session.save(fw);
		
		session.getTransaction().commit();
		session.close();

	}

}
