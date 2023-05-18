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
		// redirect 기능 - Response
		// 현재 실행중인 jsp 페이지의 실행을 중단하고
		// 다른 페이지가 대신 호출되도록 만들어줌!
		//response.sendRedirect("Ex02createInput.html");
	
		String url = request.getParameter("url");
		
		String move = null;
		if(url.equals("네이버")){
			move = "https://www.naver.com";
		}else if(url.equals("다음")){
			move = "https://www.daum.net";
		}else if(url.equals("구글")){
			move = "https://www.google.com";
		}
		response.sendRedirect(move);
	%>
</body>
</html>