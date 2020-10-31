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

    public ValidarLogin() {}

	public void destroy() {}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		HttpServletRequest hRequest = (HttpServletRequest) request;
		HttpServletResponse hResponse= (HttpServletResponse) response;
		hRequest.getSession().removeAttribute("mensagem");


		UserDAO userDAO = new UserDB();
		User user = null;
		String destino = ("/jsp/login.jsp");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mensagem = null;
			
		if(username == null || username.equals("")){
			mensagem = "Informe o usu�rio!";
		} else if(password == null || password.equals("")) {
			mensagem = "Informe a senha do usu�rio!";
		} else {
			try{
				user = userDAO.getUserByLogin(username, password);
			} catch (Exception e) {
				mensagem = "Problema de acesso ao banco de dados!";
			}
				
			if(user != null){
				hRequest.getSession().setAttribute("user", user);
				if(user.isAdmin()){
					request.getRequestDispatcher("/admin").forward(hRequest, hResponse);
				} else {
					request.getRequestDispatcher("/listaLivros").forward(hRequest, hResponse);
				}
			} else {
				mensagem = "Usu�rio ou senha inv�lidos!";
			}
		}
				
		if(mensagem != null){
			hRequest.getSession().setAttribute("mensagem", mensagem);
			hRequest.getRequestDispatcher(destino).forward(hRequest, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {}

}
