package com.thinkive.dzjf.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.thinkive.dzjf.title.change.controller.basic.bean.ClassBean;
import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.mapper.StudentMapperLazy;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/spring-*.xml")
public class StudentParamsLazy {

	@Autowired
	private StudentMapperLazy studentMapperLazy;
	
	/**
	 * @desc 懒加载
	 * @author changez@thinkive.com
	 * @time 2018年9月13日 上午11:04:00
	 */
	@Test
	public void lazyTest() {
		
		StudentBean studentBean = studentMapperLazy.queryStudentAndClassByStudentId(1);
		System.out.println("==========接口调用结束===============");
		//打印学生对象的name属性，此时还未用到classBean， 所以控制台不会打印查询sql
		System.out.println(studentBean.getName());
		
		// 打印学生所属班级信息， 此时涉及到了classBean属性， 需要加载对应的classBean属性， 所以控制台会打印查询sql
		System.out.println(studentBean.getClazz());
		ClassBean classBean = studentBean.getClazz();
		System.out.println(classBean.getName());
	}
}
