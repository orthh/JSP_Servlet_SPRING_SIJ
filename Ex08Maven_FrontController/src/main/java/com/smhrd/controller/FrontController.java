package com.smhrd.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 회원관리된 요청 받아줄 프론트 컨트롤러 (회원가입, 로그인)
// 요청 구분 -> 프론트 컨트롤러 : *.do ex. login.do -> 로그인요청 / join.do -> 회원가입요청 
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, Object> list = null;
	
	// 최초로 요청들어왔을 때 딱 한번만 실행
	public void init(ServletConfig config) throws ServletException {
		// 여기로 들어올수 있는 요청 경로를 미리 리스트로 만들어놓기!
		// map(순서가 없는 구조) 사용! (key-value)
		// (key(요청경로-join.do/login.do...:String)-value(그 기능을 수행해줄 컨트롤러 객체)
		list = new HashMap<>();
		list.put("/join.do", new JoinController());
//		list.put("/login.do", new LoginController());
		
	}

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		String path = request.getContextPath();
		String subUri = uri.substring(path.length());
		
		System.out.println(uri);
		System.out.println(path);
		System.out.println(subUri);
		
		JoinController controller = (JoinController)list.get(subUri);
		String des = controller.process(request, response);
		
		System.out.println(des);
		
		response.sendRedirect(des);
		
		
	}

}
