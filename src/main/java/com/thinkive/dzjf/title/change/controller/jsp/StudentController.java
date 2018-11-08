package com.thinkive.dzjf.title.change.controller.jsp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.controller.network.JsonResponse;
import com.thinkive.dzjf.title.change.service.StudentService;
import com.thinkive.dzjf.title.change.tool.constant.Constants;
import com.thinkive.dzjf.title.change.tool.constant.PagePathEnum;

/**
 * @desc 学生类操作控制器
 * @author changez@thinkive.com
 * @time 2018年9月12日 上午10:25:23
 */
@Controller
@RequestMapping("/api/student/")
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	/**
	 * @desc 查询所有学生
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:46:36
	 * @param model
	 * @return
	 */
	@RequestMapping("queryAllStudent")
	public String queryAllStudent(Model model) {
		
		//查询所有学生
		Set<StudentBean> studentBeans = studentService.queryAllStudent();
		
		if(studentBeans == null || studentBeans.isEmpty()) {
			model.addAttribute(Constants.ERR_NO, 1);
			model.addAttribute(Constants.ERR_INFO, "未获取到数据！");
		} else {
			model.addAttribute(Constants.ERR_NO, 0);
			model.addAttribute("studentBeans", studentBeans);
		}
		
		return PagePathEnum.INDEX_PATH.getPath();
	}
	
	/**
	 * @desc 根据学生编号获取学生信息
	 * @author changez@thinkive.com
	 * @param id 学生编号
	 * @return
	 */
	@RequestMapping("queryStudentById")
	public String queryStudentById(Model model, Integer id) {
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		if(id == null || id <= 0) {
			model.addAttribute(Constants.ERR_NO, 1);
			model.addAttribute(Constants.ERR_INFO, "参数错误， id不能为空！");
		} else {
			
			//根据学生编号查询学生机器班级，教师信息
			StudentBean student = studentService.queryStudentAndTeacherAndClassById(id);
			
			if(student == null) {
				retMap.put(Constants.ERR_NO, 1);
				retMap.put(Constants.ERR_INFO, "未查询到该学生信息！");
			} else {
				retMap.put(Constants.ERR_NO, 0);
				retMap.put("students", student);
				retMap.put("name", student.getName());
			}
		}
		model.addAttribute(Constants.PAGE_DATA_KEY, retMap);
		return PagePathEnum.STUDENT_INFO_PAHT.getPath();
	}
	
}
