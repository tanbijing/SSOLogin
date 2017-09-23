package sso.sameDomain.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import sso.sameDomain.tool.LoginTool;

public class LoginFilter implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletResponse resp = (HttpServletResponse)arg1;
		HttpServletRequest req = (HttpServletRequest)arg0;
		if(LoginTool.checkLogin(resp, req)){
			LoginTool.addCookie(resp,req);
			arg2.doFilter(arg0, arg1);
		}else{
			arg1.setContentType("text/html;charset=UTF-8");
			arg1.getWriter().append("µÇÂ¼Ê§°Ü£¡");
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
