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
		//-- 쿠키 생성
		// 1. 쿠키 객체 생성 : Cookie(name:String,value:String);
		Cookie cookie = new Cookie("test","testcookie");
		// 2. 생성된 쿠키의 만료날짜를 설정 (초단위)
		cookie.setMaxAge(60*60*24*365); // 1년동안 유지 만들떄마다 갱신
		// 3. 서버에서 생성된 쿠키 -> 클라이언트에 보냄(response)
		response.addCookie(cookie);
		
		response.addCookie(new Cookie("name","강예진"));
		
	%>
	<a href="Ex02GetCookie.jsp">쿠키확인</a>
</body>
</html>