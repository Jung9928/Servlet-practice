package com.kh.first.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet4
 */
@WebServlet("/test4.do")
public class TestServlet4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet4() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 만약 전달받은 데이터의 ID와 PS가 
		// 각각 'user01' / 'pass01'이 아니라면
		// 에러 페이지로 이동 시키기
		
		// 문자셋 변경
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		
		if(userId.equals("user01") && password.equals("pass01")) {
			// 로그인 성공
			RequestDispatcher view = request.getRequestDispatcher("/test2.do");
			
			// forward나 redirect는 요청을 전송하는 작업이므로, 
			// 데이터에 대한 처리를 다 끝낸 후, 마지막에 코드를 작성하도록 한다.
			view.forward(request, response);
		} else {
			// 로그인 실패 시, test4Ack.do로 요청에 대한 응답책임을 떠넘김.
			response.sendRedirect("test4Ack.do");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
