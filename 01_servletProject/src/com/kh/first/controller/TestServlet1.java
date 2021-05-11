package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // form태그로 들어온 데이터 or Get방식으로 들어온 data를 처리하는 함수
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. (문자셋)화면 인코딩 설정 (데이터 전송 과정에서 여러 OS를 거치며 데이터가 전송되므로 데이터가 깨질 수 있으므로)
		// 사용자가 웹 브라우저를 통해서 전송한 데이터를 서버의 입장에서 받는 것임.
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 화면 HTML 작성
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>서블릿이란?</title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>서블릿이란?</h1>");
		out.println("<p>");
		out.println("서블릿은 웹 애플리케이션 코드를, 웹 문서를 자바로 표현하는 기술이다.");
		out.println("</p>");
		out.println("</body>");
		
		out.println("</html>");
		
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	// form태그로 들어온 데이터 or post방식으로 들어온 data를 처리하는 함수
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
