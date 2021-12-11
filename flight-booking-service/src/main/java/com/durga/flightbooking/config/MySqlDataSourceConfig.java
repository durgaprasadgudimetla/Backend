
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
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
//@EnableAutoConfiguration
@EnableJpaRepositories(basePackages = "com.durga.flightbooking.employee.repository", entityManagerFactoryRef = "mySqlEntityManagerFactory", transactionManagerRef = "mySqlTransactionManager")
public class MySqlDataSourceConfig {

	@Bean(name = "mySqlDataSource")
	@ConfigurationProperties(prefix = "employee.datasource")
	public DataSource dataSource() {
		return DataSourceBuilder.create().build();
	}
	
	/* @Bean(name = "mysqDdataSourceProperties")
	    @ConfigurationProperties(prefix = "employee.datasource")
	    public DataSourceProperties dataSourceProperties() {
	        return new DataSourceProperties();
	    }

	    @Bean(name = "mySqlDataSource")
	    @ConfigurationProperties(prefix = "employee.datasource")
	    public HikariDataSource dataSource(@Qualifier("mysqDdataSourceProperties") DataSourceProperties properties) {
	        return properties.initializeDataSourceBuilder().type(HikariDataSource.class)
	                .build();
	    }*/

	@Bean(name = "mySqlEntityManagerFactory")
	public LocalContainerEntityManagerFactoryBean entityManagerFactoryBean(EntityManagerFactoryBuilder builder,
			@Qualifier("mySqlDataSource") DataSource datasource) {
		Map<String, Object> properties = new HashMap<>();
		properties.put("hibernate.hbm2ddl.auto", "update");
		properties.put("hibernate.showSql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		return builder.dataSource(datasource).properties(properties).packages("com.durga.flightbooking.model.mysql").persistenceUnit("employee").build();
	}

	@Bean(name = "mySqlTransactionManager")
	public PlatformTransactionManager getTransactioManager(@Qualifier("mySqlEntityManagerFactory") EntityManagerFactory emFactory) {
		return new JpaTransactionManager(emFactory);
	}

}
