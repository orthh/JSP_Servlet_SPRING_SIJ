<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		box-sizing: border-box;
	}
	table{
			padding: 40px;
	}
</style>
</head>
<body>
	<%
		String name = request.getParameter("name");
		int java = Integer.parseInt(request.getParameter("java"));
		int web = Integer.parseInt(request.getParameter("web"));
		int iot = Integer.parseInt(request.getParameter("iot"));
		int android = Integer.parseInt(request.getParameter("and"));

		double avg = (java + web + iot + android) / 4.0;
		String score;
		if(avg >=95){
			score= "A+";
		}else if(avg >=90){
			score= "A";
		}else if(avg >=85){
			score= "B+";
		}else if(avg >=80){
			score = "B";
		}else{
			score = "F";
		}

	%>
	<h1>랜덤 당첨 게임</h1>
	<fieldset style="width: 300px;">
		<legend>학점확인프로그램</legend>
		<table style="width:300px;">
			<tr>
				<td>이름</td>
				<td><%=name %></td>					
			</tr>
			<tr>
				<td>Java점수</td>
				<td><%=java %></td>					
			</tr>	
			<tr>
				<td>Web점수</td>
				<td><%=web %></td>					
			</tr>					
			<tr>
				<td>IoT점수</td>
				<td><%=iot %></td>					
			</tr>	
			<tr>
				<td>Android점수</td>
				<td><%=android %></td>					
			</tr>
			<tr>
				<td>평균</td>
				<td><%=avg %></td>
			</tr>
			<tr>
				<td>학점</td>
				<td><b><%=score %></b></td>
			</tr>
		</table>
	</fieldset>
</body>
</html>