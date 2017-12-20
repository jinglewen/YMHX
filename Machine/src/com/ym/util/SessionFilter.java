package com.ym.util;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.ym.entity.UUserinfo;

public class SessionFilter implements HandlerInterceptor{

	@Override
	public void afterCompletion(HttpServletRequest arg0,
			HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
			Object arg2, ModelAndView arg3) throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	//设置本方法拦截
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
			Object o) throws Exception {
		// TODO Auto-generated method stub
		UUserinfo u =  (UUserinfo) request.getSession().getAttribute("userinfo");
		String requestUrl = request.getRequestURI();
		System.out.println("requestUrl:"+requestUrl);
		if(requestUrl.equals("/Machine/UserLogin.action")){
			return true;
		}else{
			if(u == null){
				response.setContentType("text/html");  
	            response.setCharacterEncoding("utf-8");  
	            PrintWriter out = response.getWriter();    
	            StringBuilder builder = new StringBuilder();    
	            builder.append("<script type=\"text/javascript\" charset=\"UTF-8\">");    
	            builder.append("alert(\"请重新登陆！\");");    
	            builder.append("top.location.href=\"login.jsp\";");    
	            builder.append("</script>");    
	            out.print(builder.toString());    
	            out.close();    
	            return false;
			}else{
				return true;
			}
		}
	}

}
