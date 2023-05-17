<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<%
				for(int i=1; i<=10; i++){
					out.print("<td>" + i + "</td>");
				}
			%>
			<%
				StringBuilder sb = new StringBuilder();
				for(int i=11; i<=20; i++){
					sb.append("<td>" + i + "</td>");
				}
			%>
			<%= sb.toString() %>
			
			<%for(int i=21; i<=30; i++){%>
			   <td><%=i %></td>
			<%} %>
		</tr>
	</table>
	
	
</body>
</html>