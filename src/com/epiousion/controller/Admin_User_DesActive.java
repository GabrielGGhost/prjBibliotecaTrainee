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

@WebServlet("/admin/user/desActive")
public class Admin_User_DesActive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_User_DesActive() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		UserDAO userdb = new UserDB();
		
		try {
			userdb.des_active(id, status);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/user/list");
	}

}
