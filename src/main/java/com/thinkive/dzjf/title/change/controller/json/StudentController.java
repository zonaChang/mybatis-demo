package com.thinkive.dzjf.title.change.controller.json;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.thinkive.dzjf.title.change.controller.basic.bean.StudentBean;
import com.thinkive.dzjf.title.change.controller.network.JsonResponse;
import com.thinkive.dzjf.title.change.service.StudentService;

/**
 * @desc 学生类操作控制器
 * @author changez@thinkive.com
 * @time 2018年9月12日 上午10:25:23
 */
@RestController("jsonStudentController")
@RequestMapping("/api/student/json/")
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
	public JsonResponse queryAllStudent(Model model) {
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		JsonResponse jsonResponse = null;
		
		//查询所有学生
		Set<StudentBean> studentBeans = studentService.queryAllStudent();
		
		if(studentBeans == null || studentBeans.isEmpty()) {
			jsonResponse = JsonResponse.failure("未获取到数据！");
		} else {
			retMap.put("studentBeans", studentBeans);
			jsonResponse = JsonResponse.success().add(retMap);
		}
		
		return jsonResponse;
	}
	
	/**
	 * @desc 根据学生编号获取学生信息
	 * @author changez@thinkive.com
	 * @param id 学生编号
	 * @return
	 */
	@RequestMapping("queryStudentById")
	public JsonResponse queryStudentById(Model model, Integer id) {
		
		Map<String, Object> retMap = new HashMap<String, Object>();
		JsonResponse jsonResponse = null;
		
		if(id == null || id <= 0) {
			jsonResponse = JsonResponse.failure("参数错误， id不能为空！");
		} else {
			
			//根据学生编号查询学生机器班级，教师信息
			StudentBean student = studentService.queryStudentAndTeacherAndClassById(id);
			if(student == null) {
				retMap.put("hasData", false);
				jsonResponse = JsonResponse.success("未查询到该学生信息！");
			} else {
				retMap.put("hasData", true);
				retMap.put("student", student);
				jsonResponse = JsonResponse.success().add(retMap);
			}
		}
		return jsonResponse;
	}
	
}
