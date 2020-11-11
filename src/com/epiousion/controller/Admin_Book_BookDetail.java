package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/admin/book/bookDetail")
public class Admin_Book_BookDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Book_BookDetail() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/admArea/Book/struct_bookDetail.jsp").forward(request, response); 
	}
}
