package com.me.crypto.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="person_table")
@Inheritance(strategy=InheritanceType.JOINED) //table per subclass
public class Person {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="personid",unique=true,nullable=false)
	private long personid;
	
	@Column(name="fName")
	private String firstname;
	
	@Column(name="lName")
	private String lastName;
	
	@OneToOne
	User user;
	
	public Person() {}
	
	
	// Setters & Getters
	
	public long getPersonid() {
		return personid;
	}

	public void setPersonid(long personid) {
		this.personid = personid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
}
