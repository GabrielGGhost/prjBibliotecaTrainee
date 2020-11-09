package com.epiousion.controller;

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

@WebServlet("/admin/viewUser")
public class Admin_User_ViewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_User_ViewUser() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userdb = new UserDB();
		User user = null;
		int id = Integer.parseInt(request.getParameter("id"));
		
		try {
			user = userdb.getUserByID(id);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("user", user);		
		request.getRequestDispatcher("/jsp/admArea/User/struct_userView.jsp").forward(request, response);
	}

}
