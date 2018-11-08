package com.thinkive.dzjf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.mapper.StudentMapperParams;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class StudentParamsTest {

	@Autowired
	private StudentMapperParams studentMapperParams;
	
	/**
	 * @desc 一个参数查询
	 * @author changez@thinkive.com
	 * @time 2018年9月13日 上午11:04:00
	 */
	@Test
	public void oneParam() {
		System.out.println(studentMapperParams.queryStudentById(2));
	}
	
	@Test
	public void oneParamLike() {
		
		//模糊查询很容易想到用$然后拼接%%， 这样会有sql注入的问题
		// 使用$时， 只能使用value字符串${value} 其他的不行
		// sql注入
		String sqlParmas = "anyStr'or 1=1 or 'a' like '";
//		String sqlParmas = "a";
		System.out.println(studentMapperParams.queryStudentLikeName(sqlParmas));
		
		//使用数据库函数，“实现”模糊查询， 并使用#来防止sql注入
		System.out.println(studentMapperParams.queryStudentLikeNameSecurity(sqlParmas));
	}
	
	/**
	 * @desc 根据对象的属性查询
	 * @author changez@thinkive.com
	 */
	@Test
	public void oneParamObj() {
		StudentBean studentBean = new StudentBean();
		studentBean.setId(1);
		studentBean.setName("Carl");
		System.out.println(studentMapperParams.queryStudentByObj(studentBean));
	}
	
	/**
	 * @desc 通过参数顺序绑定
	 * @funcNo 
	 * @author changez@thinkive.com
	 * @time 2018年9月13日 上午11:03:12
	 */
	@Test
	public void moreParams1() {
		System.out.println(studentMapperParams.queryStudentByMoreParams1(1, "Carl"));
	}
	
	/**
	 * @desc 通过参数名绑定
	 * @author changez@thinkive.com
	 */
	@Test
	public void moreParams2() {
		System.out.println(studentMapperParams.queryStudentByMoreParamsAlias(1, "Carl"));
	}
}
