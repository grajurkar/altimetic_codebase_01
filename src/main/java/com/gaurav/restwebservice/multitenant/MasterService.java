package com.gaurav.restwebservice.multitenant;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class MasterService {
	public static Map<Object, Object> getDataSourceHashMap() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/gaurav");
		dataSource.setUsername("root");
		dataSource.setPassword("password");

		// another database used here
		DriverManagerDataSource dataSource1 = new DriverManagerDataSource();
		dataSource1.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource1.setUrl("jdbc:mysql://localhost:3306/gaurav_another_db");
		dataSource1.setUsername("root");
		dataSource1.setPassword("password");
		// another database used here
		DriverManagerDataSource dataSource2 = new DriverManagerDataSource();
		dataSource2.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource2.setUrl("jdbc:mysql://localhost:3306/restapi");
		dataSource2.setUsername("root");
		dataSource2.setPassword("password");
		HashMap hashMap = new HashMap();
		hashMap.put("tenantId1", dataSource);
		hashMap.put("tenantId2", dataSource1);
		hashMap.put("tenantId3", dataSource2);
		return hashMap;
	}
}