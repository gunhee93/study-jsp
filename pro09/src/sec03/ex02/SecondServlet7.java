package sec03.ex02;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/second7")
public class SecondServlet7 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
	
		String adress = (String) request.getAttribute("adress");
		out.println("<html><body>");
		out.println("주소 : " + adress + "<br>");
		out.println("redirect를 이용한 바인딩 실습");
		out.println("</body></html>");
	}

}
