package com.epiousion.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
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

@WebServlet("/admin/loan/list")
public class Admin_Loan_Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_Loan_Main() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date today = null;
		LoanDAO loandb = new LoanDB();
		List<LoanBook> loanList = null;
		try {
			loanList = loandb.getLoansOfTheDay();
			today = loandb.getTodayDate();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		
		request.getSession().setAttribute("date", today);
		request.getSession().setAttribute("loanList", loanList);
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_list.jsp").forward(request, response);
	}
}
