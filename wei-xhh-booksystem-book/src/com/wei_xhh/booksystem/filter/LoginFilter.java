package com.wei_xhh.booksystem.filter;

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

import com.wei_xhh.booksystem.model.User;

@WebFilter("/*")
public class LoginFilter implements Filter {
	
	//根据登录状态实现资源拦截
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//将请求和响应对象转成Http类型的请求和响应
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//获取请求地址
		String path = req.getRequestURI();
		//判断是否是登录或注册的请求
		if(path.contains("/login.jsp") 
				|| path.contains("/register.jsp") 
				|| path.contains("/loginServlet")
				|| path.contains("/registerServlet")
				|| path.contains("/css")
				|| path.contains("/images")
				|| path.contains("/js")
				|| path.contains("/checkNameServlet")){
			//放行资源
			chain.doFilter(req, resp);
		}else{
			//其他请求是否放行，需要根据是否登录决定
			//获取session中的USER属性
			User user = (User)req.getSession().getAttribute("USER");
			//如果user不为null，表示用户已经登录过，直接放行，否则重定向到登录页面
			if(user!=null){
				chain.doFilter(req, resp);
			}else{
				resp.sendRedirect(req.getContextPath()+"/login.jsp");
			}
		}
	}

	@Override
	public void destroy() {}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
	}
}
