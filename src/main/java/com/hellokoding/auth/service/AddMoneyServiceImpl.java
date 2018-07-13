package com.hellokoding.auth.service;



import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.hellokoding.auth.model.User;
import com.hellokoding.auth.repository.AddMoneyRepository;
import com.hellokoding.auth.repository.UserRepository;

@Service
@Component
public class AddMoneyServiceImpl implements AddMoneyService {
	
	private UserRepository userRepository;
	private UserService userService;
	private AddMoneyRepository addMoneyRepository;
//	@Modifying
//	@Transactional
//	@Query("UPDATE user SET balance = :balance WHERE username = :username")
//	public void update(@Param("username") String username, @Param("balance") Long balance) {}
//	public void updateBalance(String username, Long balance)
//	{
//		
//		
//		User user = userRepository.findByUsername(username);
//		balance+=user.getBalance();
//		user.setBalance(balance);
//		//userRepository.delete(user);
//		//userService.save(user);
//		
//	}
	public void update(String username, Long balance)
	{
		addMoneyRepository.update(username,balance);
	}
		

}
