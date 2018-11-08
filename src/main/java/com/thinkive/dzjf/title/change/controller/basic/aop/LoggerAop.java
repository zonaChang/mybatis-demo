package com.thinkive.dzjf.title.change.controller.basic.aop;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * @desc 日志记录组件
 * @author changez@thinkive.com
 * @time 2018年9月19日 上午11:52:59
 */
@Component
@Slf4j
public class LoggerAop {

    /**
     * @desc 环绕通知，记录被通知对象简单入参， 出参， 如果目标方法发生异常会进入全局异常处理方法
     * @author changez@thinkive.com
     * @time 2018年9月19日 下午12:10:09
     * @param point
     * @return
     * @throws Throwable
     */
    public Object loggerAroundMethod(ProceedingJoinPoint point) throws Throwable {

    	// 调用目标分方法
    	Object result = point.proceed();
    	
		RequestAttributes ra = RequestContextHolder.getRequestAttributes();
		ServletRequestAttributes sra = (ServletRequestAttributes) ra;
		HttpServletRequest request = sra.getRequest();
		
		//获取请求uri
		String uri = request.getRequestURI();
		StringBuffer logBuffer = new StringBuffer(500);
		logBuffer.append("uri=").append(uri).append(",");
		
		// 全局异常返回 modelAndView， 其他controller返回JsonResponse
		if(result instanceof ModelAndView) { //异常返回
			ModelAndView mv = (ModelAndView) result;
			Map<String, Object> mvValue = mv.getModel();
			logBuffer.append("content=[").append(mvValue).append("]");
		} else { //正常返回
			logBuffer.append("content=[").append(result).append("]");
		}
		log.info(logBuffer.toString());
        return result;
    }
    
}
