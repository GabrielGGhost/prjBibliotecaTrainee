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

@WebServlet("/loan/all")
public class Admin_Loan_All extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_All() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		List<LoanBook> loanList = null;
		int select = 0;
		try {
			select = Integer.parseInt(request.getParameter("select"));
			if(select == 0) select = 1;
			
			loanList = loandb.getAllBooksLoan(select);
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("select", select);
		request.getSession().setAttribute("loanList", loanList);
		
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_all.jsp").forward(request, response);
	}
}
