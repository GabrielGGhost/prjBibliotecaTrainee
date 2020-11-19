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
		String year = request.getParameter("year");
		String author = request.getParameter("author");
		String description = request.getParameter("description");
		
		if(year.equals("") || year == null){
			year = "0";
		}
		

		if(title.equals("") || title == null ||
		    year == "0" ||
		    author.equals("") || author == null ||
		    description.equals("") || description == null){
			
			return;
		} 
		
		Book user = new Book(title, Integer.parseInt(year), author, description);
		BookDAO bookdb = new BookDB();
		bookdb.register(user);
		System.out.println("Usuário cadastrado");
	}

}
