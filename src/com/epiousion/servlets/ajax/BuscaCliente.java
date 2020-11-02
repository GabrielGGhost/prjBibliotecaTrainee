package com.epiousion.servlets.ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Out;

import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.User;

/**
 * Servlet implementation class BuscaCliente
 */
@WebServlet("/buscaCliente")
public class BuscaCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscaCliente() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			findUser(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			findUser(request, response);
		} catch (EpiousionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	protected void findUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, EpiousionException {
		
		UserDAO userdb = new UserDB();
		int id = Integer.parseInt(request.getParameter("id"));
		
		User user = userdb.getUserByID(id);
		PrintWriter out = response.getWriter();
		out.write("<?xml version='1.0' encoding='UTF-8'?>");

		if(user != null) {
			
			response.setContentType("text/xml");
			out.write("<user>");
				out.write("<idUser>" + user.getId() + "</idUser>");
				out.write("<name>" + user.getName() + "</name>");
				out.write("<email>" + user.getEmail() + "</email>");
				out.write("<phone>" + user.getPhone() + "</phone>");
	
			out.write("</user>");
		} else {
			out.write("<user>");
						
			out.write("</user>");
		}
		System.out.println("Finalizando busca por cliente!");
	}

}
