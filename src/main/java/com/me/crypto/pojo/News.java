package com.me.crypto.pojo;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
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
@Table(name="news_table")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="messageid")
	private int messageId;

	@Column(name="message")
	private String message;

	@Column(name="dateCreated")
	private String dateCreated;
	
	@Column(name="coinConcerned")
	private String coinConcern;
	
	@OneToMany
	private Set<Coin> coins; // Better if hashtable <String, Coin> to store Coin object with simple coin name.
	
	public News() {
		coins = new HashSet<Coin>(); // Might be usedles
		
		DateFormat dateformat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Date date = new Date();
		this.dateCreated = dateformat.format(date);
	}

	// Setters & Getters
	
	public int getMessageId() {
		return messageId;
	}

	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Set<Coin> getCoins() {
		return coins;
	}

	public void setCoins(Set<Coin> coins) {
		this.coins = coins;
	}

	public String getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(String dateCreated) {
		this.dateCreated = dateCreated;
	}

	public String getCoinConcern() {
		return coinConcern;
	}

	public void setCoinConcern(String coinConcern) {
		this.coinConcern = coinConcern;
	}
	
	
	
	
	
}
