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

@WebServlet("/admin/genre/list")
public class Slv_Admin_Genre_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_Admin_Genre_List() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenreDAO genredb = new GenreDB();
		List<Genre> genreList = null;
		
		try {
			genreList = genredb.getAllGenders();
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("genreList", genreList);
		request.getRequestDispatcher("/jsp/admArea/Genre/struct_list.jsp").forward(request, response);
	}
}
