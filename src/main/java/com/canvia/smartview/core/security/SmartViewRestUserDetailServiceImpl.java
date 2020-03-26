package com.canvia.smartview.core.security;

import com.canvia.smartview.core.dao.IUserDao;
import com.canvia.smartview.core.entity.MtUser;
import com.canvia.smartview.core.entity.TtUserRole;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service("smartViewRestUserDetailServiceImpl")
public class SmartViewRestUserDetailServiceImpl implements UserDetailsService {

	private Logger logger = LoggerFactory.getLogger(SmartViewRestUserDetailServiceImpl.class);

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		MtUser user = userDao.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("No existe usuario '" + username + "'");
		}

		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for (TtUserRole userRole : user.getUserRoleList()) {
			authorities.add(new SimpleGrantedAuthority(userRole.getRole().getCode()));
		}

		if (authorities.isEmpty()) {
			throw new UsernameNotFoundException("Usuario '" + username + "' sin roles");
		}

		return new User(user.getUsername(), user.getPassword(), user.getEnabled(), true, true, true, authorities);
	}
}
