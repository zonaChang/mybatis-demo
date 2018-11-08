package com.thinkive.dzjf.title.change.mapper;

import java.util.Set;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;

/**
 * @desc 一对一， 一对多 配置
 * @author changez@thinkive.com
 * @time 2018年9月13日 上午8:47:54
 */
public interface StudentMapper {

	/**
	 * @desc 查询学生属性
	 * @author changez@thinkive.com
	 * @time 2018年9月12日 下午3:23:39
	 * @param id
	 * @return
	 */
	StudentBean queryStudentById(Integer id);
	
	/**
	 * @desc 查询学生及其班级属性 一对一
	 * @author changez@thinkive.com
	 * @time 2018年9月12日 下午3:23:50
	 * @param id
	 * @return
	 */
	StudentBean queryStudentAndClazzById(Integer id);

	/**
	 * @desc 查询学生及其班级,教师属性 一对一， 一对多
	 * @author changez@thinkive.com
	 * @time 2018年9月12日 下午5:16:57
	 * @param id
	 * @return
	 */
	StudentBean queryStudentAndTeacherAndClassById(Integer id);

	/**
	 * @desc 查询所有学生
	 * @author changez@thinkive.com
	 * @time 2018年9月12日 下午5:17:07
	 * @return
	 */
	Set<StudentBean> queryAllStudent();
	
}
