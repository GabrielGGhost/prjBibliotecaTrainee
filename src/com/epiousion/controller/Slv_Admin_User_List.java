package com.epiousion.controller;

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

@WebServlet("/admin/user/list")
public class Slv_Admin_User_List extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Slv_Admin_User_List() { }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDAO userdb = new UserDB();
		List<User> userList = null;
		int quantity = 0;
		String filter = request.getParameter("filter");
		String page = request.getParameter("page");
    	try {
			userList = userdb.getAllUsers(filter, page);
			//quantity = userdb.getQuantityPages();
		} catch (EpiousionException e) {
			e.printStackTrace();
		}
		
    	request.getSession().setAttribute("userList", userList);
    	request.getSession().setAttribute("pages", quantity);

		request.getRequestDispatcher("/jsp/admArea/User/struct_list.jsp").forward(request, response);
	}
}
