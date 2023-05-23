package com.smhrd.controller;



import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.MyMember;
import com.smhrd.model.MyMemberDAO;

public class JoinController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		
		String url = "";
		
		try {
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
				url = "index.jsp";
			}else { // 회원가입 실패
				System.out.println("회원가입 실패!");
				url = "join.html";
			}
		} catch (UnsupportedEncodingException e) {
			System.out.print("인코딩 방식 잘못지정함!");
		} catch(IOException e) {
			System.out.println("redirect 경로 잘못지정함!");
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return url;
		

	}

}
