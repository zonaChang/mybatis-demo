package com.thinkive.dzjf.title.change.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import lombok.extern.slf4j.Slf4j;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.thinkive.dzjf.title.change.service.InitDataService;

/**
 * Servlet implementation class InitData
 */
/**
 * @desc 项目必备条件检测
 * @author changez@thinkive.com
 * @time 2018年10月9日 上午8:59:22
 */
@Slf4j
public class InitData extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init() throws ServletException {
		
		//从上下文中获取spring管理的bean
		ApplicationContext applicationContext = WebApplicationContextUtils.getWebApplicationContext(getServletContext());
		InitDataService initDataService = (InitDataService) applicationContext.getBean("initDataService");
		try {
			int count = initDataService.queryDataCount();
			
			//根据具体情况确定需要初始化数据的条件
			if(count == 0) {
				log.warn("init data...");
			}
		} catch (Exception e) {
			e.printStackTrace();
			// 中断服务器启动
			throw new RuntimeException("初始化数据检测失败，请检查表结构, errInfo=".concat(e.getMessage()));
		}
	}
}
