package com.thinkive.dzjf.title.change.tool;

import lombok.extern.slf4j.Slf4j;

import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import com.alibaba.druid.support.logging.Log;

/**
 * @desc 启动Java项目， 并对外提供接口服务，便于多模块开发中的测试
 * @author changez@thinkive.com
 * @time 2018年10月9日 上午9:02:47
 */
@Slf4j
public class RestServer {
	 
	public static void main(String[] args) throws Exception {
		
		Server server = new Server(8080);
		ServletContextHandler handler = new ServletContextHandler();
		
		// 服务器根目录，类似于tomcat部署的项目。 完整的访问路径为ip:port/contextPath/realRequestMapping
		//ip:port/项目路径/api请求路径
		handler.setContextPath("/");
		XmlWebApplicationContext context = new XmlWebApplicationContext();
		
		//加载spring配置文件
		context.setConfigLocation("classpath:spring/spring-*.xml");
		
		//相当于web.xml中配置的ContextLoaderListener
		handler.addEventListener(new ContextLoaderListener(context));
		
		//springmvc拦截规则 相当于web.xml中配置的DispatcherServlet
		handler.addServlet(new ServletHolder(new DispatcherServlet(context)), "/*");
		server.setHandler(handler);
		server.start();
		log.info("server start...");
		server.join();
	}
}
