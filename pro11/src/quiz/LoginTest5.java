package quiz;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login5")
public class LoginTest5 extends HttpServlet {
	ServletContext context = null;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		context = getServletContext();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		List<String> user_list = (List<String>) context.getAttribute("user_list");
		
		if(user_list == null) {
			user_list = new ArrayList<String>();
		}
		
		if(user_id != null) {
			boolean f = true;
			for(int i=0;i<user_list.size();i++) {
				if(user_list.get(i).equals(user_id)) {
					f = false;
					break;
				}
			}
			if(f) {
				user_list.add(user_id);
				context.setAttribute("user_list", user_list);
			} else {
				out.print("<script>");
				out.print("alert('이미 로그인 상태 입니다.');");
				out.print("</script>");
			}
		}
		
		out.print("<head>");
		out.print("<script>");
		out.print("setTimeout('history.go(0);', 5000)");
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 " + user_id + "<br>");
		out.print("총 접속자는 " + LoginImpl5.total_user + "<br>");
		out.print("접속 아이디 : <br>");
		for(int i=0;i<user_list.size();i++) {
			out.print(user_list.get(i) + "<br>");
		}
		out.print("<a href='logout5?user_id="+user_id+"'>로그아웃</a>");
		out.print("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
