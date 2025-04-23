package com.tfg.services;

import org.springframework.stereotype.Service;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class CookieService {

	public void addHttpOnlyCookie(String name, String value, int maxAge, HttpServletResponse response ) {
		Cookie cookie = new Cookie(name, value);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setPath("/");
		cookie.setMaxAge(maxAge);
		cookie.setAttribute("SameSite", "None");
		
		
		response.addCookie(cookie);
		
	}
	
	
	public void deleteCookie(String name, HttpServletResponse response) {
		Cookie cookie = new Cookie(name, null);
		cookie.setHttpOnly(true);
		cookie.setSecure(true);
		cookie.setPath("/");
		cookie.setMaxAge(0);
		
		
		response.addCookie(cookie);
		
	}
}
