package com.shiva.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class MySqlDatasourceConfiguration {

	@ConfigurationProperties("spring.datasource.mysql")
	@Bean
	public DataSourceProperties mySqlDatasourceProperties() {

		return new DataSourceProperties();
	}

	@Primary
	@Bean
	public DataSource mySqlDatasource() {

//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername(mySqlDatasourceProperties().getUsername());
//		dataSource.setPassword(mySqlDatasourceProperties().getPassword());
//		dataSource.setUrl(mySqlDatasourceProperties().getUrl());
//		dataSource.setDriverClassName(mySqlDatasourceProperties().getDriverClassName());

		//return dataSource;

		// instead of the above code we can simplify the code like below

		return mySqlDatasourceProperties().initializeDataSourceBuilder().build();

	}

}
