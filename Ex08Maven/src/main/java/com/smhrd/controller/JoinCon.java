package com.smhrd.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MyMember;
import com.smhrd.model.MyMemberDAO;

public class JoinCon extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 요청 데이터 인코딩 방식 지정
		request.setCharacterEncoding("UTF-8");
		
		// id, pw, nick
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String nick = request.getParameter("nick");
		
		MyMember member = new MyMember(id, pw, nick);
		
		// 데이터베이스 연동 -> 값 넣어주기! (myBatis 활용)
		MyMemberDAO dao = new MyMemberDAO(); // SqlSessionFactory 생성
		int cnt = dao.join(member); // 회원가입 기능
		
		if( cnt > 0) {
			// 회원가입 성공
			System.out.println("회원가입 성공!");
		}else { // 회원가입 실패
			System.out.println("회원가입 실패!");
		}
	}

}
