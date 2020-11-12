package com.epiousion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.BookDAO;
import com.epiousion.dao.BookDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Book;

@WebServlet("/admin/book/list")
public class Admin_Book_BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Book_BookList() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		BookDAO bookDB = new BookDB();

		try {
			
			List<Book> bookList = bookDB.getAllBooks();

			request.getSession().setAttribute("bookList", bookList);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		request.getRequestDispatcher("/jsp/admArea/Book/struct_list.jsp").forward(request, response);
	}
}
