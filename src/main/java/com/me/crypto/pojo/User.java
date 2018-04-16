package com.me.crypto.pojo;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table(name="user_table")
@PrimaryKeyJoinColumn(name = "personid")
public class User extends Person {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userid")
	private int userId;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@OneToMany
	private Set<Transaction> transactions;
		
	@OneToOne
	private UserBankDetails userBankDetail;
	
	
	public User(String username, String password) {
		this.username = username;
		this.password = password;
		transactions = new HashSet<Transaction>();
	}
	
	
	
	// Setters & Getters

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Transaction> getTransactions() {
		return transactions;
	}

	public void setTransactions(Set<Transaction> transactions) {
		this.transactions = transactions;
	}

	public UserBankDetails getUserBankDetail() {
		return userBankDetail;
	}

	public void setUserBankDetail(UserBankDetails userBankDetail) {
		this.userBankDetail = userBankDetail;
	}
	
	
	
	
	
	
	

}
