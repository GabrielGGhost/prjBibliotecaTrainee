package com.epiousion.controller.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.User;

@WebServlet("/loan/searchUser")
public class Admin_Loan_Engine extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Engine() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			findUser(request, response);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			findUser(request, response);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
	}
	
	protected void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EpiousionException {
		
		UserDAO userdb = new UserDB();
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userdb.getActiveUserByID(id);
		PrintWriter out = response.getWriter();
		out.write("<?xml version='1.0' encoding='UTF-8'?>");

		if(user != null) {
			
			response.setContentType("text/xml");
			out.write("<user>");
				out.write("<idUser>" + user.getId() + "</idUser>");
				out.write("<name>" + user.getName() + "</name>");
				out.write("<email>" + user.getEmail() + "</email>");
				out.write("<phone>" + user.getPhone() + "</phone>");
	
			out.write("</user>");
		} else {
			out.write("<user>");
						
			out.write("</user>");
		}
		System.out.println("Finalizando busca por cliente!");
	}

}
