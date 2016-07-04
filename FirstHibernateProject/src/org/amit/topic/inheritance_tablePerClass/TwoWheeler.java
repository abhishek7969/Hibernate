package org.amit.topic.inheritance_tablePerClass;

import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicle{
	
	private String SteeringHandler;

	public String getSteeringHandler() {
		return SteeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		SteeringHandler = steeringHandler;
	}
	

}
