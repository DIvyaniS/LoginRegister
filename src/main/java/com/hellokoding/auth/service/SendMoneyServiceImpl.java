package com.hellokoding.auth.service;

import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.SendMoney;
import com.hellokoding.auth.repository.SendMoneyRepository;
@Service
public class SendMoneyServiceImpl implements SendMoneyService{
		
		private SendMoneyRepository sendMoneyRepository;
		@Override
		public void save(SendMoney sendMoney)
		{
			//sendMoneyRepository.save(sendMoney);
			sendMoney.setAmount(sendMoney.getAmount());
			sendMoney.setToUser(sendMoney.getToUser());
			sendMoneyRepository.save(sendMoney);
		}

}
