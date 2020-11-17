package com.epiousion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.GenreDAO;
import com.epiousion.dao.GenreDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Genre;

@WebServlet("/admin/genre/manage")
public class Admin_Genre_Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Admin_Genre_Manage() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		if(id == null || id.equals("")) id = "1";
		GenreDAO genderdb = new GenreDB();
		List<Genre> registeredGenres = null,
					unregisteredGenres = null;
		
		try {
			unregisteredGenres = genderdb.getUnregisteredGenres(id);
			registeredGenres = genderdb.getRegisteredGenres(id);
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("unregisteredGenres", unregisteredGenres);
		request.getSession().setAttribute("registeredGenres", registeredGenres);

		request.getRequestDispatcher("/jsp/admArea/Genre/struct_manage.jsp").forward(request, response);
	}


}
