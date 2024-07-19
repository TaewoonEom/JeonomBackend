package com.jeonom.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeonom.common.PageUtils;
import com.jeonom.notice.model.service.NoticeService;
import com.jeonom.notice.model.vo.Notice;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/notice/update.kh")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 요청이면 공지사항 수정 페이지 이동
		// 수정하려는 내용이 안보이기 때문에 보이도록 해줌
		int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
		NoticeService nService = new NoticeService();
		Notice notice = nService.selectOneByNo(noticeNo);
		request.setAttribute("notice", notice);
		request.getRequestDispatcher("/WEB-INF/views/notice/update.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 요청이면 공지사항 수정 진행
		// UPDATE NOTICE_TBL SET NOTICE_SUBJECT = #{noticeSubject}, NOTICE_CONTENT = #{noticeContent}
		// WHERE NOTICE_NO = #{noticeNo}
		// noticeNo, noticeSubject, noticeContent를 받아서 비즈니스 로직을 구현해야 함.
		PageUtils pu = new PageUtils();
//		String errorPage = "/WEB-INF/views/common/errorPage.jsp";
		try {
			request.setCharacterEncoding("UTF-8");
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			String noticeSubject = request.getParameter("noticeSubject");
			String noticeContent = request.getParameter("noticeContent");
			Notice notice = new Notice(noticeNo, noticeSubject, noticeContent);
			NoticeService nService = new NoticeService();
			int result = nService.updateNotice(notice);
			if(result > 0) {
				// 성공 후에 list로 이동하거나 상세페이지로 이동함.
				response.sendRedirect("/notice/list.kh");
			}else {
				String errorMsg = "공지사항 수정이 완료되지 않았습니다.";
				pu.moveErrorPage(request, response, errorMsg);
			}
		} catch (Exception e) {
			pu.moveErrorPage(request, response, e.getMessage());
		}
	}

}
