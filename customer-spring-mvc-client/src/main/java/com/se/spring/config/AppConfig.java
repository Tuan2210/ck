package com.se.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.se.spring")
@PropertySource({"classpath:application.properties"})
public class AppConfig implements WebMvcConfigurer{
	
	@Bean
	public ViewResolver viewResolver() {
		//InternalResourceViewResolver resolver=new InternalResourceViewResolver("/WEB-INF/view", ".jsp");
		return new InternalResourceViewResolver("/WEB-INF/view/", ".jsp"); //prefix, suffix
	}
	
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	
	//@Override
	public void addResourcehandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**")
				.addResourceLocations("/resources/");
	}
}
