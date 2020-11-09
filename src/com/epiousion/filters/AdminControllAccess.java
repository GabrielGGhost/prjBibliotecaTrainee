package com.epiousion.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.jsp.PageContext;

import com.epiousion.model.User;

@WebFilter("/adminControllAccess")
public class AdminControllAccess implements Filter {

    public AdminControllAccess() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse = (HttpServletResponse) response;

		User user = (User) hRequest.getSession().getAttribute("user");
		
		if(user != null){
			chain.doFilter(hRequest, hResponse);
		} else {
			hRequest.getRequestDispatcher("/jsp/login.jsp").forward(hRequest, hResponse); 
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
