package com.laptrinhjavaweb.api.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.laptrinhjavaweb.DTO.AccountDTO;
import com.laptrinhjavaweb.service.IAccountService;
@RestController(value = "accountAPIOfAdmin")
public class AccountAPI {

	@Autowired
	private IAccountService accountService;

	@PostMapping("/api/account")
	public AccountDTO createNew(@RequestBody AccountDTO accountDTO) {
		return accountService.save(accountDTO);

	}

	@PutMapping("/api/account")
	public AccountDTO updateNew(@RequestBody AccountDTO updateAccount) {
		return accountService.save(updateAccount);
	}

	@DeleteMapping("/api/account")
	public void deleteNew(@RequestBody long[] ids) {
		accountService.delete(ids);
	}
}
