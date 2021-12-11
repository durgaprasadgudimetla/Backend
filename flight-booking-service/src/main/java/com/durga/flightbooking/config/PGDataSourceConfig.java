package com.durga.flightbooking.config;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//@EntityScan("com.durga.flightbooking.dto")
//@ComponentScan("com.durga.flightbooking")
@EnableTransactionManagement
@EnableJpaRepositories(
		basePackages = "com.durga.flightbooking.flight.repository", 
		entityManagerFactoryRef = "pgEntityManagerFactory",
		transactionManagerRef = "transactionManager")
public class PGDataSourceConfig {
	
	@Primary
	@Bean(name = "pgDataSource")
	@ConfigurationProperties(prefix = "flight.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/*@Primary
	 @Bean(name = "dataSourceProperties")
	    @ConfigurationProperties("flight.datasource")
	    public DataSourceProperties dataSourceProperties() {
	        return new DataSourceProperties();
	    }
	 	@Primary
	    @Bean(name = "pgDataSource")
	    @ConfigurationProperties("flight.datasource")
	    public HikariDataSource dataSource(@Qualifier("dataSourceProperties") DataSourceProperties properties) {
	        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
	                .build();
	    }*/
	
	@Primary
	@Bean(name="pgEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("pgDataSource") DataSource datasource) {
		Map<String, Object> properties = new HashMap<>();
		//properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
		properties.put("hibernate.ddl2auto", "update");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		return builder.dataSource(datasource).properties(properties).packages("com.durga.flightbooking.model").persistenceUnit("flight")
				.build();
	}
	
	@Primary
	@Bean(name="transactionManager")
	public PlatformTransactionManager getTransactioManager(@Qualifier("pgEntityManagerFactory") EntityManagerFactory emFactory) {
		return new JpaTransactionManager(emFactory);
	}
	



}
