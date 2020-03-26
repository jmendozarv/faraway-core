package com.canvia.smartview.core.security;

import com.canvia.smartview.core.entity.dto.UserDto;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public class SmartViewAuthentication extends UsernamePasswordAuthenticationToken {

	private static final long serialVersionUID = 1L;
	private UserDto userDto;

	public SmartViewAuthentication(Object principal, Object credentials) {
		super(principal, credentials);
	}

	public SmartViewAuthentication(Object principal, Object credentials,
                                   Collection<? extends GrantedAuthority> authorities, UserDto userDto) {
		super(principal, credentials, authorities);
		this.userDto = userDto;
	}

	public UserDto getUserDto() {
		return userDto;
	}

}
