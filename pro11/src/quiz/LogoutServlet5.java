package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout5")
public class LogoutServlet5 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		List<String> user_list = (List<String>) context.getAttribute("user_list");
		
		String user_id = request.getParameter("user_id");
		
		for(String user : user_list) {
			System.out.println(user);
		}
		
		context.setAttribute("user_list", user_list);
		
		out.print("로그아웃이 처리되었습니다.");
		out.print("<a href='/pro10/login2.html'>로그인 하기</a>");
	}

}
