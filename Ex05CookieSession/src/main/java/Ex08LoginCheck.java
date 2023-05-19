

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Ex08LoginCheck")
public class Ex08LoginCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		String tempId = "test";
		String tempPwd = "12345";
		
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		
		if(id.equals(tempId) && pwd.equals(tempPwd)) {
			HttpSession session = request.getSession();
			session.setAttribute("id", id);
			response.sendRedirect("Ex08Main.jsp");
		}else {
			response.sendRedirect("Ex08LoginForm.html");
		}
		
	}

}
