package com.canvia.smartview.core.config;

import java.util.Optional;
import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"com.canvia.smartview.core.dao","com.canvia.smartview.core.service","com.canvia.smartview.core.security"})
@EnableJpaRepositories(
		basePackages = {"com.canvia.smartview.core.dao"},
        entityManagerFactoryRef = "smartViewEntityManagerFactory",
        transactionManagerRef = "smartViewTransactionManager"
)
@EnableTransactionManagement
public class SmartViewCoreConfig {

	@Autowired
	private Environment env;
	
    @Bean
    public DataSource smartViewDataSource() {
		return DataSourceBuilder.create()
        			.driverClassName(env.getProperty("spring.datasource.driver-class-name"))
        			.url(env.getProperty("spring.datasource.url"))
        			.username(env.getProperty("spring.datasource.username"))
        			.password(env.getProperty("spring.datasource.password"))
        			.build();
    }
    
    @Bean
    @Qualifier("smartViewTransactionManager")
    public PlatformTransactionManager smartViewTransactionManager()
    {
        EntityManagerFactory factory = smartViewEntityManagerFactory().getObject();
        return new JpaTransactionManager(factory);
    }

    @Bean
    @Qualifier("smartViewEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean smartViewEntityManagerFactory()
    {
    	LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setDataSource(smartViewDataSource());
        factory.setPackagesToScan(new String[]{"com.canvia.smartview.core.entity", "com.canvia.smartview.core.entity.id"});
        factory.setJpaVendorAdapter(new HibernateJpaVendorAdapter());

        Properties jpaProperties = new Properties();
        
        Optional<String> property = Optional.ofNullable(env.getProperty("spring.jpa.hibernate.ddl-auto"));
        property.ifPresent(value -> jpaProperties.put("hibernate.hbm2ddl.auto", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.persistent.database-platform"));
        property.ifPresent(value -> jpaProperties.put("hibernate.dialect", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_size"));
        property.ifPresent(value -> jpaProperties.put("hibernate.jdbc.batch_size", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.order_inserts"));
        property.ifPresent(value -> jpaProperties.put("hibernate.order_inserts", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.order_updates"));
        property.ifPresent(value -> jpaProperties.put("hibernate.order_updates", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.jdbc.batch_versioned_data"));
        property.ifPresent(value -> jpaProperties.put("hibernate.jdbc.batch_versioned_data", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.temp.use_jdbc_metadata_defaults"));
        property.ifPresent(value -> jpaProperties.put("hibernate.temp.use_jdbc_metadata_defaults", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.generate_statistics"));
        property.ifPresent(value -> jpaProperties.put("hibernate.generate_statistics", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.id.new_generator_mappings"));
        property.ifPresent(value -> jpaProperties.put("hibernate.id.new_generator_mappings", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.cache.use_second_level_cache"));
        property.ifPresent(value -> jpaProperties.put("hibernate.cache.use_second_level_cache", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.globally_quoted_identifiers"));
        property.ifPresent(value -> jpaProperties.put("hibernate.globally_quoted_identifiers", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.show_sql"));
        property.ifPresent(value -> jpaProperties.put("hibernate.show_sql", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.use_sql_comments"));
        property.ifPresent(value -> jpaProperties.put("hibernate.use_sql_comments", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        property.ifPresent(value -> jpaProperties.put("hibernate.format_sql", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.properties.hibernate.type"));
        property.ifPresent(value -> jpaProperties.put("hibernate.type", value));
        
        property = Optional.ofNullable(env.getProperty("spring.jpa.hibernate.naming.physical-strategy"));
        property.ifPresent(value -> jpaProperties.put("hibernate.naming.physical-strategy", value));
        
        factory.setJpaProperties(jpaProperties);
        
        return factory;
    }
    
}
