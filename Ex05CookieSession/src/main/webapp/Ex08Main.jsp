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
		String id = (String)session.getAttribute("id");
		if(id == null){
			response.sendRedirect("Ex08LoginForm.html");
		}
	%>
	<%=id %>님 환영합니다 <a href="Ex08Logout">로그아웃</a>
</body>
</html>