package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.DTO.AccountDTO;

public interface IAccountService {
	List<AccountDTO> findAll();

	AccountDTO findById(long id);

	AccountDTO save(AccountDTO dto);

	void delete(long[] ids);
}
