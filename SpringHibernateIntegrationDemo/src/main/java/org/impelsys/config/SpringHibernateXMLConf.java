package org.impelsys.config;

import java.util.Properties;

import org.apache.tomcat.dbcp.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;


//@EnableTransactionManagement 
//@EnableWebMvc
@Configuration
//@ImportResource({"classpath:beans.xml"})
@ComponentScan(basePackages={"org.impelsys.controller","org.impelsys.model","org.impelsys.data","org.impelsys.service","org.impelsys.data-impl"})
public class SpringHibernateXMLConf {
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("org.impelsys.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public BasicDataSource dataSource(){
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/test321");
		dataSource.setUsername("root");
		dataSource.setPassword("root");
		return dataSource;
	}
	
	@Bean
	public PlatformTransactionManager hibernateTransactionManager(){
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
	
	private final Properties hibernateProperties(){
		 Properties hibernateProperties = new Properties();
		 hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
		 hibernateProperties.setProperty("hibernate.dialect","org.hibernate.dialect.MySQL8Dialect");
		 return hibernateProperties;
	}
}