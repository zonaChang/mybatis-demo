package com.thinkive.dzjf.title.change.controller.network;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

/**
 * @desc 响应前端请求的结果集
 * @author changez@thinkive.com
 * @time 2018年9月19日 上午9:42:51
 */
public class JsonResponse extends HashMap<String, Object> {
	
	private static final long serialVersionUID = -838639029415556116L;
	
	/** 错误号： 0：表示调用成功， 其他调用失败 */
	private static final String CODE_KEY = "errNo";
	
    /** 提示信息 */
    private static final String MESSAGE_KEY = "errInfo";
    
    /** 结果集key */
    public static final String DATA_KEY = "result";

    public JsonResponse(int code, String msg) {
        super.put(CODE_KEY, code);
        super.put(MESSAGE_KEY, msg == null ? "" : msg);
    }

    /*
     * the put method is disabled, please use add to place it;
     * put方法已禁用， 请使用add方法
     */
    @Deprecated
    @Override
    public Object put(String key, Object value) {
    	
    	throw new RuntimeException("the put method is disabled, please use add to place it");
    }
    
    /* 
     * the putAll method is disabled, please use add to place it
     * putAll方法已禁用， 请使用add方法
     */
    @Override
    @Deprecated
    public void putAll(Map<? extends String, ? extends Object> m) {
    	
    	//the put method is disabled, please use add to place it;
    	throw new RuntimeException("the putAll method is disabled, please use add to place it");
    }
    
	/**
	 * @desc 封装返回值。该方法只能调用一次，将所有的结果封装为map一次性存放。
	 * @author changez@thinkive.com
	 * @time 2018年9月19日 上午9:21:54
	 * @param value 返回值map结果集
	 * @return
	 */
	public JsonResponse add(Map<String, Object> value) {
		
		// map中的三个key， errNo, errInfo, result
		if(this.size() >= 3) {
			throw new RuntimeException("该方法仅能调用一次！请将所有的结果封装为map一次性存放！");
		}
        super.put(DATA_KEY, value);
        return this;
    }

    public static JsonResponse success() {
        return new JsonResponse(0, "调用成功");
    }
    
    /**
     * @desc 调用成功（请求成功 and 业务逻辑成功 ）
     * @author changez@thinkive.com
     * @time 2018年9月19日 上午9:44:52
     * @param message
     * @return
     */
    public static JsonResponse success(String message) {
    	if(StringUtils.isBlank(message)) {
    		return success();
    	}
    	return new JsonResponse(0, message);
    }

    /**
     * @desc  调用失败（请求失败 or 业务逻辑有误 ）
     * @author changez@thinkive.com
     * @time 2018年9月19日 上午9:45:36
     * @param code 错误号
     * @param message 提示信息
     * @return
     */
    public static JsonResponse failure(int code, String message) {
        return new JsonResponse(code, message);
    }

    public static JsonResponse failure(String message) {
        return failure(-10000, message);
    }
}
