package org.amit.topic.inheritance_singalTable;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Entity
@Inheritance (strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VEHICLE_TYPE" , discriminatorType =DiscriminatorType.STRING)
public class Vehicle {  	//Single table strategy :- no matters what your inheritance strategy is , it will create one common table for all the entity.
	@Id @GeneratedValue
	private int vehicleId;
	private String vehicleName;
	
	public int getVehicleId() {
		return vehicleId;
	}
	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleName() {
		return vehicleName;
	}
	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}


/*
 DTYPE       | vehicleId | vehicleName | SteeringHandler       | StreeringWheel          |
+-------------+-----------+-------------+-----------------------+-------------------------+
| Vehicle     |         1 | Car         | NULL                  | NULL                    |
| TwoWheeler  |         2 | Bike        | Bike Steering handler | NULL                    |
| FourWheeler |         3 | porsh       | NULL                  | Steering wheel of porsh |

	DTYPE :-Is the name of the class, which is called a discriminator, to identify the type of object ,
	Default way of implementation.
	
+--------------+-----------+-------------+-----------------------+-------------------------+
| VEHICLE_TYPE | vehicleId | vehicleName | SteeringHandler       | StreeringWheel          |
+--------------+-----------+-------------+-----------------------+-------------------------+
| Vehicle      |         1 | Car         | NULL                  | NULL                    |
| Bike         |         2 | Bike        | Bike Steering handler | NULL                    |
| Car          |         3 | porsh       | NULL                  | Steering wheel of porsh |
+--------------+-----------+-------------+-----------------------+-------------------------+

*/
