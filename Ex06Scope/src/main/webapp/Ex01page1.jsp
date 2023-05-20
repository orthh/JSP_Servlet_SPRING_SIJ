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
		// page 영역(scope) 에 저장된 값은 해당 페이지 안에서만 지역변수처럼 사용할 수 있다.
		// page 영역에 저장된 값 -> el(expression language)표기법(ex.${})  사용가능(자바변수는 불가능)
		// setAttribute(key:String, value:Object)
		pageContext.setAttribute("nickname", "풀스택");
		String nick = (String)pageContext.getAttribute("nickname");
		
	%>
	
	nick : <%=nick %><br /> <!-- 풀스택 찍힘 -->
	${nickname }<br />  <!-- 풀스택 찍힘 page영역안에 저장된 key값 지정!pageContext 키 입력시 value가져옴 -->
	${nick }<br /> <!-- 이렇게 못가져옴. -->
	${pageScope.nickname }<br /> <!-- 풀스택 찍힘.(중복사용 위험 있을때) -->
	
	<a href="Ex01page2.jsp">2로 이동</a>
	
</body>
</html>