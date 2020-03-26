package com.canvia.smartview.core.test.dao;

import com.canvia.smartview.core.config.SmartViewCoreConfig;
import com.canvia.smartview.core.dao.IUserRoleDao;
import com.canvia.smartview.core.entity.MtUser;
import com.canvia.smartview.core.entity.TtUserRole;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SmartViewCoreConfig.class)
@TestPropertySource(locations = "classpath:database.properties")
public class UserRoleDaoTests {

	private static final Logger LOG = LoggerFactory.getLogger(UserRoleDaoTests.class);
	
	@Autowired
	private IUserRoleDao userRoleDao;
	
	@Test
	public void findAllByUsername() {
		List<TtUserRole> userRoleList = userRoleDao.findAllByUsername("gpalma-caffo");
		assertNotNull(userRoleList);
		for (TtUserRole userRole : userRoleList) {
			LOG.info("UserRole founded: " + userRole.getRole().getCode() + ", " + userRole.getRole().getValue());
		}
	}

}
