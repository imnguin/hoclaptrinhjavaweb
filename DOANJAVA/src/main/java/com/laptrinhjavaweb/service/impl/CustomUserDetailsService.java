package com.laptrinhjavaweb.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.DTO.MyAccount;
import com.laptrinhjavaweb.constant.SystemConstant;
import com.laptrinhjavaweb.entity.AccountEntity;
import com.laptrinhjavaweb.entity.RoleEntity;
import com.laptrinhjavaweb.repository.AccountRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private AccountRepository accountRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		AccountEntity accountEntity = accountRepository.findOneByUsernameAndStatus(username,
				SystemConstant.ACTIVE_STATUS);
		if (accountEntity == null) {
			throw new UsernameNotFoundException("user not found");

		}
		List<GrantedAuthority> authorities = new ArrayList<>();
		for (RoleEntity role : accountEntity.getRoles()) {
			authorities.add(new SimpleGrantedAuthority(role.getCode())); // code: ADMIN; USER
		}

		MyAccount myAccount = new MyAccount(accountEntity.getUsername(), accountEntity.getPassword(), true, true, true,
				true, authorities);
		myAccount.setFullname(accountEntity.getFullname());
		return myAccount;
	}

}
