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
	
	//���ݵ�¼״̬ʵ����Դ����
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		//���������Ӧ����ת��Http���͵��������Ӧ
		HttpServletRequest req = (HttpServletRequest)request;
		HttpServletResponse resp = (HttpServletResponse)response;
		
		//��ȡ�����ַ
		String path = req.getRequestURI();
		//�ж��Ƿ��ǵ�¼��ע�������
		if(path.contains("/login.jsp") 
				|| path.contains("/register.jsp") 
				|| path.contains("/loginServlet")
				|| path.contains("/registerServlet")
				|| path.contains("/css")
				|| path.contains("/images")
				|| path.contains("/js")
				|| path.contains("/checkNameServlet")){
			//������Դ
			chain.doFilter(req, resp);
		}else{
			//���������Ƿ���У���Ҫ�����Ƿ��¼����
			//��ȡsession�е�USER����
			User user = (User)req.getSession().getAttribute("USER");
			//���user��Ϊnull����ʾ�û��Ѿ���¼����ֱ�ӷ��У������ض��򵽵�¼ҳ��
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
