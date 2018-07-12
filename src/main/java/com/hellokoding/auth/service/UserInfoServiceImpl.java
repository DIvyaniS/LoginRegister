package com.hellokoding.auth.service;



import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.model.UserCardInfo;
import com.hellokoding.auth.repository.UserCardInfoRepository;
import com.hellokoding.auth.repository.UserRepository;

@Service
public class UserInfoServiceImpl implements UserInfoService {
	
	private UserCardInfoRepository userCardInfoRepository;
	private UserRepository userRepository;
	public void updateBalance(String username, Long amount)
	{
		User user = userRepository.findByUsername(username);
		user.setBalance(user.getBalance()+amount);
	}
	public void addCard(String username,String card)
	{
		User user = userRepository.findByUsername(username);
		UserCardInfo ucinfo = new UserCardInfo();
		ucinfo.setCardnumber(card);
		ucinfo.setUser(user);
		
	}
	public void delCard(String card)
	{
		userCardInfoRepository.deleteByCardnumber(card);
	}

}
