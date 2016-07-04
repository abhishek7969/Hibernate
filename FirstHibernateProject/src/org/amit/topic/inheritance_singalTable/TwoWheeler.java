package org.amit.topic.inheritance_singalTable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("Bike")
public class TwoWheeler extends Vehicle{
	
	private String SteeringHandler;

	public String getSteeringHandler() {
		return SteeringHandler;
	}

	public void setSteeringHandler(String steeringHandler) {
		SteeringHandler = steeringHandler;
	}
	

}
