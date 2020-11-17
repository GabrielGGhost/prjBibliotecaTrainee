package com.epiousion.controller;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.GenderDAO;
import com.epiousion.dao.GenderDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Gender;

@WebServlet("/admin/gender/save")
public class Admin_Gender_Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Gender_Save() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Resource.
		
		String name = request.getParameter("name");
		
		System.out.println(name);
		Gender gender = new Gender(name);
		GenderDAO genderdb = new GenderDB();
		
		try {
			genderdb.register(gender);
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/gender/list");
	}
}
