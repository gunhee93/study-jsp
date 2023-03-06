package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/second")
public class SecondServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		
		if(user_id != null && user_id.length() != 0) {
			out.print("이미 로그인 한 상태입니다<br><br>");
			out.print("첫번째 서블릿에서 넘거준 아이디 : " + user_id + "<br>");
			out.print("첫번째 서블릿에서 넘거준 암호 : " + user_pw + "<br>");
			out.print("첫번째 서블릿에서 넘거준 주소 : " + user_address + "<br>");
			
		} else {
			out.print("로그인하지 않았습니다");
			out.print("다시 로그인 하세요");
			out.print("<a href='/pro10/login.html'>로그인창으로 이동하기</a>");
		}
	}

}
