package sec01.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.listMembers();
		
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일자</td></tr>");
		
		for(MemberDTO m : memberList) {
			out.print("<tr><td>" + m.getId() + "</td>");
			out.print("<td>" + m.getPwd() + "</td>");
			out.print("<td>" + m.getName() + "</td>");
			out.print("<td>" + m.getEmail() + "</td>");
			out.print("<td>" + m.getJoinDate() + "</td></tr>");
		}
		out.print("</table></body></html>");
	}

}
