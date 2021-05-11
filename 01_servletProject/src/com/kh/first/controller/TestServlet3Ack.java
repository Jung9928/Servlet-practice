package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3Ack
 */
@WebServlet("/test3Ack.do")
public class TestServlet3Ack extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3Ack() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 화면 전담 서블릿
		// 1. 문자셋 변경 - test3.do에서 수행했으므로, 생략가능하다! -
		
		// 2. HTML 작성
		
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>오늘의 색상</title>");
		out.println("</head>");
		
		out.println("<body>");
		
		out.println("<h1>오늘의 색상!</h1>");
		out.println("<p style='border : 3px solid " + request.getParameter("colorPicker") + ";'>");
		out.println("<h1 style='color " + request.getParameter("colorPicker") + ";'>");
		out.println("선택한 색상 : " + request.getParameter("colorPicker"));
		out.println("</h1>");
		out.println("색상 평 : " + request.getAttribute("msg"));
		out.println("</p>");
		
		out.println("</body>");
		out.println("</html>");
		
		out.flush();	// flush 는 자동으로 해주므로, 생략하고 싶으면 생략해도 된다.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
