package sec04.ex02;

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


@WebServlet("/logout3")
public class LogoutServlet3 extends HttpServlet {


    public LogoutServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		LoginImpl3 loginUser = (LoginImpl3) session.getAttribute("loginUser");
		
		ServletContext context = getServletContext();
		
		List<String> user_list = (List<String>) context.getAttribute("user_list");
		
		user_list.remove(loginUser.user_id);
		
		session.removeAttribute("loginUser");
		
		response.sendRedirect("login3");
	}


}
