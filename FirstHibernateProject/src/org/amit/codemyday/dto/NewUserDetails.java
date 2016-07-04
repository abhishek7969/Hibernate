package org.amit.codemyday.dto;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name= "User_Details_NEW")
public class NewUserDetails {

	//@EmbeddedId    combination of all the member variable as the primary key.
	@Id  @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@Embedded
	@AttributeOverrides({
	@AttributeOverride (name= "street" , column = @Column(name ="HOME_STREET_NAME")),
	@AttributeOverride (name= "city" , column = @Column(name ="HOME_CITY_NAME")),
	@AttributeOverride (name= "state" , column = @Column(name ="HOME_STATE")),
	@AttributeOverride (name= "pincode" , column = @Column(name ="HOME_PINCODE")),
	})
	private NewAddress home_Address;
	
	@Embedded
	private NewAddress office_Address;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public NewAddress getHome_Address() {
		return home_Address;
	}
	public void setHome_Address(NewAddress home_Address) {
		this.home_Address = home_Address;
	}
	public NewAddress getOffice_Address() {
		return office_Address;
	}
	public void setOffice_Address(NewAddress office_Address) {
		this.office_Address = office_Address;
	}
	
}
