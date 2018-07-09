package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherAddrDao {
	
	public int deleteTeacherAddr(int teacher_no) {
		
		// 리턴 int, 쿼리 실행결과값 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("DELETE FROM teacher_addr WHERE teacher_no=?");
			pstmt.setInt(1, teacher_no);
			check = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return check;
		
	}
	
	public void updateTeacherAddr(TeacherAddr taddr) {
		
		// 리턴 타입 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE teacher_addr SET teacher_addr_content=? WHERE teacher_no=?");
			pstmt.setString(1, taddr.getTeacher_addr_content());
			pstmt.setInt(2, taddr.getTeacher_no());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
	}
	
	public TeacherAddr selectUpdateTeacherAddr(int teacher_no) {
		// 수정화면에 정보를 불러오기 위한 메서드
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TeacherAddr taddr = new TeacherAddr();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT teacher_addr_no, teacher_no, teacher_addr_content FROM teacher_addr WHERE teacher_no=?");
			pstmt.setInt(1, teacher_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				taddr.setTeacher_addr_no(rs.getInt("teacher_addr_no"));
				taddr.setTeacher_no(rs.getInt("teacher_no"));
				taddr.setTeacher_addr_content(rs.getString("teacher_addr_content"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return taddr;
		
	}
	
	public TeacherAddr selectTeacherAddr(int teacher_no) {
		
		
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		ResultSet rs = null;
		TeacherAddr taddr = new TeacherAddr();
		
		try {
			// 1단계: 드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2단계: DB연결
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
			
			// 3단계: 쿼리 실행준비(쿼리문 작성)
			pstmt = conn.prepareStatement("SELECT teacher_addr_no, teacher_no, teacher_addr_content FROM teacher_addr WHERE teacher_no=?");
			pstmt.setInt(1, teacher_no);
			
			// 4단계 : 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 5단계 : 쿼리 실행결과 사용
			if(rs.next()) {
				
				taddr.setTeacher_addr_no(rs.getInt("teacher_addr_no"));
				taddr.setTeacher_no(rs.getInt("teacher_no"));
				taddr.setTeacher_addr_content(rs.getString("teacher_addr_content"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return taddr;
		
	}

	public int insertTeacherAddr(TeacherAddr taddr)  {			// 접근지정자 public(모든곳에서 접근가능) 
		
		
		 // return data type : int(숫자) -> 쿼리문 실행하여 실행이 되면 1, 실행이 안되면 0으로 받을수도 있음
		 
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화

		
		try{		// 오류가 발생할수도 있음 오류가 발생하면 catch에서 처리
		
		// 1단계: 드라이버로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계: DB연결
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
		
		// 3단계: 쿼리 실행준비(쿼리문 작성)

			pstmt = conn.prepareStatement("INSERT INTO teacher_addr (teacher_no, teacher_addr_content) VALUES (?, ?)");
			pstmt.setInt(1, taddr.getTeacher_no());	
			pstmt.setString(2, taddr.getTeacher_addr_content());		
			
			// 4단계: 쿼리실행
			pstmt.executeUpdate();			
		
		
		}  catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		return 0;
		
	}
}
