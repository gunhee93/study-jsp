package sec05.ex01;

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

@WebServlet("/cset")
public class SetServletContext extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// 현재 가지고 있는 servletContext 객체를 가져온다.
		ServletContext context = getServletContext();
		
		List<String> member = new ArrayList<String>();
		member.add("이순신");
		member.add("30");
		
		context.setAttribute("member", member);
		out.print("<html><body>");
		out.print("이순신과 30 설정");
		out.print("</body></html>");
	}

}
