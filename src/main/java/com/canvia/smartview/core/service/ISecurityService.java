package com.canvia.smartview.core.service;

import com.canvia.smartview.core.entity.MtUser;
import com.canvia.smartview.core.entity.dto.UserDto;

public interface ISecurityService {

	UserDto findOneUserByUsernameWithRolesListWithCompanyList(String username);

	UserDto findUserByUsername(String username);

	void saveUserAndRole(String username);

}
