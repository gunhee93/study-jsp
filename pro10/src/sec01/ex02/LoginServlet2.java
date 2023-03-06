package sec01.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login2")
public class LoginServlet2 extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String user_address = request.getParameter("user_address");
		String user_email = request.getParameter("user_email");
		String user_hp = request.getParameter("user_hp");
		
		String data = "아이디 : " + user_id;
		data += "<br>";
		data += "암호 : " + user_pw;
		data += "<br>";
		data += "주소 : " + user_address;
		data += "<br>";
		data += "이메일 : " + user_email;
		data += "<br>";
		data += "전화번호 : " + user_hp;
		data += "<br>";
		
		// 기호가 포함될 경우 URL 로 보낼 떄 완전한 데이터를 처리 하려면 URLEncoder를 사용한다.
		user_address = URLEncoder.encode(user_address, "utf-8");
		
		data += "<a href='/pro10/second?user_id="+user_id+"&user_pw="+user_pw+
				"&user_address="+user_address+"'>두번째 서블릿으로 보내기</a>>";
		out.print(data);
	}

}
