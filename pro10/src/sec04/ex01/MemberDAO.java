package sec04.ex01;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	private DataSource dataFactory;
	
	public MemberDAO() {
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberDTO> listMembers() {
		// TODO Auto-generated method stub
		List<MemberDTO> membersList = new ArrayList<MemberDTO>();
		try {
			con = dataFactory.getConnection();
			String sql = "select * from t_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				MemberDTO m = new MemberDTO();
				m.setId(rs.getString(1));
				m.setPwd(rs.getString(2));
				m.setName(rs.getString(3));
				m.setEmail(rs.getString(4));
				m.setJoinDate(rs.getDate(5));
				membersList.add(m);
			}
			rs.close();
			pstmt.close();
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return membersList;
	}

	public void addMember(MemberDTO member) {
		// TODO Auto-generated method stub
		try {
			con = dataFactory.getConnection();
			
			String sql = "insert into t_member values(?,?,?,?,sysdate)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPwd());
			pstmt.setString(3, member.getName());
			pstmt.setString(4, member.getEmail());
			
			int result = pstmt.executeUpdate();
			System.out.println("저장 : " + result);
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void delMember(String id) {
		// TODO Auto-generated method stub
		try {
			con = dataFactory.getConnection();
			
			String sql = "delete from t_member where id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			
			int result = pstmt.executeUpdate();
			System.out.println("삭제 : " + result);
			
			pstmt.close();
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isExisted(String id, String pwd) {
		// TODO Auto-generated method stub
		boolean result = false;
		try {
			con = dataFactory.getConnection();
			
			String sql = "select decode(count(*),1,'true','false') from t_member where id=? and pwd=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			
			rs = pstmt.executeQuery();
			
			rs.next();
			result = Boolean.parseBoolean(rs.getString(1));
		}catch(Exception e) {
			e.printStackTrace();
		}
		return result;
	}
}


