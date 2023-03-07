package sec04.ex02;

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
import javax.servlet.http.HttpSessionBindingEvent;


@WebServlet("/login3")
public class LoginTest3 extends HttpServlet {
	List<String> user_list = null;
	ServletContext context = null;
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		
		HttpSession session = request.getSession();
		context = getServletContext();
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		LoginImpl3 loginUser = new LoginImpl3(user_id, user_pw);
		
		
		if(session.isNew()) {
			session.setAttribute("loginUser", loginUser);
						
			if(user_list == null) {
				user_list = new ArrayList<String>();
			}
			user_list.add(user_id);
			context.setAttribute("user_list", user_list);
		}
		
		out.print("<head>");
		out.print("<script>");
		out.print("setTimeout('history.go(0);', 5000");
		out.print("</script>");
		out.print("</head>");
		out.print("<body>");
		out.print("아이디는 " + loginUser.user_id + "<br>");
		out.print("총 접속자는 " + LoginImpl3.total_user + "<br>");
		out.print("접속 아이디 : <br>");
		user_list = (List<String>) context.getAttribute("user_list");
		for(int i=0;i<user_list.size();i++) {
			out.println(user_list.get(i) + "<br>");
		}
		out.print("<a href='logout3'>로그아웃</a>");
		out.print("</body>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
