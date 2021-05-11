package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TestServlet3
 */
@WebServlet("/test3.do")
public class TestServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 문자셋 변경
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		// 2. 화면(view)에서 전달한 데이터 받아오기
		String color = request.getParameter("colorPicker");
		
		System.out.println("색상 확인 : " + color);
		
		// 3. 전달받은 데이터를 활용해 서비스 기능 실행
		String msg = null;
		
		switch(color) {
		
		case "red" : 
			msg = "불타는 수요일 아침, 점심은 불닭볶음면 어떠신가요?";
			break;
		case "orange" :	
			msg = "상큼한 오늘, 당신의 점심은 샐러드가 좋겠군요!";
			break;
		case "yellow" : 
			msg = "노란 하늘은 황사입니다, 마스크 착용하세요!";
			break;
		case "green" : 
			msg = "평화로운 하루입니다, 오늘도 건승하세요!";
			break;
		case "blue" : 
			msg = "파란 하늘 파란 하늘 꿈이~";
			break;
		case "purple" : 
			msg = "보라돌이 뚜비 나나 뽀";
			break;
		}
		
		System.out.println("멘트 확인 : " + msg);
		
		// 4. 화면 구현 전용 서블릿 연결하기
		
		// RequestDispatcher : 요청을 전달하는 객체.
		// 즉, test3.do에서 request를 TestServlet3 에 전달하고 TestServlet3Ack으로  화면 구현 요청을 전달해서
		// TestServlet3가 test3.do에게 화면 구현 요청받은 것을 TestServlet3Ack으로 전달해서
		// TestServlet3Ack가 화면 구현을 수행한 후, 사용자의 화면에 결과를 return 해주는 방식을
		// 사용하여, 화면 구현 전용 서블릿을 구현하는 것임.
		RequestDispatcher view = request.getRequestDispatcher("/test3Ack.do");
		
		// 전달할 데이터 작성
		// 전달할 데이터는 setAttribute를 사용하여 전달한다.
		request.setAttribute("msg", msg);
		
		// 출발!
		// 즉, 사용자가 요청한 request와 요청한 request의 결과인 response를
		// 사용자의 화면에 forward해준다.(결과를 전달해준다)
		view.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
}
