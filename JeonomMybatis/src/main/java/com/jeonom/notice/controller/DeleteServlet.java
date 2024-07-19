package com.jeonom.notice.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeonom.common.PageUtils;
import com.jeonom.notice.model.service.NoticeService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/notice/delete.kh")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageUtils pu = new PageUtils();
		try {
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			NoticeService nService = new NoticeService();
			int result = nService.deleteNotice(noticeNo);
			if(result > 0) {
				// 성공하면 리스트로 이동
				response.sendRedirect("/notice/list.kh");
			}else {
				String errorMsg = "삭제가 완료되지 않았습니다.";
				pu.moveErrorPage(request, response, errorMsg);
			}
		}catch (Exception e) {
			pu.moveErrorPage(request, response, e.getMessage());
		}
	}

}
