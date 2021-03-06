package com.laptrinhjavaweb.security;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.utils.SecurityUtils;

@Component
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{
	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	@Override
	public void handle(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException {
		String targetUrl = determineTargetUrl(authentication); //determineTargetUrl dinh tuyen url tra ve(admin or user)
		if (response.isCommitted()) {
			return;
		}
		redirectStrategy.sendRedirect(request, response, targetUrl);
	}
	
	public RedirectStrategy getRedirectStrategy() {
		return redirectStrategy;
	}

	public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
		this.redirectStrategy = redirectStrategy;
	}

	private String determineTargetUrl(Authentication authentication) {
		String url="";
		//if CODE in CustomUserDetailsService = admin => chuyen toi controller: /quan-tri/trang-chu/
		//if CODE in CustomUserDetailsService = user => chuyen toi controller: /trang-chu/
		//get role from CustomUserDetailsService => utils
		List<String> roles = SecurityUtils.getAuthorities();
		if(isAdmin(roles))
		{
			url="/quan-tri/trang-chu";
		}else if(isUser(roles))
		{
			url="/trang-chu";
		}
		return url;
	}
	//2 ham` check admin or user then push len
	private boolean isAdmin(List<String> roles)
	{	
		if(roles.contains("ADMIN"))
		{
			return true;
		}
		return false;
	}
	private boolean isUser(List<String> roles)
	{	
		if(roles.contains("USER"))
		{
			return true;
		}
		return false;
	}
}
