package com.shiva.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PostgresSqlDatasourceConfiguration {

	@ConfigurationProperties("spring.datasource.pg")
	@Bean
	public DataSourceProperties postgresDataSourceProperties() {
		return new DataSourceProperties();

	}

	@Bean
	public DataSource postgresSqlDataSource() {

//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setUsername(postgresDataSourceProperties().getUsername());
//		dataSource.setPassword(postgresDataSourceProperties().getPassword());
//		dataSource.setUrl(postgresDataSourceProperties().getUrl());
//		dataSource.setDriverClassName(postgresDataSourceProperties().getDriverClassName());

		// return dataSource;

		// instead of the above code we can simplify the code like below
		return postgresDataSourceProperties().initializeDataSourceBuilder().build();
	}

}
