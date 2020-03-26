package com.canvia.smartview.core.test.service;

import com.canvia.smartview.core.config.SmartViewCoreConfig;
import com.canvia.smartview.core.dao.IUserDao;
import com.canvia.smartview.core.entity.MtUser;
import com.canvia.smartview.core.service.ISecurityService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SmartViewCoreConfig.class)
@TestPropertySource(locations = "classpath:database.properties")
public class SecurityServiceTests {

	private static final Logger LOG = LoggerFactory.getLogger(SecurityServiceTests.class);
	
	@Autowired
	private ISecurityService securityService;
	
	@Test
	public void saveUserRole() {
		securityService.saveUserAndRole("gpalma-caffo");
		LOG.info("User Role saved: ");
	}
}
