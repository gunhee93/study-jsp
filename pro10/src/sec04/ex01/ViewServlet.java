package sec04.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/viewMembers")
public class ViewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		
		List<MemberDTO> memberList = (List<MemberDTO>) request.getAttribute("membersList");
		out.print("<html><body>");
		out.print("<table border='1'>");
		out.print("<tr align='center' bgcolor='lightgreen'>");
		out.print("<td>아이디</td><td>비밀번호</td><td>이름</td><td>이메일</td><td>가입일자</td><td>삭제</td></tr>");
		
		for(MemberDTO m : memberList) {
			out.print("<tr><td>" + m.getId() + "</td>");
			out.print("<td>" + m.getPwd() + "</td>");
			out.print("<td>" + m.getName() + "</td>");
			out.print("<td>" + m.getEmail() + "</td>");
			out.print("<td>" + m.getJoinDate() + "</td>");
			out.print("<td><a href='/pro07/member3?command=delMember&id="+m.getId()+"'>삭제</a></td></tr>");
		}
		out.print("</table>");
		out.print("<a href='/pro07/MemberForm.html'>새 회원 등록하기</a>");
		out.print("</body></html>");
	}

}