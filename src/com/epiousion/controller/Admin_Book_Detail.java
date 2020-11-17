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
import com.epiousion.model.Book;

@WebServlet("/admin/book/detail")
public class Admin_Book_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Book_Detail() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookDAO bookdb = new BookDB();
		Book book = null;
		int tombo = Integer.parseInt(request.getParameter("id"));
		
		try {
			book = bookdb.getAllBookByTombo(tombo);
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("book", book);
		
		request.getRequestDispatcher("/jsp/admArea/Book/struct_detail.jsp").forward(request, response); 
	}
}
