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
		
		// 포워딩 방식 이동
		// 1. RequestDispatcher 활용
		//RequestDispatcher rd = request.getRequestDispatcher("Ex02request2.jsp");
		//rd.forward(request, response);
		
		// 2. pageContext활용 (페이지 흐름 제어)
		//pageContext.forward("Ex02request2.jsp");
		
	%>
	<!-- 3. 액션태그 활용 : JSP 제공, 서버-클라이언트 간 어떤 행동을 취하도록 명령하는 태그 -->
	<jsp:forward page="Ex02request2.jsp" />
	
	
</body>
</html>