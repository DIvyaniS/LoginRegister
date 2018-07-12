package com.hellokoding.auth.model;

import javax.persistence.*;

@Entity
@Table(name = "userCardinfo")
public class UserCardInfo {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO)
	private int id;
	private String bank_name;
	private String cardnumber;
	
	public UserCardInfo(int id, String bank_name, String cardnumber, User user) {
		super();
		this.id = id;
		this.bank_name = bank_name;
		this.cardnumber = cardnumber;
		this.user = user;
	}
	public UserCardInfo() {
		super();
	}


	
	
	@ManyToOne
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBank_name() {
		return bank_name;
	}

	public void setBank_name(String bank_name) {
		this.bank_name = bank_name;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	

}
