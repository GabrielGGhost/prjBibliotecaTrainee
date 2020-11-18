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
import com.epiousion.model.Loan;;

@WebServlet("/admin/loan/make")
public class Slv_Admin_Loan_Make extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_Admin_Loan_Make() { }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Date date = new Date();
		LoanDAO loandb = new LoanDB();
		
		try {
			date = loandb.getTodayDate();
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getSession().setAttribute("date", date);
		request.getRequestDispatcher("/jsp/admArea/Loan/struct_makeLoan.jsp").forward(request, response);
	}
}
