package com.canvia.smartview.core.security;

import com.canvia.smartview.core.entity.dto.UserDto;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import java.io.IOException;
import java.util.Collection;
import java.util.Map;

public interface JWTService {

	Map <String, Object> create(Authentication auth) throws IOException;
	boolean validate(String token);
	Claims getClaims(String token);
	String getUsername(String token);
	Collection<GrantedAuthority> getRoles(String token) throws IOException;
	String resolve(String token);
	UserDto getUserDto(String token) throws IOException;
	UserDto getUserDto();
}
