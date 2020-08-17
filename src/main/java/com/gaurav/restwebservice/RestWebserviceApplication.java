package com.gaurav.restwebservice;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.gaurav.restwebservice.multitenant.CustomRoutingDataSource;
import com.gaurav.restwebservice.multitenant.MasterService;

@SpringBootApplication
public class RestWebserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestWebserviceApplication.class, args);
	}

	@Bean
	public DataSource dataSource() {
		CustomRoutingDataSource customDataSource = new CustomRoutingDataSource();
		customDataSource.setTargetDataSources(MasterService.getDataSourceHashMap());
		return customDataSource;
	}
}
