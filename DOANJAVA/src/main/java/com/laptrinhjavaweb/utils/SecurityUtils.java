package com.laptrinhjavaweb.utils;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;

import com.laptrinhjavaweb.DTO.MyAccount;

public class SecurityUtils {
	
	public static MyAccount getPrincipal() {
		MyAccount myAccount = (MyAccount) (SecurityContextHolder.getContext()).getAuthentication().getPrincipal();
        return myAccount; //lay thong tin tu Principal(Spring security) luu vao myAccount, import myAccount ở .jsp de get thong tin
    }
	public static List<String> getAuthorities() /* code chuoi => listString*/
	{
		List<String> results= new ArrayList<>();
		@SuppressWarnings("unchecked")
		//get code push form customuserdetails then => customsucceshandler
		List<GrantedAuthority> authorities = (List<GrantedAuthority>)(SecurityContextHolder.getContext().getAuthentication().getAuthorities());
        for (GrantedAuthority authority : authorities) {
            results.add(authority.getAuthority());
        }
		return results;
	}
}
