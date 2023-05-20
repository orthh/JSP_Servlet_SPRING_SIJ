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
		request.setAttribute("nickname", "풀스택");
		String nick = (String)request.getAttribute("nickname");
		
		//pageContext.setAttribute("nickname", "풀스택22");
		//String nick1 = (String)pageContext.getAttribute("nickname");
	%>
	
	<%=nick %> <br />
	${nickname }<br /> <!-- 2개 이상의 영역에서 같은 name값을 사용하면 더 좁은 영역의 값을 가지고옴! -->
	${requestScope.nickname }
	
	<!-- 2로 이동 누를때 클라이언트는 재요청임(즉 request객체가 다름) -->
	<a href="Ex02request2.jsp">2로 이동</a>
</body>
</html>