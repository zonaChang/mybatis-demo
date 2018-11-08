package com.thinkive.dzjf.title.change.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.mapper.StudentMapper;
import com.thinkive.dzjf.title.change.service.StudentService;

/**
 * @desc 学生类操作
 * @author changez@thinkive.com
 * @time 2018年9月18日 下午2:01:06
 */
@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentMapper studentMapper;

	/* 
	 * 查询所有学生信息
	 */
	@Override
	public Set<StudentBean> queryAllStudent() {
		
		return studentMapper.queryAllStudent();
	}
	
	/* 
	 * 根据学生编号查询学生及其班级，教师信息
	 */
	@Override
	public StudentBean queryStudentAndTeacherAndClassById(Integer id) {
		
		return studentMapper.queryStudentAndTeacherAndClassById(id);
	}

}
