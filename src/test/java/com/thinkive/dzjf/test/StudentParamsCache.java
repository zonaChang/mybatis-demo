package com.thinkive.dzjf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.mapper.StudentMapperCache;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class StudentParamsCache {

	@Autowired
	private StudentMapperCache studentMapperCache;
	
	/**
	 * @desc 缓存
	 * @author changez@thinkive.com
	 */
	@Test
	//非事务范围内，每次调用都会生成新的sqlSession; 事务范围内才能共享一个sqlSession
	@Transactional
	public void cacheFirst() {
		
		StudentBean studentBeanFirst = studentMapperCache.queryStudentById(1);
		
		System.out.println("====fist load success========"+studentBeanFirst);
		
		StudentBean studentBeanSecond = studentMapperCache.queryStudentById(1);
		
		System.out.println("====second load success========"+studentBeanSecond);
		
	}
}
