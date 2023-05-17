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
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		String ope = request.getParameter("ope");
		
		int result = 0;
		switch(ope){
		case "+" :
			result = num1 + num2;
			break;
		case "-" :
			result = num1 - num2;
			break;
		case "*" :
			result = num1 * num2;
			break;
		case "/" :
			result = num1 / num2;
			break;
		default : 
			
			break;
		}
		out.print(num1+ope+num2+"="+result);
	%>
	<p><%=num1 %> <%=ope %> <%=num2 %> = <%=result %></p>
	<p><%=num1+ope+num2+ "=" + result %></p>
</body>
</html>