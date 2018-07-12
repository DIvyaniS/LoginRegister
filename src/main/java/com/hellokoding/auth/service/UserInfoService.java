package com.hellokoding.auth.service;

public interface UserInfoService {
	
	void updateBalance(String username, Long amount);
	void addCard(String username, String card);
	void delCard(String card);
}
