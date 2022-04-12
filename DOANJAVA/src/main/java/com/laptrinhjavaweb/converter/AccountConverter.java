package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.DTO.AccountDTO;
import com.laptrinhjavaweb.entity.AccountEntity;
@Component
public class AccountConverter {
	
	public AccountDTO toDto(AccountEntity entity) {
		AccountDTO result = new AccountDTO();
		result.setId(entity.getId());
		result.setFullname(entity.getFullname());
		result.setUsername(entity.getUsername());
		result.setPassword(entity.getPassword());
		return result;
	}
	
	public AccountEntity toEntity(AccountDTO dto) {
		AccountEntity result = new AccountEntity();
		result.setFullname(dto.getFullname());
		result.setUsername(dto.getUsername());
		result.setPassword(dto.getPassword());
		return result;
	}
	public AccountEntity toEntity(AccountEntity result, AccountDTO dto) {
		result.setFullname(dto.getFullname());
		result.setUsername(dto.getUsername());
		result.setPassword(dto.getPassword());
		return result;
	}
}