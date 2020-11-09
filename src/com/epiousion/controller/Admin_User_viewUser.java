package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/viewUser")
public class Admin_User_viewUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_User_viewUser() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/admArea/User/struct_userView.jsp").forward(request, response);
	}

}
