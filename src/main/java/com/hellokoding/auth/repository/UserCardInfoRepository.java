package com.hellokoding.auth.repository;

import com.hellokoding.auth.model.UserCardInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCardInfoRepository extends JpaRepository<UserCardInfo, Long> {
    //List<int> findBy
	void deleteByCardnumber(String cardnumber);
	
}
