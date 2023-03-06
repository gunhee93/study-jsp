package sec05.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cget")
public class GetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		ServletContext context = getServletContext();
		
		List<String> member = (List<String>) context.getAttribute("member");
		
		String name = member.get(0);
		int age = Integer.parseInt(member.get(1));
		
		out.print("<html><body>");
		out.print("이름 : " + name + "<br>");
		out.print("나이 : " + age + "<br>");
		out.print("</body></html>");
	}

}
