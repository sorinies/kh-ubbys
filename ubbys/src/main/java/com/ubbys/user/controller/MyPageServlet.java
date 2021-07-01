package com.ubbys.user.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ubbys.board.service.SelectQnaService;
import com.ubbys.board.vo.Qna;
import com.ubbys.board.vo.QnaPagination;
import com.ubbys.user.vo.User;

@WebServlet("/user")
public class MyPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher view = null;
		
		try {
			
			// 내 qna 목록 관련
			SelectQnaService service = new SelectQnaService();
			int cp = request.getParameter("cp")==null? 1 : Integer.parseInt(request.getParameter("cp"));
			QnaPagination pagination = service.getPagination(cp);
			
			HttpSession session = request.getSession();
			int userNo = ((User) session.getAttribute("loginUser")).getUserNo();
			List<Qna> myQnaList = service.selectMyQnaList(userNo);
//			List<Qna> myQnaList = service.selectMyQnaList(pagination, userNo);
			
			request.setAttribute("pagination", pagination); // Service, DAO 부분 추가필요
			request.setAttribute("myQnaList", myQnaList);
			

			// 내 apps 목록 관련
//			SelectAppsService appsService = new SelectAppsService();
//			int cp = request.getParameter("cp")==null? 1 : Integer.parseInt(request.getParameter("cp"));
//			AppsPagination appPagination = service.getAppsPagination(cp);
//			List<Qna> myAppsList = service.selectMyAppsList(userNo);
//			request.setAttribute("appPagination", appPagination);
//			request.setAttribute("myAppsList", myAppsList);
			
			// 내 댓글 목록 관련
//			SelectQnaReplyService replyService = new SelectQnaReplyService();
//			int cp = request.getParameter("cp")==null? 1 : Integer.parseInt(request.getParameter("cp"));
//			QnaReplyPagination qnaReplyPagination = service.getQnaReplyPagination(cp);
//			List<Qna> myReplyList = service.selectMyReplyList(userNo);
//			request.setAttribute("qnaReplyPagination", qnaReplyPagination);
//			request.setAttribute("myReplyList", myReplyList);
			
			view = request.getRequestDispatcher("/WEB-INF/views/user/mypage.jsp");
			view.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
