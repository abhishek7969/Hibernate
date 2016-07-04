package org.amit.topic.inheritance_tablePerClass;

import javax.persistence.Entity;

@Entity
public class FourWheeler extends  Vehicle {

	
	private String StreeringWheel;

	public String getStreeringWheel() {
		return StreeringWheel;
	}

	public void setStreeringWheel(String streeringWheel) {
		StreeringWheel = streeringWheel;
	}
}
