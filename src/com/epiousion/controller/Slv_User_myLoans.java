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
import com.epiousion.model.User;

@WebServlet("/myLoans")
public class Slv_User_myLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_User_myLoans() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		User user = (User)request.getSession().getAttribute("user");
		String select = (String) request.getParameter("select");
		if(select == null) select = "1";
		int id = user.getId();
		List userLoans = null;
		Date date = null;
		try {
			if(select.contentEquals("1")){
				userLoans = loandb.getUserLoans(id);				
			} else {
				userLoans = loandb.getUserLoanBooks(id);				
			}
			
			date = loandb.getTodayDate();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("loanList", userLoans);
		request.getSession().setAttribute("select", select);
		request.getSession().setAttribute("date", date);

		request.getRequestDispatcher("/jsp/userArea/strcut_myLoans.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
