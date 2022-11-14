package test1;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	private DataSource dataFactory;
	private Connection conn;
	private PreparedStatement pstmt;

	public MemberDAO() { //JNDI에 접근 하여 DB연동 246pg
		try {
			Context ctx = new InitialContext();
			Context envContext = (Context) ctx.lookup("java:/comp/env");
			dataFactory = (DataSource) envContext.lookup("jdbc/oracle");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<MemberVO> listMembers() {
		List<MemberVO>  membersList = new ArrayList();
		try {
			conn = dataFactory.getConnection(); //커넥션풀 이용 db연결 246pg
			String query = "select * from  t_member order by joinDate desc";
			System.out.println(query);
			pstmt = conn.prepareStatement(query); //238pg 메서드에 SQL문 전달해 객체 생성
			ResultSet rs = pstmt.executeQuery();  // 메서드 호출해 미리 설정한 SQL문 실행
			while (rs.next()) { 				  //조회한 레코드의 각 컬럼 값 받아 오기
				String id = rs.getString("id");
				String pwd = rs.getString("pwd");
				String name = rs.getString("name");
				String email = rs.getString("email");
				Date joinDate = rs.getDate("joinDate"); 	
				//각 컬럼 값 다시 VO 객체 속성에 설정
				MemberVO memberVO = new MemberVO(id, pwd, name, email, joinDate);
				membersList.add(memberVO);
			}
			rs.close();
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return membersList;
	}

	public void addMember(MemberVO m) {
		try {
			conn = dataFactory.getConnection(); //252pg datasource 이용해 데베 연결
			String id = m.getId();				//테이블에 저장할 회원정보 받아오기
			String pwd = m.getPwd();
			String name = m.getName();
			String email = m.getEmail();
			
			String query = 						//insert문 문자열로 만들기
					"INSERT INTO t_member(id, pwd, name, email)" + 
					" VALUES(?, ? ,? ,?)";
			
			System.out.println(query);
			
			pstmt = conn.prepareStatement(query);
			//insert문의 각 ?의 순서대로 회원 정보 세팅
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			pstmt.setString(3, name);
			pstmt.setString(4, email);
			pstmt.executeUpdate();		//회원 정보 테이블에 추가
			pstmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
