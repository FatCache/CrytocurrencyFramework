package com.me.crypto.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "transaction_table")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "transactionid")
	private int transactionid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "userid")
	private User user;
	
	@Column(name = "amount")
	private double amount;
	
	@Column(name = "date")
	private String date;
	
	@Column(name = "status")
	private boolean status;
	
	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Coin> coins; // A transaction is only composed of two points only
	
	@Transient
	String coinA;
	
	@Transient
	String coinB;
	
	@Transient
	String passedByPersonId;
	
	public Transaction() {
		coins = new HashSet<Coin>();
		
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date dateCreate = new Date();
		this.date = dateformat.format(dateCreate);
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



	public String getDate() {
		return date;
	}


	public void setDate(String date) {
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


	public String getCoinA() {
		return coinA;
	}


	public void setCoinA(String coinA) {
		this.coinA = coinA;
	}


	public String getCoinB() {
		return coinB;
	}


	public void setCoinB(String coinB) {
		this.coinB = coinB;
	}


	public String getPassedByPersonId() {
		return passedByPersonId;
	}


	public void setPassedByPersonId(String passedByPersonId) {
		this.passedByPersonId = passedByPersonId;
	}
	
	


	

	
}
