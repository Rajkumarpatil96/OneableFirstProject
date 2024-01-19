package com.oneable.first;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
@EnableAutoConfiguration(exclude = DataSourceAutoConfiguration.class)
@SpringBootApplication
public class SpringOneAbleFirstApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringOneAbleFirstApplication.class, args);
	}

}
