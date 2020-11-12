package com.epiousion.controller.ajax;

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


/**
 * Servlet implementation class AdminUser_registerUser
 */
@WebServlet("/admin/book/register/ajax")
public class Admin_Book_Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Book_Register() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			registerBook(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			registerBook(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	private void registerBook(HttpServletRequest request, HttpServletResponse response) throws EpiousionException {
		
		String title = request.getParameter("title");
		int year = Integer.parseInt(request.getParameter("year"));
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		
		Book user = new Book(title, year, author, description);
		BookDAO bookdb = new BookDB();
		
		bookdb.register(user);
		System.out.println("Usuário cadastrado");
	}

}
