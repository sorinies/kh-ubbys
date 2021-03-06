package com.ubbys.user.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ubbys.user.service.UserService;
import com.ubbys.user.vo.User;

@WebServlet("/user/deleteAccount")
public class DeleteAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/user/delete_account.jsp");
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String currentPw = request.getParameter("inputPresentPw");
		HttpSession session = request.getSession();
		int userNo = ((User) session.getAttribute("loginUser")).getUserNo();
		//System.out.println(userNo);
		try {
			int result = new UserService().deleteAccount(currentPw, userNo);
			
			String path = null;

			String modalTitle = null;
			String modalText = null;

			if (result > 0) {
				modalTitle = "회원 탈퇴 성공";
				modalText = "회원 탈퇴가 완료되었습니다.";
//				System.out.println(alertTitle);
//				path = request.getContextPath()+"/main";
				path = request.getContextPath();
				session.invalidate();
			}
			else if(result==-1){
				modalTitle = "회원 탈퇴 실패";
				modalText = "비밀번호가 일치하지 않습니다.";	
				path = request.getHeader("referer");
			} 
			else {
				modalTitle = "회원 탈퇴 실패";
				modalText = "회원 탈퇴 중 문제가 발생했습니다. \n문제가 지속될 경우 고객센터 문의 바랍니다.";
//				System.out.println(alertTitle);
				path = "deleteAccount";
			}
			session = request.getSession();
			session.setAttribute("modalTitle", modalTitle);
			session.setAttribute("modalText", modalText);

			response.sendRedirect(path);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "회원 탈퇴 과정에서 문제가 발생했습니다.");
			RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/common/error.jsp");
			view.forward(request, response);
		}
	}

}
