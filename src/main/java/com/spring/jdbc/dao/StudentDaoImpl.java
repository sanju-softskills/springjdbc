package com.spring.jdbc.dao;

import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

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
	public Student getstudent(int studentId) {
		String query ="select * from student where id=?";
		RowMapper<Student> rowMapper= new RowMapperImpl();
		Student student = this.template.queryForObject(query, rowMapper,studentId);
		return student;
	}
	public List<Student> getAllstudent() {
		 String query ="select * from student";
		 RowMapper<Student> rowMapper= new RowMapperImpl();
		List<Student> students= this.template.query(query, rowMapper);
		return students;
	}
 
}
