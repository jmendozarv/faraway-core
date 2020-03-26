package com.canvia.smartview.core.test.dao;

import com.canvia.smartview.core.config.SmartViewCoreConfig;
import com.canvia.smartview.core.dao.IParameterDao;
import com.canvia.smartview.core.dao.IUserDao;
import com.canvia.smartview.core.entity.MtParameter;
import com.canvia.smartview.core.entity.MtUser;
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
public class ParameterDaoTests {

	private static final Logger LOG = LoggerFactory.getLogger(ParameterDaoTests.class);
	
	@Autowired
	private IParameterDao parameterDao;
	
	@Test
	public void saveParameter() {
		MtParameter parameter = new MtParameter();
		parameter.setParent_group("ROLES");
		parameter.setCode("ROLE_ADMIN");
		parameter.setValue("ADMINISTRADOR");
		parameter.setSort(1);
		parameter.setDescription("Administrador del Sistema");
		parameterDao.save(parameter);
		LOG.info("Parameter saved: " + parameter.toString());
	}

}
