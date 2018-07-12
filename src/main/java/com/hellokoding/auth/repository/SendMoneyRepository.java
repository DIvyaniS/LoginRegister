package com.hellokoding.auth.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hellokoding.auth.model.SendMoney;

public interface SendMoneyRepository extends JpaRepository<SendMoney, Long>{
	//SendMoney save(SendMoney sendmoney);
}
