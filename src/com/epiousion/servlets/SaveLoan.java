package com.epiousion.servlets;

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

/**
 * Servlet implementation class SaveLoan
 */
@WebServlet("/saveLoan")
public class SaveLoan extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public SaveLoan() {}

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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		response.sendRedirect(request.getContextPath() + "/admin/emprestimos");
	}

}
