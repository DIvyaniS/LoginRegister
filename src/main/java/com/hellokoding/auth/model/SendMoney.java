package com.hellokoding.auth.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sendmoney")
public class SendMoney {
	public SendMoney() {
		super();
	}
	public SendMoney( String toUser, Long amount) {
		super();
		
		this.toUser = toUser;
		this.amount = amount;
	}
	private int Tid;
	
	
	private String toUser;
	private Long amount;
	
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
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getTid() {
		return Tid;
	}
	public void setTid(int tid) {
		Tid = tid;
	}
	

}
