/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.crossover.techtrial.util;

import com.crossover.techtrial.model.Panel;
import java.util.List;
import javax.activation.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration 
@EnableTransactionManagement
@PropertySource("classpath:database.properties")
public class DBConfig {
	@Autowired
        private Environment env;	
        @Bean
	public DataSource getDataSource() {
	    BasicDataSource dataSource = new BasicDataSource();
	    dataSource.setDriverClassName(env.getProperty("database.driverClassName"));
	    dataSource.setUrl(env.getProperty("database.url"));
	    dataSource.setUsername(env.getProperty("database.username"));
	    dataSource.setPassword(env.getProperty("database.password"));
	    return (DataSource) dataSource;
	}
	@Bean
	public JdbcTemplate jdbcTemplate() {
	    return new JdbcTemplate((javax.sql.DataSource) getDataSource());
	}
	@Bean(name="transactionManager")
	public PlatformTransactionManager txManager(){
	    DataSourceTransactionManager transactionManager = new DataSourceTransactionManager((javax.sql.DataSource) getDataSource());
	    return transactionManager;
	}	
        
       
} 
