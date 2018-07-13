package com.hellokoding.auth.service;

import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.UserCardInfo;

@Service
public class AddCardServiceImpl implements AddCardService {
	@Override
	public void save(UserCardInfo userCardInfo)
	{
		userCardInfo.setBank_name(userCardInfo.getBank_name());
		userCardInfo.setCardnumber(userCardInfo.getCardnumber());
		userCardInfo.setUser(userCardInfo.getUser());
	}

}
