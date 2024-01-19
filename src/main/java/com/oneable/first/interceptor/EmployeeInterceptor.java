package com.oneable.first.interceptor;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@Component
public class EmployeeInterceptor implements HandlerInterceptor{
	private static final Logger log=LoggerFactory.getLogger(EmployeeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		log.info("posting data running.."+request.getRequestURI()  +request.getMethod() );
		//System.out.println("posting data running.."+request.getRequestURI()+request.getMethod());
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		log.info("data posted successs "+response.getStatus());
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		if(ex!=null) {
			log.error("Error Occured"+ex.getMessage());
		}else {
			log.info("handled success");
		}
		
	}

}
