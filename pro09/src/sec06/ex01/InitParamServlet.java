package sec06.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = { 
				"/sinit", 
				"/sinit2"
		}, 
		initParams = { 
				@WebInitParam(name = "email", value = "admin@test.com"), 
				@WebInitParam(name = "tel", value = "010-1111-2222")
		})
public class InitParamServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		String email = getInitParameter("email");
		String tel = getInitParameter("tel");
		
		out.println("<html><body>");
		out.println("<table><tr>");
		out.print("<td>email</td><td>" + email + "</td></tr>");
		out.print("<tr><td>전화번호</td><td>" + tel + "</td></tr>");
//		out.print("<tr><td>주소</td><td>" + address + "</td></tr>");
//		out.print("<tr><td>이름</td><td>" + name + "</td></tr>");
		out.print("</table></body></html>");
		
		out.close();
	}

}
