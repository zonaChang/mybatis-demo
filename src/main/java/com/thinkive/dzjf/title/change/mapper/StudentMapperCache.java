package com.thinkive.dzjf.title.change.mapper;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;

/**
 * @desc 缓存
 * @author changez@thinkive.com
 */
public interface StudentMapperCache {


	/**
	 * @desc 查询学生及其教师的信息
	 * @author changez@thinkive.com
	 * @param id
	 * @return
	 */
	StudentBean queryStudentById(Integer id);
}
