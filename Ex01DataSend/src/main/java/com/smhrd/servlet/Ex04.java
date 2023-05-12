package com.smhrd.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Ex04")
public class Ex04 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StringBuilder sb = new StringBuilder();
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		String ope = request.getParameter("ope");
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		System.out.println(ope);
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		int result = 0;
		System.out.println(ope);
		switch (ope) {
			case "+": {
				result = num1 + num2;
				break;
			}
			case "-": {
				result = num1 - num2;
				break;
			}
			case "*": {
				result = num1 * num2;
				break;
			}
			case "/": {
				result = num1 / num2;
				break;
			}
			// no defualt
		}
		
		sb.append(num1);
		sb.append(" "+ ope + " ");
		sb.append(num2);
		sb.append(" = ");
		sb.append(result);
		
		out.print(sb.toString());
	}

}
