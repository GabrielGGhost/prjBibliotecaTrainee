package com.epiousion.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.GenreDAO;
import com.epiousion.dao.GenreDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Genre;

@WebServlet("/admin/genre/save")
public class Slv_Admin_Genre_Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_Admin_Genre_Save() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		String name = request.getParameter("name");
		
		System.out.println(name);
		Genre genre = new Genre(name);
		GenreDAO genredb = new GenreDB();
		
		try {
			genredb.register(genre);
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/gender/list");
	}
}
