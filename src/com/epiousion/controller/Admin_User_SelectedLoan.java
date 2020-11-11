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
import com.epiousion.model.LoanBook;

@WebServlet("/admin/user/selectedLoan")
public class Admin_User_SelectedLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Admin_User_SelectedLoan() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		LoanBook loanbook = null;
		List userLoans = null;
		int idLoan = Integer.parseInt(request.getParameter("idLoan"));
		
		try {
			userLoans = loandb.getUserBooksLoan(idLoan);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("userLoans", userLoans);
		
		request.getRequestDispatcher("/jsp/admArea/User/struct_selectedLoan.jsp").forward(request, response);
	}
}
