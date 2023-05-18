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
	flex-direction: column;
	justify-content: center;
	align-items: center;
}
	form{
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
	input{
		margin-top: 5px;
	}
</style>
</head>
<body>
	<%
		int num = Integer.parseInt(request.getParameter("num"));
	%>
	<h1>랜덤 당첨 게임</h1>
	<form action="Ex02randomOutput.jsp">
		<fieldset>
			<legend>랜덤뽑기</legend>
			<table>
				<tr>
					<td>주제 : </td>
					<td><input type="text" name="subject" /></td>
				</tr>
				<%
					for(int i=1; i<=num; i++){
						out.print("<tr><td>아이템 : </td> <td><input type='text' name='item' /></td></tr>");
					}
				%>
				
			</table>
			
			<input type="submit" value="랜덤뽑기" />
		</fieldset>
	</form>
	
</body>
</html>