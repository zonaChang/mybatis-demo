package com.thinkive.dzjf.title.change.controller.basic.bean;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import com.thinkive.dzjf.title.change.controller.basic.bean.base.BaseBean;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper=true)
public class StudentBean extends BaseBean{

	/**  */
	private static final long serialVersionUID = -9194329388571626273L;
	
	/** 学生编号 */
	private Integer id;
	
	/** 学生姓名 */
	private String name;
	
	/** 学生对应的教师 一对多 */
	private Set<TeacherBean> teachers;
	
	/** 学生对应的班级  一对一*/
	private ClassBean clazz;
}
