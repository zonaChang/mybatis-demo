package com.thinkive.dzjf.title.change.controller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import com.thinkive.dzjf.title.change.controller.network.JsonResponse;

/**
 * @desc 全局异常处理
 * @author changez@thinkive.com
 * @time 2018年9月18日 上午11:55:55
 */
@Slf4j
@Component
public class InvokeException implements HandlerExceptionResolver{

    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) {
    	
        String errMsg = e.getMessage();
        ModelAndView mv = new ModelAndView(new MappingJackson2JsonView()).addAllObjects(JsonResponse.failure(errMsg));

        //记录异常信息， 尽量窄化，可以 添加uri，可以唯一标识该请求的字段等， 便于问题追踪
        log.error("".concat(request.getRequestURI().concat(": errInfo=").concat(errMsg)), e);
        return mv;
    }
}
