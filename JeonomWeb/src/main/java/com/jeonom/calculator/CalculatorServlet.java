package com.jeonom.calculator;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CalculatorServlet
 */
@WebServlet("/CalculatorServlet")
public class CalculatorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CalculatorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstNum = request.getParameter("first-num");
		String secondNum = request.getParameter("second-num");
		String operator = request.getParameter("operator");
		int num1 = Integer.parseInt(firstNum); // Wrapper 클래스
		int num2 = Integer.parseInt(secondNum);
		int result = 0;
		response.setContentType("text/html;charset=utf-8");
		
		switch(operator) {
			case "+" : result = num1 + num2; break;
			case "-" : result = num1 - num2; break;
			case "x" : result = num1 * num2; break;
			case "/" : result = num1 / num2; break;
			case "%" : result = num1 % num2; break;
		}
		// setAttribute(String, Object) 메소드의 매개변수 타입이 
		// String, Object이므로 String으로 형변환하지 않아도 된다.
		request.setAttribute("firstNum", firstNum);
		request.setAttribute("secondNum", secondNum);
		request.setAttribute("result", result);
		request.setAttribute("operator", operator);
		request.getRequestDispatcher("/calculator/resultCalc.jsp").forward(request, response);
	}


}
