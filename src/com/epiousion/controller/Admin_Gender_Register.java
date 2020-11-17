package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/gender/register")
public class Admin_Gender_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Admin_Gender_Register() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/jsp/admArea/Gender/struct_register.jsp").forward(request, response);
	}
}
