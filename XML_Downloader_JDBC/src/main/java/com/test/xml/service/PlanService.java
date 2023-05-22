package com.test.xml.service;

import java.io.FileNotFoundException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class PlanService {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	 private DataSource dataSource;

	// select
	public byte[] select(String id) throws FileNotFoundException {
		new JdbcTemplate(dataSource);

		String sql = "SELECT xmldata FROM user.plan where idPLAN =?";
		Object[] params = new Object[] { id };
	    String user;
//		Map<String, Object> user = this.jdbcTemplate.queryForMap(sql, params);
		try {
	        user = this.jdbcTemplate.queryForObject(sql,String.class,params);
	    } catch (EmptyResultDataAccessException e) {
	        // Handle the exception, e.g., return an empty byte array
	        return new byte[0];
	    }
		
		
//		
//		BufferedInputStream streams = new BufferedInputStream(id+" xmldata.xml");
//		FileInputStream stream =new FileInputStream(streams);
		
		System.out.println(user.toString());
		
		return user.getBytes();
	}


}
