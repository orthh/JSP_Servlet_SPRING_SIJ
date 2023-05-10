

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @~ : 어노테이션(주석) -> 컴파일 될때 한번 확인을함!
// @WebServlet : url-mapping 해줌
@WebServlet("/first")
public class Ex00FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	// 객체 -> 직렬화(자바 바이트 형태 변환)
	// 자바 바이트 형태 -> 객체 (역직렬화)
	// 클래스 자체가 변환 <- 버전
       
    // 생성자 : 객체 생성
	// 이 생성자를 사용해서 객체가 생성되었다고 해서 바로 서블릿의 기능을 수용할 수 있는게
	// 아님!!! (서블릿객체 -> 통신(요청, 응답))
    public Ex00FirstServlet() {
        System.out.println("생성자 호출!");
    }

	// init 메소드 : 객체가 서블릿역할을 할 수 있도록 초기화 시켜주는 역할!
    // 비용이 많이 드는 작업
    // 서버로 요청이 들어올때마다 이 작업을 해줘야된다 -> 비효율적
    // 최초로 요청이 들어오면 객체 -> init 호출 서블릿객체로 초기화시켜줌.
    // 그 다음 요청이 들어올때는 이미 생성되어있는 객체를 그대로 사용
	public void init(ServletConfig config) throws ServletException {
		System.out.println("init 호출!");
	}

	// destroy 메소드 : 서블릿 객체 소멸 (서버 종료, 재시작)
	// 이 메소드가 호출되고 난다음에 요청이 들어오는 경우에는
	// 다시 객체 생성하고 init 호출함.
	public void destroy() {
		System.out.println("destroy 호출!");
	}

	// service 메소드 : 사용자의 요청 처리 / 응답 기능
	// **http요청 메소드 : *GET , *POST (, DELETE , PATCH , PUT)
	// 1. 모든 요청은 service에서 받음
	// 2. GET/POST(요청 메소드)에 따라서 다르게 처리하고 싶은 경우에는
	//    service가 doGet / doPost 메소드가 호출되게 함
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("service 호출!");
		super.service(request, response);
	}

	// http 요청 메소드가 GET일 경우 호출
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("doGET 호출!");
	}

	// http 요청 메소드가 POST일 경우 호출
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		doGet(request, response);
		System.out.println("doPost 호출!");
	}

}
