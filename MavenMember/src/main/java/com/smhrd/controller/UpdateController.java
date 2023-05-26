package com.smhrd.controller;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.smhrd.model.WebMember;
import com.smhrd.model.WebMemberDAO;

public class UpdateController implements Command {

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response) {

		String url = "";
		try {
			// 요청 데이터 인코딩
			request.setCharacterEncoding("UTF-8");
			HttpSession session = request.getSession();
			WebMember mem = (WebMember)session.getAttribute("member");
			String email = mem.getEmail();
			
			// 수정 후 정보
			String pw = request.getParameter("pw");
			String tel = request.getParameter("tel");
			String address = request.getParameter("address");
			System.out.println(email);
			WebMember member = new WebMember(email, pw, tel, address);
			
			WebMemberDAO dao = new WebMemberDAO();
			int cnt = dao.update(member);
			
			if( cnt > 0) {
				// 회원가입 성공
				System.out.println("업데이트 성공!");
				// request 영역에 회원가입 시 입력한 이메일 추가 저장
				// 세션 값 바꾸기
				session.setAttribute("member", member);
				url = "index.jsp";
			}else { // 회원가입 실패
				System.out.println("업데이트 실패!");
				url = "update.jsp";
			}
			
		} catch (UnsupportedEncodingException e) {
			// TODO: handle exception
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		
		return url;
	}

}
