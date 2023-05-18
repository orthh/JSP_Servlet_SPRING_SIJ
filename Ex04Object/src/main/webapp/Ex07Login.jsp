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
		String tempId = "smart";
		String tempPwd = "123";
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		String url;
		if(id.equals(tempId) && pwd.equals(tempPwd)){
			// id값을 보내는 방법
			// 1. url에 데이터를 추가해서 요청하는 방법 => 쿼리스트링(Query String)
			// 쿼리스트링 url?key=value&key2=value2
			//url = "Ex07LoginSuccess.jsp?id="+ id; => Redirecting(리다이렉팅)
			url = "Ex07LoginSuccess.jsp";
		}else{
			url = "Ex07LoginFail.jsp";
		}
		//response.sendRedirect(url);
		
		// 2. request객체를 다음 페이지로 넘겨주는 방법(공유하는 방법) => forwarding(포워딩)
		// RequestDispatcher : 클라이언트로부터 최초에 들어온 요청(request)를 
							//원하는 자원으로 넘기는 등의 메소드 가지고 있는 객체
		RequestDispatcher rd = request.getRequestDispatcher(url);
		// 지정한 자원으로 request 객체(response 객체) 넘기기!
		rd.forward(request, response);
	%>
</body>
</html>