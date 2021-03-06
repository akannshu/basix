package com.bankapp.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/*<context:annotation-config />*/
@Configuration
/* <context:component-scan base-package="com.bankapp" /> */
@ComponentScan(basePackages = { "com.bankapp" })
/* <tx:annotation-driven transaction-manager="transactionManager"/> */
@EnableTransactionManagement
/* <context:property-placeholder location="classpath:db.properties" /> */
@PropertySource(value = { "classpath:db.properties" })

public class AppConfig {

	@Value("${jdbc.driver}")
	private String driverName;

	@Value("${jdbc.url}")
	private String url;

	@Value("${jdbc.username}")
	private String username;

	@Value("${jdbc.password}")
	private String password;

	@Value("${jdbc.initpoolsize}")
	private Integer initialSize;

	/*
	 * <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
	 * <property name="driverClassName" value="${jdbc.driver}" /> <property
	 * name="url" value="${jdbc.url}" /> <property name="username"
	 * value="${jdbc.username}" /> <property name="password"
	 * value="${jdbc.password}" /> <property name="initialSize"
	 * value="${jdbc.initpoolsize}"></property> </bean>
	 */
	
	@Autowired
	@Bean
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setUrl(url);
		ds.setDriverClassName(driverName);
		ds.setUsername(username);
		ds.setPassword(password);
		ds.setInitialSize(initialSize);
		return ds;
	}
	
	

	/*
	 * </property> <property name="hibernateProperties"> <props> <prop
	 * key="hibernate.hbm2ddl.auto">update</prop> <prop
	 * key="hibernate.show_sql">true</prop> <prop
	 * key="hibernate.dialect">org.hibernate.dialect.MySQL57Dialect</prop> <prop
	 * key="hibernate.format_sql">true</prop> </props> </property>
	 */
	private Properties getHibernateProp() {
		Properties properties=new Properties();
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL57Dialect");
		properties.setProperty("hibernate.format_sql", "true");
		return properties;
	}

	/*
	 * <bean id="sf"
	 * class="org.springframework.orm.hibernate5.LocalSessionFactoryBean"> <property
	 * name="dataSource" ref="dataSource"/> <property name="packagesToScan"> <!--
	 * where i am using session factory --> <list>
	 * <value>com.bankapp.entities</value> </list>  </bean>
	 */
	@Autowired
	@Bean
	public LocalSessionFactoryBean getLocalSessionFactoryBean(DataSource dataSource) {
		LocalSessionFactoryBean lsfb=new LocalSessionFactoryBean();
		lsfb.setDataSource(dataSource);
		lsfb.setPackagesToScan(new String[] {"com.bankapp.entities"});
		lsfb.setHibernateProperties(getHibernateProp());
		return lsfb;
		
	}
	
	/*
	 * <bean id="transactionManager"
	 * class="org.springframework.orm.hibernate5.HibernateTransactionManager">
	 * <property name="sessionFactory" ref="sf"/> <!-- create bean for this ref!-->
	 * </bean>
	 */
	@Autowired
	@Bean
	public HibernateTransactionManager getHibernateTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager hibTxMgr=new HibernateTransactionManager();
		hibTxMgr.setSessionFactory(sessionFactory);
		return hibTxMgr;
	}
	
	

}




