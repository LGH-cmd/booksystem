package com.iteima.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.iteima.system.model.User;

@WebFilter("/*")
public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("hello filter");
		
		//¹ýÂË
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		String requestURI = req.getRequestURI();
		if(requestURI.contains("/checkServlet")
				|| requestURI.contains("/loginServlet")
				|| requestURI.contains("/registerServlet")
				|| requestURI.contains("/register.jsp")
				|| requestURI.contains("/login.jsp")
				|| requestURI.contains("/css")
				|| requestURI.contains("/js")
				|| requestURI.contains("/images")) {
			
			chain.doFilter(req, resp);
		}else {
			User user = (User) req.getSession().getAttribute("USER");
			//ÊÇ·ñµÇÂ¼
			if(user!=null) {
				chain.doFilter(req, resp);
			}else {
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	
	
}
