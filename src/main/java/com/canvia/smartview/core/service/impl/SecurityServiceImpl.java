package com.canvia.smartview.core.service.impl;

import com.canvia.smartview.core.dao.ICompanyDao;
import com.canvia.smartview.core.dao.IUserDao;
import com.canvia.smartview.core.dao.IUserRoleDao;
import com.canvia.smartview.core.entity.MtParameter;
import com.canvia.smartview.core.entity.MtUser;
import com.canvia.smartview.core.entity.TtUserRole;
import com.canvia.smartview.core.entity.dto.CompanyConfigDto;
import com.canvia.smartview.core.entity.dto.RoleDto;
import com.canvia.smartview.core.entity.dto.UserDto;
import com.canvia.smartview.core.service.ISecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SecurityServiceImpl implements ISecurityService {

	@Autowired
	private IUserDao userDao;

	@Autowired
	private IUserRoleDao userRoleDao;

	@Autowired
	private ICompanyDao companyDao;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public UserDto findOneUserByUsernameWithRolesListWithCompanyList(String username) {
		MtUser user = userDao.findByUsername(username);
		UserDto userDto = null;
		if (user != null){
			userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
			List<CompanyConfigDto> companyConfigDtoList = companyDao.findAllByUsername(username).stream().map(company ->
					new CompanyConfigDto(company.getCompanyId(),
							company.getCompanyName(),
							company.getMainColor(),
							company.getSecondaryColor(),
							company.getLogo(),
							company.getBackgroundImage(),
							company.getCmsSitename())).collect(Collectors.toList());
			userDto.setCompanies(companyConfigDtoList);

			List<RoleDto> roleDtoList = userRoleDao.findAllByUsername(username).stream().map(userRole ->
					new RoleDto(userRole.getRole().getCode(),
							userRole.getRole().getValue())).collect(Collectors.toList());
			userDto.setRoles(roleDtoList);
		}
		return userDto;
	}

	@Override
	public UserDto findUserByUsername(String username) {
		MtUser user = userDao.findByUsername(username);
		UserDto userDto = null;
		if (user != null){
			userDto = new UserDto();
			userDto.setUserId(user.getUserId());
			userDto.setUsername(user.getUsername());
			userDto.setPassword(user.getPassword());
		}
		return userDto;
	}

	@Override
	@Transactional
	public void saveUserAndRole(String username) {
		MtUser user = new MtUser();
		user.setUsername("RRR");
		user.setPassword("$2a$10$SKSUmFohzHiHTJ4mcGpT/.R5QaBJRHx/UPfRH7jhP4.hf.2y2zK4K");
		userDao.save(user);

		MtParameter parameter = new MtParameter();
		parameter.setParameterId(7L);

		user.setUserId(10L);
		TtUserRole userRole = new TtUserRole();
		userRole.setUser(user);
		userRole.setRole(parameter);

		userRoleDao.save(userRole);
	}

}
