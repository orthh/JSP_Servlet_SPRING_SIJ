<%@page import="java.sql.SQLException"%>
<%@page import="com.smhrd.model.FullStack"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- WEB MVC MODEL 1 : 비지니스로직(Controller), 화면 표현(View) -> JPS 로 작성-->
<!-- DB연동(JDBC) -->
<%		
    Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	FullStack fs = null;
	try{
		// 오라클과 연결할 드라이버 가지고 오기 (동적 로딩)
		Class.forName("oracle.jdbc.OracleDriver");

		// 지정한 데이터베이스와 연결하기 위한 객체(Connection) 생성
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "service";
		String password = "12345";
		
		conn = DriverManager.getConnection(url,user,password);
		
		String sql = "SELECT *" 
				    +"  FROM fullstack" 
				    +" WHERE name = ?";
		// sql 쿼리문을 다루기 위한 객체(PreparedStatement) 생성 : 완성, 실행 등
		ps = conn.prepareStatement(sql);
		
		// ? 자리 채우기 : 1번부터
		ps.setString(1, "선영표");
		
		// INSERT, DELETE, UPDATE -> executeUpdate() -> int(몇개 행이 update되는지) 타입 반환
		// SELECT(READ) -> executeQuery() -> ResultSet(읽어온 데이터, 커서) 타입 반환
		// sql문 실행
		rs = ps.executeQuery();
		
		if(rs.next()){ // next() -> true(커서가 가리키고 있는 행에 데이터가 있음) / false(없음)
			String name = rs.getString("name"); // 컬럼이름 지정
			String major = rs.getString(2); // 테이블 상 2번째 컬럼값
			String phone = rs.getString("phone");
			
			fs = new FullStack(name, major, phone);
			
		}
	}catch (ClassNotFoundException e){
		// OracleDriver 가지고 올때 경로가 잘못됐을 경우
		System.out.println("OracleDriver 클래스 못찾음!");
	}catch(SQLException e){
		System.out.println("sql 예외 발생!");
	}catch(Exception e){
		System.out.println("다른 예외 발생!");
		e.printStackTrace(); // 원인, 발생하게 된 절차
	}finally{ // 예외 상황이 발생 하던지 하지않던지 무조건 실행!
		// 사용한 자원 반환(생성한 순서 반대로!)
		try{
			rs.close();
			ps.close();
			conn.close();
		}catch(Exception e){
			System.out.println("finally에서 예외상황 발생");
			e.printStackTrace();
		}

	}
	
%>

이름 : <%=fs.getName() %> <br />
전공 : <%=fs.getMajor() %> <br />
전화번호 : <%=fs.getPhone() %> <br />
</body>
</html>