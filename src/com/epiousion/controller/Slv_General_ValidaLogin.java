package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.model.User;

@WebServlet("/validaLogin")
public class Slv_General_ValidaLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_General_ValidaLogin() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processAction(request, response);
	}

	private void processAction(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
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
			mensagem = "Informe o usuário!";
		} else if(password == null || password.equals("")) {
			mensagem = "Informe a senha do usuário!";
		} else {
			try{
				user = userDAO.getUserByLogin(username, password);
			} catch (Exception e) {
				mensagem = "Problema de acesso ao banco de dados!";
			}
				
			if(user != null){
				hRequest.getSession().setAttribute("user", user);
				if(user.isAdmin()){
					hResponse.sendRedirect(hRequest.getContextPath() + "/admin");
				} else {
					hResponse.sendRedirect(hRequest.getContextPath() + "/listaLivros");
				}
			} else {
				mensagem = "Usuário ou senha inválidos!";
			}
		}
				
		if(mensagem != null){
			hRequest.getSession().setAttribute("mensagem", mensagem);
			hRequest.getRequestDispatcher(destino).forward(hRequest, response);
		}
		
	}

}
