package ck.config;

import java.util.Properties;

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
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@EnableTransactionManagement
@ComponentScan("ck")
@PropertySource({"classpath:persistence-mssql.properties"})
public class AppConfig implements WebMvcConfigurer{
	
	@Autowired
	private Environment env;
	
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();
		viewResolver.setPrefix("/WEB-INF/view/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	
	private int getIntProperty(String prop) {
		return Integer.parseInt(env.getProperty(prop));
	}
	
	
	private Properties getHibernateproperties() {
		Properties props=new Properties();
		props.setProperty("dialect", env.getProperty("dialect"));
		props.setProperty("show_sql", env.getProperty("show_sql"));
		return props;
	}
	
	@Bean
	public DataSource myDataSource() {
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass(env.getProperty("drive"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		dataSource.setJdbcUrl(env.getProperty("url"));
		dataSource.setUser(env.getProperty("user"));
		dataSource.setPassword(env.getProperty("password"));
		dataSource.setInitialPoolSize(getIntProperty("initPoolSize"));
		dataSource.setMinPoolSize(getIntProperty("minPoolSize"));
		dataSource.setMaxPoolSize(getIntProperty("maxPoolSize"));
		dataSource.setMaxIdleTime(getIntProperty("maxIdleTime"));
		return dataSource;
	}
	
	@Bean
	public LocalSessionFactoryBean sessionFactoryBean() {
		LocalSessionFactoryBean bean=new LocalSessionFactoryBean();
		bean.setDataSource(myDataSource());
		bean.setPackagesToScan(env.getProperty("packageToScan"));
		bean.setHibernateProperties(getHibernateproperties());
		return bean;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager session=new HibernateTransactionManager();
		session.setSessionFactory(sessionFactory);
		return session;
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
			.addResourceLocations("/resources/**");
	}
}
