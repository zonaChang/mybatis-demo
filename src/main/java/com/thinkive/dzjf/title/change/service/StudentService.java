package com.thinkive.dzjf.title.change.service;

import java.util.Set;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;

public interface StudentService {

	/**
	 * @desc 查询所有学生信息
	 * @author changez@thinkive.com
	 * @time 2018年9月18日 下午2:06:26
	 * @return
	 */
	Set<StudentBean> queryAllStudent();
	
	/**
	 * @desc 根据学生编号查询学生及其班级，教师信息
	 * @author changez@thinkive.com
	 * @time 2018年9月18日 下午2:03:35
	 * @param id
	 * @return
	 */
	StudentBean queryStudentAndTeacherAndClassById(Integer id);


}
