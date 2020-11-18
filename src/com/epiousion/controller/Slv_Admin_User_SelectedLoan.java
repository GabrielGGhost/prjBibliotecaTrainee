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
import com.epiousion.model.Loan;
import com.epiousion.model.LoanBook;

@WebServlet("/admin/user/selectedLoan")
public class Slv_Admin_User_SelectedLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Slv_Admin_User_SelectedLoan() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		Date date = null;

		List<LoanBook> userLoans = null;
		int idLoan = Integer.parseInt(request.getParameter("id"));
		
		try {
			userLoans = loandb.getUserLoanBooks(idLoan);
			date = loandb.getTodayDate();

		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("loanList", userLoans);
		request.getSession().setAttribute("date", date);

		request.getRequestDispatcher("/jsp/admArea/User/struct_selectedLoan.jsp").forward(request, response);
	}
}
