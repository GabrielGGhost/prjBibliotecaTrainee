package com.epiousion.filters;

import java.io.IOException;
import java.sql.SQLException;

import javax.security.auth.login.LoginException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.*;
import com.epiousion.exception.EpiousionException;
import com.epiousion.exception.LoginFailedException;
import com.epiousion.model.User;

/**
 * Servlet Filter implementation class ValidarLogin
 */
@WebFilter("/validarLogin")
public class ValidarLogin implements Filter {

    public ValidarLogin() {
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
		
		UserDAO userDAO = new UserDB();
		User user = null;
		String mensagem = null;
		String destino = ((HttpServletRequest)request).getContextPath()+"/login.jsp";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse= (HttpServletResponse) response;

		if(username == null || username.equals("")){
			mensagem = "Informe o usuário!";
		} else if(password == null || password.equals("")) {
			mensagem = "Informe a senha do usuário!";
		} else {
			try{
				user = userDAO.getUserByLogin(username, password);
			} catch (Exception e) {
				mensagem = "Problema de acesso ao banco de dados!";
			}
		}
					

		
		if(user != null){	
			if(user.isAdmin() == true){
				hResponse.sendRedirect(hRequest.getContextPath() + "/admin");
			} else {
				destino = hRequest.getContextPath()+"/jsp/bookList.jsp";
			}
			hRequest.getSession().setAttribute("user", user);
		} else {
			mensagem = "Usuário ou senha inválidos!";
		}
		
		if(mensagem != null){
			hRequest.getSession().setAttribute("mensagem", mensagem);
			hResponse.sendRedirect(destino);
		}
		
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
