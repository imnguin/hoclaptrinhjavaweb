package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.laptrinhjavaweb.DTO.AccountDTO;
import com.laptrinhjavaweb.converter.AccountConverter;
import com.laptrinhjavaweb.entity.AccountEntity;
import com.laptrinhjavaweb.repository.AccountRepository;
import com.laptrinhjavaweb.service.IAccountService;
@Service
	public class AccountService implements IAccountService {
		
	@Autowired
	private AccountRepository accountRepository;
	@Autowired
	private AccountConverter accountConverter;
	@Override
	public List<AccountDTO> findAll() {
		List<AccountDTO> models = new ArrayList<>();
		List<AccountEntity> entities = accountRepository.findAll();
		for (AccountEntity item : entities) {
			AccountDTO accountDTO = accountConverter.toDto(item);
			models.add(accountDTO);		 
		}
		return models;
	}
	@Override
	public AccountDTO findById(long id) {
		AccountEntity entity = accountRepository.findOne(id);
		return accountConverter.toDto(entity);
	}

	@Override		
	@Transactional
	public AccountDTO save(AccountDTO dto) {
		AccountEntity accountEntity = new AccountEntity();
		if (dto.getId() != null) {
			AccountEntity oldaccount = accountRepository.findOne(dto.getId());
			accountEntity = accountConverter.toEntity(oldaccount, dto);
		} else {
			accountEntity = accountConverter.toEntity(dto);
		}
		return accountConverter.toDto(accountRepository.save(accountEntity));
	}

	@Override

	@Transactional
	public void delete(long[] ids) {
		for (long id : ids) {
			accountRepository.delete(id);
		}
	}
	
	}
