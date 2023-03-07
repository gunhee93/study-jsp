package quiz2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login6")
public class LoginTest6 extends HttpServlet {
	ServletContext context = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		context = getServletContext();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		Map<String, Integer> user_list = 
				(Map<String, Integer>) context.getAttribute("user_list");
		
		if(user_list == null) {
			user_list = new HashMap<String, Integer>();
		}
		
		int loginSum = 0;
		// 로그인된 아이디가 값이 있으면
		if(user_list.containsKey(user_id)) {
			loginSum = user_list.get(user_id) + 1;
			
			if(loginSum > 2) {
				out.print("<script>");
				out.print("alert('같은 아이디로 2번 이상 로그인 했습니다.');");
				out.print("location.href='/pro10/login2.html';");
				out.print("</script>");
			} else {
				user_list.remove(user_id);
				user_list.put(user_id, loginSum);
				context.setAttribute("user_list", user_list);
			}
		} else { // 로그인이 되어 있지 않으면 
			if(user_id != null) {
				user_list.put(user_id, 1);
				context.setAttribute("user_list", user_list);
			}
		}
		
		out.print("<body>");
		out.print("아이디는 " + user_id + "<br>");
		out.print("접속자 : <br>");
		Set<String> user = user_list.keySet();
		
		for(String u : user ) {
			out.print(u + "<br>");
		}

		out.print("<a href='logout6?user_id="+user_id+"'>로그아웃</a>");
		out.print("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}