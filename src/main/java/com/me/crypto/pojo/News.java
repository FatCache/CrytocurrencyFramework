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
@Table(name="news_table")
public class News {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="messageid")
	private int messageId;

	@Column(name="message")
	private String message;

	@Column(name="dateCreated")
	private Date dateCreated;
	
	@OneToMany
	private Set<Coin> coins;
	
	public News() {
		coins = new HashSet<Coin>();
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

	public Date getDateCreated() {
		return dateCreated;
	}

	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}

	public Set<Coin> getCoins() {
		return coins;
	}

	public void setCoins(Set<Coin> coins) {
		this.coins = coins;
	}
	
	
}
