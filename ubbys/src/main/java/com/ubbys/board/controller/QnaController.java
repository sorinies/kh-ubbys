package com.ubbys.board.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ubbys.board.service.QnaService;
import com.ubbys.board.service.SelectQnaService;
import com.ubbys.board.vo.Qna;
import com.ubbys.board.vo.QnaCategory;
import com.ubbys.user.vo.User;

@WebServlet({"/qnaWrite", "/qnaInsert", "/qnaUpdateForm", "/qnaUpdate", "/qnaDeleteAlert","/qnaDelete"})
public class QnaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String command = request.getRequestURI().substring((request.getContextPath() + "/qna").length());
		
		String path = null;
		RequestDispatcher view = null;
		
		try {
			QnaService service = new QnaService();
			
			int cp = request.getParameter("cp")==null? 1 : Integer.parseInt(request.getParameter("cp"));
			
			// qna 글 작성 입력페이지 이동 Controller
			if(command.equals("Write")){
				
				if(request.getSession().getAttribute("loginUser")==null) throw new Exception();
				
				List<QnaCategory> qnaCategory = service.selectQnaCategory();
				request.setAttribute("qnaCategory", qnaCategory);
				
				view = request.getRequestDispatcher("/WEB-INF/views/board/qnaWrite.jsp");
				view.forward(request, response);
			}
			
			// qna 글 삽입 Controller
			else if(command.equals("Insert")) {
				
				int qnaCategoryId = Integer.parseInt(request.getParameter("qnaCategoryId"));
				String qnaTitle = request.getParameter("inputTitle");
				String qnaContent = request.getParameter("inputContent");
				int userId = ((User)request.getSession().getAttribute("loginUser")).getUserNo();
				
				Qna qna = new Qna();
				qna.setQnaCategoryId(qnaCategoryId);
				qna.setQnaTitle(qnaTitle);
				qna.setQnaContent(qnaContent);
				qna.setUserId(userId);
				
				int result = service.insertQna(qna);
				
				HttpSession session = request.getSession();
				if(result>0) {
					session.setAttribute("modalTitle", "글 작성 성공");
					session.setAttribute("modalText", "QNA 게시판에 글이 등록되었습니다.");
					session.setAttribute("modalButtonText", "목록으로");
					session.setAttribute("modalButtonLink", request.getContextPath()+"/qnaList");
					path = "qnaView?no="+result+"&cp=1";
					
				} else {
					session.setAttribute("modalTitle", "글 작성 실패");
					session.setAttribute("modalText", "QNA 글 등록에 실패했습니다.");
					session.setAttribute("modalButtonText", "작성 취소");
					session.setAttribute("modalButtonLink", request.getContextPath()+"/qnaList");
					path = request.getHeader("referer");
				}
				response.sendRedirect(path);
			}
			
			// qna 글 수정 페이지로 이동 Controller
			else if(command.equals("UpdateForm")) {
				
				List<QnaCategory> qnaCategory = service.selectQnaCategory();
				
				int qnaPostId = Integer.parseInt(request.getParameter("qnaPostId"));
				Qna qna = new SelectQnaService().selectQna(qnaPostId);
				qna.setQnaContent(qna.getQnaContent().replaceAll("<br>", "\r\n"));
				
				request.setAttribute("qnaCategory", qnaCategory);
				request.setAttribute("qna", qna);
				
				request.getRequestDispatcher("/WEB-INF/views/board/qnaUpdate.jsp").forward(request, response);
			}
			
			// qna 글 수정 Controller
			else if(command.equals("Update")) {
				
				int qnaPostId = Integer.parseInt(request.getParameter("qnaPostId"));
				int qnaCategoryId = Integer.parseInt(request.getParameter("qnaCategoryId"));
				String qnaTitle = request.getParameter("inputTitle");
				String qnaContent = request.getParameter("inputContent");
				
				Qna qna = new Qna();
				qna.setQnaPostId(qnaPostId);
				qna.setQnaCategoryId(qnaCategoryId);
				qna.setQnaTitle(qnaTitle);
				qna.setQnaContent(qnaContent);
				
				int result = service.updateQna(qna);
				
				HttpSession session = request.getSession();
				if(result>0) {
					session.setAttribute("modalTitle", "글 수정 성공");
					session.setAttribute("modalText", "QNA 글이 성공적으로 수정되었습니다.");
					session.setAttribute("modalButtonText", "목록으로");
					session.setAttribute("modalButtonLink", request.getContextPath()+"/qnaList?cp="+cp);
					path = "qnaView?no="+qnaPostId+"&cp="+cp;
					
				} else {
					session.setAttribute("modalTitle", "글 수정 실패");
					session.setAttribute("modalText", "QNA 글 수정에 실패했습니다.");
					session.setAttribute("modalButtonText", "수정 취소");
					session.setAttribute("modalButtonLink", request.getContextPath()+"/qnaView?no="+qnaPostId);
					path = request.getHeader("referer");
				}
				response.sendRedirect(path);
			}

			// qna 글 삭제 알림창 Controller
			else if(command.equals("DeleteAlert")) {

				int qnaPostId = Integer.parseInt(request.getParameter("qnaPostId"));

				HttpSession session = request.getSession();
				session.setAttribute("modalTitle", "글 삭제 알림");
				session.setAttribute("modalText", "QNA 글을 삭제하시겠습니까?");
				session.setAttribute("modalButtonText", "삭제하기");
				session.setAttribute("modalButtonLink", "qnaDelete?no="+qnaPostId+"&cp="+cp);
				response.sendRedirect(request.getHeader("referer"));
			}

			// qna 글 삭제 Controller
			else if(command.equals("Delete")) {

				int qnaPostId = Integer.parseInt(request.getParameter("no"));

				// 글 삭제 페이지에 접근한 사용자가 해당 글의 작성자인지 확인
				int loginUserId = ((User)request.getSession().getAttribute("loginUser")).getUserNo();
				int userId = service.postingUserCheck(qnaPostId);

				if(loginUserId == userId) {

					int result = service.deleteQna(qnaPostId);
					HttpSession session = request.getSession();
					if(result>0) {
						session.setAttribute("modalTitle", "글 삭제 성공");
						session.setAttribute("modalText", "QNA 글이 삭제되었습니다.");
						session.setAttribute("modalButtonText", "목록으로");
						session.setAttribute("modalButtonLink", "qnaList?cp="+cp);
						path = "qnaList";

					} else {
						session.setAttribute("modalTitle", "글 삭제 실패");
						session.setAttribute("modalText", "QNA 글 삭제에 실패했습니다.");
						session.setAttribute("modalButtonText", "목록으로");
						session.setAttribute("modalButtonLink", request.getContextPath()+"/qnaList?cp="+cp);
						path = request.getHeader("referer");
					}
					response.sendRedirect(path);

				} else {
					HttpSession session = request.getSession();
					session.setAttribute("modalTitle", "접근 경고");
					session.setAttribute("modalText", "올바른 경로로 접근해주세요.");
					session.setAttribute("modalButtonText", "확인");
					session.setAttribute("modalButtonLink", request.getContextPath()+"/main");
					response.sendRedirect(request.getContextPath()+"/main");
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("errorMsg", "이용할 수 없는 페이지입니다.");
			request.getRequestDispatcher("/WEB-INF/views/common/error.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
