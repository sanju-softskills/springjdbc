package com.spring.jdbc.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.spring.jdbc.entites.Student;

public class StudentDaoImpl implements StudentDao{
    private JdbcTemplate template;
	public JdbcTemplate getTemplate() {
		return template;
	}
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	public int insert(Student student) {
		String query= "insert into student(id,name,city) values(?,?,?)";
		int result =this.template.update(query,student.getId(),student.getName(),student.getCity());
		return result;
	}
	public int change(Student student) {
		String query= "UPDATE student SET name =? WHERE id =?";
		 Object[] inputs = new Object[] {student.getName(),student.getId()};
		int result =this.template.update(query,inputs);
		return result;
	}
	public int delete(int studentId) {
		String query= "delete from student where id=?";
		int result= this.template.update(query,studentId);
		return result;
	}
 
}
