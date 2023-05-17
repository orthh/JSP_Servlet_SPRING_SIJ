<!-- 지시자(Directive) : JSP 설정 정보 및 다른 문서에(를) 포함 등 -->
<!-- 지시자의 종류 : page, include, taglib(tag library -> JSTL) -->
<!-- contentType : 응답데이터의 형식과 인코딩방식을 브라우저(클라이언트)에게 알려주기 위함 -->
<!-- pageEncoding: JSP 페이지에 대한 인코딩 -->
<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- charset : html 문서에 대한 인코딩 지정 -->
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 스크립틀릿(Scriptlet : JSP 페이지 내부에 자바 소스 코드를 삽입 -->
	<%--JSP 주석 : 화면과 소스보기에서 보이지 않음. --%>
	<!-- 스크립틀릿 안에 작성한 코드는 service() 메소드 안에 작성, 지역 -->
	<%
		// JSP 구성 요소 내에서는 자바 주석 가능
		System.out.println("Hello JSP");
		int num = 10;
		int num2 = 20;
		
		Random rd = new Random();
		int ran = rd.nextInt(10);
		
		// %안 문은 servlet 의 service() 안에 들어갈때 web Conttainer에서 out에 대한게 자동으로 선언함(자동임포트).
		out.print(ran + "<br />"); // println() : 코드 개행
									// <br>추가 -> 화면 상 개행
	%>
	<!-- 표현식(Expression) : 화면(웹 브라우저상)에 출력하기 위해 사용, ; 작성x -->
	<p style="color: red; font-size: 20px"><%=ran %></p>
	<span><%="String" %></span><br />
	<span><%="풀" + "스택" %></span>
	<!-- 선언문(Declaration) : 자바 메서드, 변수를 선언하기 위해 사용 -->
	<%! int num3 = 100;%>
	<%! 
		public void print(){
			System.out.println("print!");
		}
	%>
</body>
</html>