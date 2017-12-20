package com.ym.util;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 * 
 * @author Administrator
 *登录过滤
 */
public class LoginFilters implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chains)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest httpRequest=(HttpServletRequest)request;
        HttpServletResponse httpResponse=(HttpServletResponse)response;
        HttpSession session=httpRequest.getSession();
        //System.out.println("输出的是："+session.getAttribute("userinfo"));
        if(session.getAttribute("userinfo")!=null){
        	
            chains.doFilter(request, response);
            //System.out.println("请求成功");
        }
        else{
            httpResponse.sendRedirect(httpRequest.getContextPath()+"/login.jsp");
           // System.out.println("请求未通过");
        }
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
	
		
	 
}
