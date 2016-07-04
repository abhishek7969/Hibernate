package org.amit.codemyday.dto;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity /*(name="USER_DETAILS")*/ 										//renaming the whole Entity used in HQL
@Table (name="USER_DETAILS")  											//renaming just the table not the entity.
public class UserDetails {
	@Id @GeneratedValue (strategy=GenerationType.TABLE)  // hibernate_sequences(sequence_name, sequence_next_hi_value)
	@Column(name = "USER_ID" )
	private int userId;
	@Column(name ="USER_NAME")
	private String userName;
	
	@Temporal (TemporalType.DATE)																
	private Date joinDate;
	@Basic 																//user hibernate default to persist the data 
	private String address;
	//@Transient														//Don't want hibernate to save this property.or make it as static
	@Lob																//large object  clob char large object															
	private String description;
	
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
