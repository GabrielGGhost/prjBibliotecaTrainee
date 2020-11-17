package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.GenreDAO;
import com.epiousion.dao.GenreDB;
import com.epiousion.exception.EpiousionException;

/**
 * Servlet implementation class Admin_Genre_Link
 */
@WebServlet("/admin/genre/link")
public class Admin_Genre_Link extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Genre_Link() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idGenre = request.getParameter("idGenre");
		String tombo = request.getParameter("tombo");
		GenreDAO genderdb = new GenreDB();
		
		if(idGenre != null || tombo != null || !idGenre.equals("") || !tombo.equals("")){
			
			try {
				genderdb.linkGender(tombo, idGenre);
			} catch (EpiousionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/genre/manage?id=" + tombo);
	}



}
