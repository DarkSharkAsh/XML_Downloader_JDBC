package com.test.xml.service;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;


@Service
public class PlanService {
	
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	 private DataSource dataSource;

	// select
	public byte[] select(int id) throws FileNotFoundException {
		new JdbcTemplate(dataSource);

		String sql = "SELECT xmldata FROM user.plan where idPLAN =?";
		Object[] params = new Object[] { id };
//		Map<String, Object> user = this.jdbcTemplate.queryForMap(sql, params);
		String user = this.jdbcTemplate.queryForObject(sql, params,String.class);
		
//		
//		BufferedInputStream streams = new BufferedInputStream(id+" xmldata.xml");
//		FileInputStream stream =new FileInputStream(streams);
		
		System.out.println(user.toString());
		
		return user.getBytes();
	}


}
