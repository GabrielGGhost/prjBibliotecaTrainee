package com.epiousion.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.BookDAO;
import com.epiousion.dao.BookDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Book;

@WebServlet("/loan/searchBook")
public class Admin_Book_Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Book_Search() {}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			searchBook(request, response);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			searchBook(request, response);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
	}
	
	protected void searchBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EpiousionException {
		
		BookDAO bookdb = new BookDB();
		int id = Integer.parseInt(request.getParameter("tombo"));
		
		Book book = bookdb.getBookByTombo(id);
		PrintWriter out = response.getWriter();
		out.write("<?xml version='1.0' encoding='UTF-8'?>");
		response.setContentType("text/xml");
	
		out.write("<book>");

		if(book != null) {
				
			out.write("<tombo>" + book.getTombo() + "</tombo>");
			out.write("<title>" + book.getTitle() + "</title>");
			out.write("<year>" + book.getYear() + "</year>");
			out.write("<author>" + book.getAuthor() + "</author>");
		}
			out.write("</book>");
		
		System.out.println("[AJAX] Finalizando busca por livro!");
	}
}
