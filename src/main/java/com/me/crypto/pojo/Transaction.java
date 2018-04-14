package com.me.crypto.pojo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid")
	private int transactionid;
	@Column(name = "user")
	private User user;
	@Column(name = "amount")
	private double amount;
	@Column(name = "date")
	private Date date;
	@Column(name = "status")
	private boolean status;
	
	@OneToMany
	private Set<Coin> coins; // Transaction is composed of two coins ony
	
	public Transaction() {
		coins = new HashSet<Coin>();		
	}
	
	
	// Setters & Getters
	

	public int getTransactionid() {
		return transactionid;
	}

	public void setTransactionid(int transactionid) {
		this.transactionid = transactionid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public Set<Coin> getCoins() {
		return coins;
	}

	public void setCoins(Set<Coin> coins) {
		this.coins = coins;
	}
	

	
}
