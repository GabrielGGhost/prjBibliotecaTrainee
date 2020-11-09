package com.epiousion.controller.ajax;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.User;

/**
 * Servlet implementation class AdminUser_registerUser
 */
@WebServlet("/admin/saveUser")
public class Admin_User_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_User_Register() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			registerUser(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			registerUser(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws EpiousionException {
		
		String name = request.getParameter("name");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		boolean admin = Boolean.parseBoolean((request.getParameter("admin")));
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		
		User user = new User(name, username, password, admin, email, phone);
		UserDAO userdb = new UserDB();
		
		userdb.save(user);
		System.out.println("Usuário cadastrado");
	}

}
