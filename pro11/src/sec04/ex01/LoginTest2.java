package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionBindingEvent;


@WebServlet("/login2")
public class LoginTest2 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl loginUser = new LoginImpl(user_id, user_pw);
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
		}
		
		out.print("<head>");
		out.print("<script>");
		out.print("setTimeout('history.go(0);', 5000");
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 " + loginUser.user_id + "<br>");
		out.print("총 접속자는 " + LoginImpl.total_user + "<br>");
		out.print("<a href='logout'>로그아웃</a>");

		out.print("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
