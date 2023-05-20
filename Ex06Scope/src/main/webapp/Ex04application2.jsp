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
		String nick = (String)application.getAttribute("nickname");
		
	%>
	<%=nick %> <br />
	<b>${nickname}</b> <br />
	${applicationScope.nickname }
</body>
</html>