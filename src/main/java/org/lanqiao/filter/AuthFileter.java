package org.lanqiao.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet Filter implementation class AuthFileter
 */
//@WebFilter(urlPatterns = {"*.do","*.jsp"})
public class AuthFileter implements Filter {

    /**
     * Default constructor. 
     */
    public AuthFileter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		// place your code here

		// pass the request along the filter chain
		//安全性问题第二种方法，使用过滤器实现---非登录用户不能访问系统的除登录界面之外的其他界面

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		if(req.getRequestURL().indexOf("login")==-1) {
			if(req.getSession().getAttribute("admin") == null)
				res.sendRedirect(req.getContextPath()+"/view/login.jsp");
		}
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
