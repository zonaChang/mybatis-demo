package com.thinkive.dzjf.test;

import java.util.HashMap;

import org.junit.Test;

import com.thinkive.dzjf.title.change.controller.network.JsonResponse;

/**
 * @desc JsonResponse代码测试
 * @author changez@thinkive.com
 * @time 2018年9月18日 下午4:50:32
 */
public class JsonResponseTest {

	/**
	 * @desc 测试put方法， 抛异常
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:54:35
	 */
	@Test
	public void invokePut() {
		JsonResponse.success().put("xx", "xx");
	}
	
	/**
	 * @desc 测试putAll方法， 抛异常
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:55:00
	 */
	@Test
	public void invokePutAll() {
		JsonResponse.success().putAll(new HashMap<String, Object>());
	}
	
	/**
	 * @desc 调用一次add方法，可以正常调用
	 * @funcNo 
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:55:11
	 */
	@Test
	public void invokeAdd() {
		JsonResponse.success().add(new HashMap<String, Object>());
	}
	
	/**
	 * @desc 调用多次add方法， 抛异常
	 * @funcNo 
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:55:28
	 */
	@Test
	public void invokeAddMore() {
		
		JsonResponse jsonResponse = JsonResponse.success();
		jsonResponse.add(new HashMap<String, Object>());
		
		//测试多次调用add方法
		jsonResponse.add(new HashMap<String, Object>());
	}
	
}
