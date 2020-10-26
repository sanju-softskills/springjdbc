package com.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PRogram started..." );
        ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config1.xml");
        JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
        String q="insert into student(id,name,city) values(?,?,?)";
        int result=template.update(q,118,"radha","noida");
        System.out.println(result); 
    }
}
