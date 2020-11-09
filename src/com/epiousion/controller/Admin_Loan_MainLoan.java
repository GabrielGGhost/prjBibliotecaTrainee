package com.epiousion.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.LoanDAO;
import com.epiousion.dao.LoanDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.Loan;

@WebServlet("/admin/emprestimos")
public class Admin_Loan_MainLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_MainLoan() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		List<Loan> loanList = null;
		try {
			loanList = loandb.getAllLoans();
		} catch (EpiousionException e) {
			
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("loanList", loanList);
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_list.jsp").forward(request, response);
	}
}
