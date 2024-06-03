package com.shiva.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableTransactionManagement
@Configuration
@EnableJpaRepositories(
//		basePackages = "com.shiva.productrepository",
		basePackages = "com.shiva.productrepository",
		entityManagerFactoryRef = "mySqlEntityManagerFactoryBean",
		transactionManagerRef = "mySqlTransactionManager"
		)
public class MySQLJPAConfiguration {

	@Bean
	LocalContainerEntityManagerFactoryBean mySqlEntityManagerFactoryBean(
			EntityManagerFactoryBuilder entityManagerFactoryBuilder,
			@Qualifier("mySqlDatasource") DataSource dataSource) {

		return entityManagerFactoryBuilder
				.dataSource(dataSource)
				.packages("com.shiva.productentity")
				.build();

	}
	
	@Bean
	PlatformTransactionManager mySqlTransactionManager(@Qualifier("mySqlEntityManagerFactoryBean") LocalContainerEntityManagerFactoryBean embf) {
		
		return new JpaTransactionManager(embf.getObject());
	}
}
