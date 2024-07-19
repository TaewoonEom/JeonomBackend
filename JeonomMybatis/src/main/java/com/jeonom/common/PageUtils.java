package com.jeonom.common;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class PageUtils {
	private final String ERROR_NAME = "/WEB-INF/views/common/errorPage.jsp";
	
	public void moveErrorPage(HttpServletRequest request, HttpServletResponse response, String errorMsg) throws ServletException, IOException {
		
		request.setAttribute("msg", errorMsg);
		RequestDispatcher view = request.getRequestDispatcher(ERROR_NAME);
		view.forward(request, response);
	}
}
