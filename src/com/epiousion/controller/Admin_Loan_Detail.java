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
import com.epiousion.model.LoanBook;

/**
 * Servlet implementation class Admin_Loan_Detail
 */
@WebServlet("/admin/loan/detail")
public class Admin_Loan_Detail extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Detail() {}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		LoanBook loan = null;
		int idLoanBook = Integer.parseInt(request.getParameter("id"));
		
		try {
			loan = loandb.getSelectedLoan(idLoanBook);
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("loan", loan);
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_detail.jsp").forward(request, response);
	}
}
