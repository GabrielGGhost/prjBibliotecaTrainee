package com.epiousion.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.LoanDAO;
import com.epiousion.dao.LoanDB;
import com.epiousion.exception.EpiousionException;

@WebServlet("/admin/loan/renew")
public class Admin_Loan_Renew extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Renew() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		LoanDAO loandb = new LoanDB();
		
		try {
			loandb.renewBook(id);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/loan/list");
	}
}
