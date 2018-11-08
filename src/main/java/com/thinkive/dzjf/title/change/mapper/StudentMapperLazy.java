package com.thinkive.dzjf.title.change.mapper;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;

/**
 * @desc 懒加载
 * @author changez@thinkive.com
 */
public interface StudentMapperLazy {


	/**
	 * @desc 查询学生及其教师的信息
	 * @author changez@thinkive.com
	 * @param id
	 * @return
	 */
	StudentBean queryStudentAndClassByStudentId(Integer id);
}
