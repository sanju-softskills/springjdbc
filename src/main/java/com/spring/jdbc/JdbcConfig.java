package com.spring.jdbc;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.spring.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
    @Bean("dataSource")
	public DriverManagerDataSource getDataSource() {
      DriverManagerDataSource ds= new DriverManagerDataSource();
      ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
      ds.setUrl("jdbc:mysql://localhost:3307/springjdbc?useSSL=false");
      ds.setUsername("root");
      ds.setPassword("root");
      return ds;
	}
    @Bean("jdbcTemplate")
    public JdbcTemplate getJdbcTemplate() {
    	JdbcTemplate template=new JdbcTemplate();
    	template.setDataSource(getDataSource());
    	return template;
    }
    @Bean("studentDao")
    public StudentDaoImpl getStudentDao() {
    	StudentDaoImpl s=new StudentDaoImpl();
    	s.setTemplate(getJdbcTemplate());
    	return s;
    }
}
