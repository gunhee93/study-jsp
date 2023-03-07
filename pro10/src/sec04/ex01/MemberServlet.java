package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/login5")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();

		HttpSession session = request.getSession();

		MemberDAO dao = new MemberDAO();

		String id = request.getParameter("user_id");
		String pwd = request.getParameter("user_pw");

		boolean  result = dao.isExisted(id, pwd);
		if(result) {
			session.setAttribute("isLogon", id);
			session.setAttribute("user_id", id);
			session.setAttribute("user_pw", pwd);

			out.print("<html><body>");
			out.print("<h3>" + id + "님 환영합니다.</h3>");
			out.print("<a href='show'>회원정보 보기</a>");
			out.print("</body></html>");
		} else {
			out.print("<html><body>");
			out.print("<h3>로그인에 실패하였습니다.</h3>");
			out.print("<a href='/pro10/login2.html'>다시 로그인하기</a>");
			out.print("</body></html>");
		}
	}
}


