package com.jeonom.member.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/member/join.kh")
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
		// 회원가입 링크를 누르면 동작 1. 회원 가입 버튼 2. 회원 가입 링크 3. 직접 주소를 입력
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/views/member/register.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");		// 한글 깨짐 방지. UTF-8 인코딩
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
			Member member = new Member(memberId, memberPw, memberName, genderMap.get(gender), Integer.parseInt(age), email, phone, address, hobby);
			MemberService mService = new MemberService();
			int result = mService.insertMember(member);
			if(result > 0) {
				response.sendRedirect("/");
			}else {
				request.setAttribute("msg", "회원가입이 완료되지 않았습니다.");
				request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
			}
		}catch(Exception e) {
			request.setAttribute("msg", e.getMessage());
			request.getRequestDispatcher("WEB-INF/views/common/errorPage.jsp").forward(request, response);
		}
		
		
	}

}
