package sec02.ex02;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/member3")
public class MemberServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doHandle(req, resp);
	}

	public void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		MemberDAO dao = new MemberDAO();
				
		PrintWriter out = response.getWriter();
		
		String command = request.getParameter("command");
		if(command != null && command.equals("addMember")) {
			MemberDTO member = new MemberDTO();
			member.setId(request.getParameter("id"));
			member.setPwd(request.getParameter("pwd"));
			member.setName(request.getParameter("name"));
			member.setEmail(request.getParameter("email"));
			
			dao.addMember(member);
		} else if(command != null && command.equals("delMember")) {
			String id = request.getParameter("id");
			
			dao.delMember(id);
		}
		
		List<MemberDTO> memberList = dao.listMembers();
		
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
			out.print("<td><a href='/pro08/member3?command=delMember&id="+m.getId()+"'>삭제</a></td></tr>");
		}
		
		
		out.print("</table>");
		out.print("<a href=' /pro08/MemberForm.html'>새 회원 등록하기</a>");
		out.print("</body></html>");
	}
	
}
