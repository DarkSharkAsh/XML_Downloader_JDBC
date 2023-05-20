package com.test.xml.Dao;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Dao {

	
	  @Bean
	  public DataSource dataSource() {
	    return DataSourceBuilder.create()
	        .url("jdbc:mysql://localhost:3306/user")
	        .username("root")
	        .password("admin")
	        .build();
	  }
	
	
}
