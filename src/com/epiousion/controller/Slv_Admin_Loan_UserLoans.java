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
import com.epiousion.model.LoanBook;

@WebServlet("/admin/loan/userLoans")
public class Slv_Admin_Loan_UserLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public Slv_Admin_Loan_UserLoans() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id = request.getParameter("id");
		LoanDAO loandb = new LoanDB();
		List<LoanBook> loanList = null;
		
		if(id == null || id.equals("")) id = "0";
		
		try {
			loanList = loandb.getUserLoanBooks(Integer.parseInt(id));
		} catch (NumberFormatException | EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("loanList", loanList);
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_UserLoans.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}


}
