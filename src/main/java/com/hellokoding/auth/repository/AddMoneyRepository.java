package com.hellokoding.auth.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.hellokoding.auth.model.User;

public interface AddMoneyRepository extends JpaRepository<User, Long>{

	@Transactional
	  @Modifying(clearAutomatically=true)
	  @Query("update User s set s.balance=?2 where s.username=?1")
		public void update(String username,Long balance);
}
