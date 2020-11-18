package com.epiousion.controller;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.RespectBinding;

import com.epiousion.dao.LoanDAO;
import com.epiousion.dao.LoanDB;
import com.epiousion.exception.EpiousionException;

@WebServlet("/loan/save")
public class Admin_Loan_Save extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Admin_Loan_Save() {}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String idUser = request.getParameter("idUser");
		LoanDAO loandb = new LoanDB();
		
		Map params = request.getParameterMap();
		
		@SuppressWarnings("rawtypes")
		Iterator i = params.keySet().iterator();
		
		try {
			String idLoan = loandb.saveLoan(idUser);
					
			while(i.hasNext()){
				String key = (String) i.next();
					
				String idBook = ((String[]) params.get(key))[0];
				
				if(!key.equals("idUser"))
					loandb.saveBookLoan(idLoan, idBook);
			}
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/loan/list");
	}

}
