package com.thinkive.dzjf.title.change.mapper;

import java.util.Set;

import org.apache.ibatis.annotations.Param;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;

/**
 * @desc 参数配置
 * @author changez@thinkive.com
 * @time 2018年9月13日 上午8:48:21
 */
public interface StudentMapperParams {

	/**
	 * @desc 根据一个参数查询
	 * @author changez@thinkive.com
	 * @param id
	 * @return
	 */
	StudentBean queryStudentById(Integer id);
	
	/**
	 * @desc 根据一个参数模糊查询,使用${}有sql注入风险
	 * @author changez@thinkive.com
	 * @param name
	 * @return
	 */
	Set<StudentBean> queryStudentLikeName(String name);
	
	/**
	 * @desc 根据一个参数模糊查询,使用#{}  和 数据库的函数组合使用
	 * @author changez@thinkive.com
	 * @param name
	 * @return
	 */
	Set<StudentBean> queryStudentLikeNameSecurity(String name);
	
	/**
	 * @desc 根据bean对象查询 使用bean的多个参数
	 * @author changez@thinkive.com
	 * @param bean
	 * @return
	 */
	StudentBean queryStudentByObj(StudentBean bean);
	
	/**
	 * @desc 根据多个参数查询 使用参数顺序0， 1，2(数字从0开始) , param1, param2(数字从1开始)
	 * @author changez@thinkive.com
	 * @param id
	 * @param name
	 * @return
	 */
	StudentBean queryStudentByMoreParams1(Integer id, String name);
	
	/**
	 * @desc 根据多个参数查询, 绑定变量
	 * @author changez@thinkive.com
	 * @param id
	 * @param name
	 * @return
	 */
	StudentBean queryStudentByMoreParamsAlias(@Param("idx") Integer id,@Param("namex") String name);
	
}
