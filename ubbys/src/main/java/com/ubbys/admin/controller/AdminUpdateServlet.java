package com.ubbys.admin.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ubbys.admin.model.service.AdminService;
import com.ubbys.user.vo.User;

@WebServlet("/admin/adminUpdatePage")
public class AdminUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userEmail = request.getParameter("userEmail");

		try {

			AdminService service = new AdminService();
			User user = service.selectUser(userEmail);
			request.setAttribute("user", user);

			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/admin/adminUpdatePage.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
