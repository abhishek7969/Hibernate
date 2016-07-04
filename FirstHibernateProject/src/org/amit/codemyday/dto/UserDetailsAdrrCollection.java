package org.amit.codemyday.dto;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Table;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity
@Table (name= "UserDetailsAdrrCollection")
public class UserDetailsAdrrCollection {

	
	@Id  @GeneratedValue (strategy=GenerationType.AUTO)
	private int userId;
	private String userName;
	
	@ElementCollection
	@JoinTable(name ="USER_ADDRESS" , joinColumns=@JoinColumn (name ="USER_ID"))
	@GenericGenerator(name="hilo-gen",strategy="hilo")
	@CollectionId(columns = { @Column(name="ADDRESS_ID") }, generator = "hilo-gen", type = @Type(type="long"))
	private Collection<NewAddress> listOfAddr = new ArrayList<NewAddress>();
	
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
	public Collection<NewAddress> getListOfAddr() {
		return listOfAddr;
	}
	public void setListOfAddr(Collection<NewAddress> listOfAddr) {
		this.listOfAddr = listOfAddr;
	}
	

}
