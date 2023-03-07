package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/show")
public class ShowMember extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession(false);

		if(session != null) {
			Boolean logon = (boolean) session.getAttribute("isLogon");
			if(logon != null && logon) {
				String id = (String) session.getAttribute("user_id");
				String pwd = (String) session.getAttribute("user_pw");
				out.print("<html><body>");
				out.print("<h3>아이디 : " + id + "</h3>");
				out.print("<h3>암호 : " + pwd + "</h3>");
				out.print("<a href='logout'>로그아웃하기</a>");
				out.print("</body></html>");
			} else {
				response.sendRedirect("login2.html");
			}
		}else {
			response.sendRedirect("login2.html");
		}

		out.close();

	}

}
