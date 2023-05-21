<%@page import="java.util.ArrayList"%>
<%@page import="com.smhrd.model.FullStack"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
</style>
</head>
<body>
<!-- 세션안에 저장되어있는 학생정보(3명) 테이블 출력 -->
	
<%
	ArrayList<FullStack>  fs = (ArrayList<FullStack>)session.getAttribute("studentlist");
%>

<table border="1px">
	<tr>
		<th>이름</th>
		<th>전공</th>
		<th>번호</th>
	</tr>
	<%
		for(int i=0; i<fs.size(); i++){
			out.print("<tr>");		
			out.print("<td>"+fs.get(i).getName()+"</td>");
			out.print("<td>"+fs.get(i).getMajor()+"</td>");
			out.print("<td>"+fs.get(i).getPhone()+"</td>");
			out.print("</tr>");		
		}

	%>
</table>

</body>
</html>