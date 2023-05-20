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
		session.setAttribute("nickname", "풀스택");
		String nick = (String)session.getAttribute("nickname");
	%>
	<%= nick %> <br />
	${nickname }
	
	<a href="Ex03session2.jsp">2로 이동</a>
</body>
</html>