package com.thinkive.dzjf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thinkive.dzjf.title.change.controller.jsp.StudentController;
import com.thinkive.dzjf.title.change.mapper.StudentMapper;
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class StudentTest {

	@Autowired
	private StudentController studentController;
	
	@Autowired
	private StudentMapper studentMapper;
	
	@Test
	public void queryStudentAndClazzById() {
		Integer id = 1;
		System.out.println(studentMapper.queryStudentAndClazzById(id));
	}
	@Test
	public void queryStudentAndTeacherAndClassById() {
		Integer id = 1;
		System.out.println(studentMapper.queryStudentAndTeacherAndClassById(id));
	}
}
