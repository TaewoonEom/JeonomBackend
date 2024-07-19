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
 * Servlet implementation class DetailServlet
 */
@WebServlet("/notice/detail.kh")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PageUtils pu = new PageUtils();
//		String pageUrl = "/WEB-INF/views/common/errorPage.jsp";
		try {
//			String noticeNo = request.getParameter("noticeNo");
			int noticeNo = Integer.parseInt(request.getParameter("noticeNo"));
			NoticeService nService = new NoticeService();
			Notice notice = nService.selectOneByNo(noticeNo);
			if(notice != null) {
				request.setAttribute("notice", notice);
				request.getRequestDispatcher("/WEB-INF/views/notice/detail.jsp").forward(request, response);
			}else {
				String errorMsg = "존재하지 않는 정보입니다.";
				pu.moveErrorPage(request, response, errorMsg);
			}
		} catch (Exception e) {
			pu.moveErrorPage(request, response, e.getMessage());
		}
	}


}
