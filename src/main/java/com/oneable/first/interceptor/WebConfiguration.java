package com.oneable.first.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
public class WebConfiguration implements WebMvcConfigurer{
@Autowired
	private EmployeeInterceptor inter;

@Override
public void addInterceptors(InterceptorRegistry registry) {
	// TODO Auto-generated method stub
	registry.addInterceptor(inter);
}
	
	
}
