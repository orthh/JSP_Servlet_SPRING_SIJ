<%@page import="com.smhrd.model.MyMember"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	MyMember member = (MyMember)session.getAttribute("member");
	
	%>
	<%if(member == null){ %>
	<a href="join.html">
		<button>회원가입</button>
	</a>
	<a href="login.html">
		<button>로그인</button>
	</a>
	<%}else{ %>
		<%=member.getNick()%>님 환영합니다. 
	<%} %>
	
</body>
</html>