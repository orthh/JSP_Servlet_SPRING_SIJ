package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex03Join")
public class Ex03Join extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		request.setCharacterEncoding("UTF-8");

		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		String pwd_verify = request.getParameter("pwd_verify");
		String gender = request.getParameter("gender");
		String bloodType = request.getParameter("bloodType");
		String birth = request.getParameter("birth");
		String[] hobby = request.getParameterValues("hobby");
		String favorite_color = request.getParameter("favorite_color");
		String sayWords = request.getParameter("sayWords");

		sb.append("아이디 : " + id + "<br />"
				+ "비밀번호 : " + pwd + "<br />");
		if(pwd.equals(pwd_verify)) {
			sb.append("비밀번호가 일치합니다.");
		}else {
			sb.append("비밀번호가 일치하지 않습니다.");
		}
		sb.append("<br />");
		sb.append("성별 : " + gender + "<br />"
				+ "혈액형 : " + bloodType + "<br />"
				+ "생일 : " + birth + "<br />"
				+ "취미 : ");
		for(String hob : hobby) {
			sb.append(hob + " ");
		}
		sb.append("<br />");
		sb.append("좋아하는색 : " + favorite_color + "<br />"
				+ "남기고 싶은 말 : " + sayWords);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		out.print(sb.toString());
		
		
		
	}

}
