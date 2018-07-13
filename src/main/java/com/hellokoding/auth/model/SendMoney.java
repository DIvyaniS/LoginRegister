package com.hellokoding.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sendmoney")
public class SendMoney {
	
	private Long tId;
	private String toUser;
	private Long amount;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getTId() {
		return tId;
	}
	public String getToUser() {
		return toUser;
	}
	public void setToUser(String toUser) {
		this.toUser = toUser;
	}
	public Long getAmount() {
		return amount;
	}
	public void setAmount(Long amount) {
		this.amount = amount;
	}
	
	public void setTId(Long tId) {
		tId = tId;
	}
	public SendMoney() {
		super();
	}
	public SendMoney( String toUser, Long amount) {
		super();
		
		this.toUser = toUser;
		this.amount = amount;
	}
	

}
