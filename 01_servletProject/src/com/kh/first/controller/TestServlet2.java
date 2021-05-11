package com.kh.first.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 서블릿 연결 방법 2가지 <br>
 * 1) web.xml에 직접 servlet, servlet-mapping 태그를 통해 등록하는 방법 <br>
 * 2) @WebServlet("url") 어노테이션을 사용하는 방법 <br>
 * ** 두 가지를 같이 선언할 수 없다! (한가지 방법만 사용해야 한다.)
 */
@WebServlet("/test2.do") // web.xml에 servlet 태그를 사용할 필요를 없애줌.
public class TestServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestServlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 1. 문자셋 변경
		request.setCharacterEncoding("UTF-8");
		// text를 utf-8 형식의 html로 읽겠다.
		response.setContentType("text/html; charset=utf-8");
		
		// 2. 사용자가 보낸 데이터 확인 (getParameter의 매개변수로 key값을 사용)
		//    key 값을 사용하여 사용자가 입력한 결과를 받을 때, 값을 String 형으로 받는다.
		// 	   그 이유는, 사용자가 입력한 값이 어떤 데이터 형일지 예상할 수 없기 때문.
		//    그래서 값을 받고 숫자인 지 판별하고 싶다면 parseInt()를 사용해서 보면 된다.
		String userId = request.getParameter("userId");
		String password = request.getParameter("userPwd");
		
		System.out.println(userId + " / "  + password);
		
		// 3. 전송받은 데이터를 활용하여 응답 HTML 작성하기
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		
		out.println("<head>");
		out.println("<title>로그인 결과 </title>");
		out.println("</head>");
		
		out.println("<body>");
		out.println("<h1>로그인 결과</h1>");
		out.println("아이디 : " + userId + "<br>");
		out.println("비밀번호 : " + password);
		
		out.println("</body>");
		
		out.println("</html>");
		out.flush();
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
