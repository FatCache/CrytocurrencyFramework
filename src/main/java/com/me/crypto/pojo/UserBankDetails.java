package com.me.crypto.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import com.me.crypto.pojo.User;

@Entity
@Table(name="userbankdetail_table")
public class UserBankDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="userbankdetailid")
	private int userBankDetailId;
	
	@Column(name="balance")
	private double balance;
	@Column(name="bankname")
	private String bankName;
	@Column(name="creditCardNumber")
	private int creditCardNumber;
	@Column(name="csv")
	private int csv;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private User user;
	
	public UserBankDetails() {}
	
	// Setters & Getters
	
	public int getUserBankDetailId() {
		return userBankDetailId;
	}
	public void setUserBankDetailId(int userBankDetailId) {
		this.userBankDetailId = userBankDetailId;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public int getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(int creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public int getCsv() {
		return csv;
	}
	public void setCsv(int csv) {
		this.csv = csv;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	 
	
	
	
	

}
