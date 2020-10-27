package com.spring.jdbc;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.dao.StudentDao;
import com.spring.jdbc.entites.Student;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "PRogram started..." );
      //  ApplicationContext context = new ClassPathXmlApplicationContext("com/spring/jdbc/config1.xml");
       ApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		/*
		 * JdbcTemplate template = context.getBean("jdbcTemplate",JdbcTemplate.class);
		 * String q="insert into student(id,name,city) values(?,?,?)"; int
		 * result=template.update(q,118,"radha","noida"); System.out.println(result);
		 */
        StudentDao st = context.getBean("studentDao",StudentDao.class);
        Student s = new Student();
//        s.setId(11);
//        s.setName("qwerty");
       // st.insert(s);
      // st.change(s);
     // int x= st.delete(11);
      // s= st.getstudent(111);
      
      List<Student> ss=  st.getAllstudent();
      System.out.println(ss);
       
    }
}
