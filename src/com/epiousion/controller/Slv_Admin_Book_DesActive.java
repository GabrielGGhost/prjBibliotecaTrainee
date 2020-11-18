package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.BookDAO;
import com.epiousion.dao.BookDB;
import com.epiousion.exception.EpiousionException;

@WebServlet("/admin/book/desActive")
public class Slv_Admin_Book_DesActive extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_Admin_Book_DesActive() {}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		boolean status = Boolean.parseBoolean(request.getParameter("status"));
		
		BookDAO bookdb = new BookDB();
		
		try {
			bookdb.des_active(id, status);
		} catch (EpiousionException e) {

			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/book/list");
	}

}
