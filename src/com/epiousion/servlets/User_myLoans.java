package com.epiousion.servlets;

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
import com.epiousion.model.User;

@WebServlet("/myLoans")
public class User_myLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public User_myLoans() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();
		User user = (User)request.getSession().getAttribute("user");
		String select = (String) request.getSession().getAttribute("select");
		if(select == null) select = "1";
		int id = user.getId();
		List<Loan> userLoans = null;
		try {
			if(select.contentEquals("1")){
				userLoans = loandb.getUserLoans(id);				
			} else {
				userLoans = loandb.getUserLoanBooks(id);				
			}
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("userLoans", userLoans);
		request.getSession().setAttribute("select", select);

		request.getRequestDispatcher("/jsp/userArea/strcut_myLoans.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
