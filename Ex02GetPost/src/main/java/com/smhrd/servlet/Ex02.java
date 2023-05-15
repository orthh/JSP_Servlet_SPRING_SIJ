package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex02")
public class Ex02 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// GET/POST 한글 인코딩 방식
		// 1) POST : 패킷의 BODY에 실어져서 전송(MIME형식)
		// -> 패킷이 넘어올때마다(요청이 들어올때마다) 인코딩 방식을 지정해줘야함.
		// 2) GET : URL에 실어져서 전송
		// -> URI를 인코딩 해줘야함!
		// -> Server(Tomcat9) / server.xml -> URIEncoding=UTF-8 지정
		// -> Tomcat8 부터 default 로 URIEncoding이 UTF-8로 지정되어있음.

		request.setCharacterEncoding("UTF-8"); // *위치 : getParameter 호출 이전!
		String name = request.getParameter("name");

		System.out.println(name);

		// 응답
		response.setContentType("text/html; charset=UTF-8"); // 응답데이터 형식(인코딩 방식)지정
		PrintWriter out = response.getWriter(); // 텍스트 출력 스트림
		out.print(name); // 스트림을 통해 텍스트 출력
	}

}
