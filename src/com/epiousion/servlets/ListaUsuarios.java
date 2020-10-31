package com.epiousion.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.epiousion.dao.UserDAO;
import com.epiousion.dao.UserDB;
import com.epiousion.exception.EpiousionException;
import com.epiousion.model.User;

/**
 * Servlet implementation class ListaUsuarios
 */
@WebServlet("/admin/listaUsuarios")
public class ListaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ListaUsuarios() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userdb = new UserDB();
		List<User> userList = null;
    	try {
			userList = userdb.getAllUsers();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
    	request.getSession().setAttribute("userList", userList);
		request.getRequestDispatcher("/jsp/admArea/corpo_listaUsuarios.jsp").forward(request, response);
	}


}
