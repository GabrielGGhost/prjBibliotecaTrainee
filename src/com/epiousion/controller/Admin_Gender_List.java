package com.epiousion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.GenderDAO;
import com.epiousion.dao.GenderDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Gender;

@WebServlet("/admin/gender/list")
public class Admin_Gender_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Gender_List() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		GenderDAO genderdb = new GenderDB();
		List<Gender> genderList = null;
		
		try {
			genderList = genderdb.getAllGenders();
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("genderList", genderList);
		request.getRequestDispatcher("/jsp/admArea/Gender/struct_list.jsp").forward(request, response);
	}
}
