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

@WebServlet("/listaLivros")
public class Slv_User_BookList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_User_BookList() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BookDAO bookdb = new BookDB();
		List<Book> books = null;
		
		try {
			books = bookdb.getAllBooks();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("bookList", books);
		request.getRequestDispatcher("/jsp/struct_bookList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
