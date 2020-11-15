package com.epiousion.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.LoanDAO;
import com.epiousion.dao.LoanDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.LoanBook;

@WebServlet("/loan/pending")
public class Admin_Loan_Pending extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Pending() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		List<LoanBook> loanList = null;
		try {
			loanList = loandb.getAllBooksLoan();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_pendingLoans.jsp").forward(request, response);
	}
}
