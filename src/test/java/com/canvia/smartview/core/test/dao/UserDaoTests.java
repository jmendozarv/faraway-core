package com.canvia.smartview.core.test.dao;

import com.canvia.smartview.core.config.SmartViewCoreConfig;
import com.canvia.smartview.core.dao.IUserDao;
import com.canvia.smartview.core.entity.MtUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SmartViewCoreConfig.class)
@TestPropertySource(locations = "classpath:database.properties")
public class UserDaoTests {

	private static final Logger LOG = LoggerFactory.getLogger(UserDaoTests.class);
	
	@Autowired
	private IUserDao userDao;
	
	@Test
	public void findByUsername() {
		MtUser user = userDao.findByUsername("admin");
		assertNotNull(user);
		LOG.info("User founded: " + user.toString());
	}

	@Test
	public void saveUser() {
		MtUser user = new MtUser();
		user.setUsername("gpalma-caffo");
		user.setPassword("$2a$10$SKSUmFohzHiHTJ4mcGpT/.R5QaBJRHx/UPfRH7jhP4.hf.2y2zK4K");
		userDao.save(user);
		LOG.info("User saved: " + user.toString());
	}
}
