package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class JoinController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {
		String url = "";
		try {
			// 요청 데이터 인코딩
			request.setCharacterEncoding("UTF-8");
			
			String email = request.getParameter("email");
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			
			WebMember member = new WebMember(email, pw, tel, address);
			
			WebMemberDAO dao = new WebMemberDAO();
			int cnt = dao.join(member);
			
			if( cnt > 0) {
				// 회원가입 성공
				System.out.println("회원가입 성공!");
				// request 영역에 회원가입 시 입력한 이메일 추가 저장
				request.setAttribute("joinEmail", email);
				url = "joinSuccess.jsp";
			}else { // 회원가입 실패
				System.out.println("회원가입 실패!");
				url = "index.jsp";
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return url;
	}

}
