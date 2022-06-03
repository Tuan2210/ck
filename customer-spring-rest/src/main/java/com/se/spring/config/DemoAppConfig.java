package com.se.spring.config;

import java.beans.PropertyVetoException;
import java.util.Properties;
import java.util.logging.Logger;

//import javax.management.RuntimeErrorException;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("com.se.spring")
@PropertySource({"classpath:persistence-mssql.properties"})
public class DemoAppConfig implements WebMvcConfigurer{
	@Autowired
	private Environment environment;
	
	private Logger logger = Logger.getLogger(getClass().getName());
	
	@Bean
	public DataSource dataSource() {
		ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
		
		try {
			comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
		} catch (PropertyVetoException e) {
			throw new RuntimeException(e);
		}
		
		logger.info("jdbc.url=" +environment.getProperty("jdbc.url"));
		logger.info("jdbc.user=" +environment.getProperty("jdbc.user"));
		
		comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
		comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
		comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
		
		
		comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.minPoolSize"));
		comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.maxIdleTime"));
		
		return comboPooledDataSource;
	}

	private int getIntProperty(String propName) {
		String propVal = environment.getProperty(propName);
		
		int intProval = Integer.parseInt(propVal);
		return intProval;
	}
	
	private Properties getHibernateProperties() {
		Properties properties = new Properties();
		properties.setProperty("hibernate.dialect", environment.getProperty("hibernate.dialect"));
		properties.setProperty("hibernate.show_sql", environment.getProperty("hibernate.show_sql"));
		return properties;
	}
	
	@Bean
	public LocalSessionFactoryBean localSessionFactoryBean() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(environment.getProperty("hibernate.packagesToScan"));
		sessionFactoryBean.setHibernateProperties(getHibernateProperties());
		return sessionFactoryBean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory);
		return transactionManager;
	}
}
