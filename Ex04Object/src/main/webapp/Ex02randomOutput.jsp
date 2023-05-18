<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body{
	display: flex;
	justify-content: center;
}
h1{
	text-align: center;}
div{
	width: 350px;
	}
	fieldset{
		display: flex;
		flex-direction: column;
		justify-content: center;
		align-items : center;
	
	}
	legend{
		text-align: center;
	}
</style>
</head>
<body>
<div>
<%
		String subject = request.getParameter("subject");
		String[] items = request.getParameterValues("item");
	
		Random rd = new Random();
		int ran = rd.nextInt(items.length);
	%>
	<h1>랜덤 당첨 게임</h1>
	<fieldset>
		<legend>랜덤뽑기결과</legend>
		<p><%=subject %></p>
		<p><%=items[ran] %></p>
	</fieldset>
</div>
	
</body>
</html>