package com.thinkive.dzjf.title.change.controller.basic.bean;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.thinkive.dzjf.title.change.controller.basic.bean.base.BaseBean;

/**
 * @desc 班级
 * @author changez@thinkive.com
 * @time 2018年9月12日 上午9:28:58
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class ClassBean extends BaseBean{

	/**  */
	private static final long serialVersionUID = 8025336991272451657L;
	
	/** 班级编号 */
	private Integer id;
	
	/** 班级名称 */
	private String name;
	
	/** 班级的学生 一对多 */
	private Set<StudentBean> students;
	
	/** 班级的教师 多对多 */
	private Set<TeacherBean> teachers;
}
