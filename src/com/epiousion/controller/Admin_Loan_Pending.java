package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/loan/pending")
public class Admin_Loan_Pending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Pending() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_pendingLoans.jsp").forward(request, response);
	}
}
