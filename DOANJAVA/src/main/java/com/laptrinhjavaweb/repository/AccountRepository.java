package com.laptrinhjavaweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.laptrinhjavaweb.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long>{
	AccountEntity findOneByUsernameAndStatus(String name, int status);
}
