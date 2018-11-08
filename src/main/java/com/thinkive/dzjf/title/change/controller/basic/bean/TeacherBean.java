package com.thinkive.dzjf.title.change.controller.basic.bean;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @desc 
 * @author changez@thinkive.com
 * @time 2018年9月12日 上午9:34:39
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class TeacherBean {

	/** 教师编号 */
	private Integer id;
	/** 教师姓名 */
	private String name;
	
	/** 教师对应的班级 一对多 */
	private Set<ClassBean> clazzs;
}
