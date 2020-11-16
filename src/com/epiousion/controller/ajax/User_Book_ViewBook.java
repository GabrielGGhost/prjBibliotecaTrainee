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

@WebServlet("/viewBook")
public class User_Book_ViewBook extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public User_Book_ViewBook() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			viewBook(request, response);
		} catch (NumberFormatException | EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			viewBook(request, response);
		} catch (NumberFormatException | EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	protected void viewBook(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NumberFormatException, EpiousionException {
		
		String tombo = request.getParameter("tombo");
		
		if(tombo.equals("") || tombo == null) tombo = "1";
		BookDAO boodb = new BookDB();
		Book book = null;
		
		book = boodb.getBookByTomboAjax(Integer.parseInt(tombo));
	
		PrintWriter out = response.getWriter();
		out.write("<?xml version='1.0' encoding='UTF-8'?>");
	

			
			response.setContentType("text/xml");
			out.write("<book>");
			if(book != null) {
				out.write("<tombo>" + book.getTombo() + "</tombo>");
				out.write("<title>" + book.getTitle() + "</title>");
				out.write("<year>" + book.getYear() + "</year>");
				out.write("<author>" + book.getAuthor() + "</author>");
				out.write("<description>" + book.getDescription() + "</description>");
			}
			out.write("</book>");
		
		System.out.println("Finalizando busca por cliente!");
	}
}
