package sec03.ex01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/first5")
public class FirstServlet5 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		// (보내고자 하는 url)
		RequestDispatcher dispatch = request.getRequestDispatcher("second5");
		// client가 전송한 요청과 응답에 결과를 다를 서블릿으로 전달
		dispatch.forward(request, response);
		
	}

}
