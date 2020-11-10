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
import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.User;

@WebServlet("/admin/viewLoans")
public class Admin_User_ViewLoans extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	public Admin_User_ViewLoans() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoanDAO loandb = new LoanDB();		
		UserDAO userdb = new UserDB();
		User user = null;
		
		int id = Integer.parseInt(request.getParameter("id"));
		String opc = request.getParameter("select");
		if(opc.equals(null)) opc = "1";
		
		List loanList = null;
		
		try {
			user = userdb.getUserByID(id);
			if(opc.equals("1")){
				loanList = loandb.getUserLoans(id);
			} else {
				loanList = loandb.getUserLoanBooks(id);
			}
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("selectedUser", user);
		request.getSession().setAttribute("userLoans", loanList);
		request.getSession().setAttribute("select", opc);
		
		request.getRequestDispatcher("/jsp/admArea/User/struct_Loans.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}