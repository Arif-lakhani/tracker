package com.tracker;


import java.util.Properties;


import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {
	@Bean
	public LocalContainerEntityManagerFactoryBean emf() {
		LocalContainerEntityManagerFactoryBean emf= new LocalContainerEntityManagerFactoryBean();
		emf.setDataSource(datasoruce());
		emf.setJpaProperties(jpaproperties());
		emf.setPackagesToScan("com.tracker.Entity");
		emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
		return emf;
	}
	@Bean
	public DataSource datasoruce() {
		DriverManagerDataSource d= new DriverManagerDataSource();
		d.setDriverClassName("com.mysql.cj.jdbc.Driver");
		d.setUrl("jdbc:mysql://localhost:3306/mocker");
		d.setPassword("arif123");
		d.setUsername("root");
		return d;	
	}
	@Bean
	public PlatformTransactionManager txnmanager(EntityManagerFactory emf) {
		JpaTransactionManager txn = new JpaTransactionManager() ;
		
		return txn;
	}
	private Properties jpaproperties() {
		Properties props = new Properties();
		props.put("hibernate.show_sql", "true");
		props.put("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
		props.put("hibernate.hbm2ddl.auto", "create");
		return props;

	}
	

}
