package quiz2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/logout6")
public class LogoutServlet6 extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		Map<String, Integer> user_list=  (Map<String, Integer>) context.getAttribute("user_list");
		
		String user_id = request.getParameter("user_id");
		
		if(user_list.containsKey(user_id)) {
			int loginSum = user_list.get(user_id);
			loginSum--;
			if(loginSum < 0) {
				loginSum = 0;
			}
			user_list.remove(user_id);
			user_list.put(user_id, loginSum);
		}
		
		context.setAttribute("user_list", user_list);
		
		out.print("로그아웃이 처리되었습니다.");
		out.print("<a href='/pro10/login2.html'>로그인 하기</a>");
	}

}