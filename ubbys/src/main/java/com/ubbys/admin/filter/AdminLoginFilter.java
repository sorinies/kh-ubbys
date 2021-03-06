package com.ubbys.admin.filter;

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
import javax.servlet.http.HttpSession;

import com.ubbys.user.vo.User;

@WebFilter(filterName = "adminLoginFilter", urlPatterns = {"/admin/*"})
public class AdminLoginFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		
		String uri = req.getRequestURI();
		String contextPath = req.getContextPath(); // 최상위 주소 ex) semi
		
		String command =  uri.substring(uri.lastIndexOf("/")+1); 
		System.out.println(uri);
		if(!command.equals("adminLogin")) { // 로그인으로 들어와있지 않을 경우

			if(session.getAttribute("loginUser")== null || 
					((User)session.getAttribute("loginUser")).getUserIsAdmin().equals("N") ) {
				session.setAttribute("modalTitle", "관리자 전용");
				session.setAttribute("modalText", "관리자만 접근 가능합니다.");
				session.setAttribute("modalButtonText", "로그인");
				session.setAttribute("modalButtonLink", req.getContextPath()+"/admin/adminLogin");
				((HttpServletResponse) response).sendRedirect(req.getContextPath()+"/main" );
			} else {
				chain.doFilter(request, response);
			}

		} else {
			chain.doFilter(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
