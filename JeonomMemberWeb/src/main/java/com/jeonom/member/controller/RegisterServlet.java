package com.jeonom.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeonom.member.model.service.MemberService;
import com.jeonom.member.model.vo.Member;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/member/join.do")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.sendRedirect("/WEB-INF/views/member/register.jsp"); 이미 URL주소를 매핑했기 때문에 
//		response.sendRedirect는 사용 불가. sendRedirect는 url주소를 복붙하는 거나 마찬가지이기 때문
		request.getRequestDispatcher("/WEB-INF/views/member/register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String memberId = request.getParameter("member-id");
		String memberPw = request.getParameter("memberPw");
		String memberName = request.getParameter("member-name");
		String gender = request.getParameter("gender");
		String age = request.getParameter("age");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		String hobby = request.getParameter("hobby");
		
		Map<String, String> genderMap = new HashMap<String, String>();
		genderMap.put("M", "남");
		genderMap.put("F", "여");
		
		// 회원가입 비즈니스 로직
		Member member = new Member(memberId, memberPw, memberName, genderMap.get(gender), Integer.parseInt(age), email, phone, address, hobby);
		MemberService mService = new MemberService();
		int result = mService.insertMember(member);
		if(result > 0) {
			// 성공 메시지 출력
			// 1. redirect
			// 공통의 페이지를 그대로 보이고 싶으면 
			// response.sendRedirect("");
			// 2. requestDispatcher 
			// 페이지마다 조금씩 다르게 설정해서 보이고 싶으면
			// request.setAttribute("msg", "성공");
			// request.getRequestDispatcher("").forward(request, response);
			response.sendRedirect("/index.jsp");
		}else {
			// 실패 메시지 출력
//			response.sendRedirect("/common/error/errorPage.jsp");
			request.getRequestDispatcher("/WEB-INF/views/common/error/errorPage.jsp").forward(request, response);
		}
		
	}

}
