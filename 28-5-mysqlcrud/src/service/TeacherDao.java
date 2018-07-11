//이경선
package service;						// service 패키지 내에 있다

import java.sql.Connection;				// Connection 사용위해 import
import java.sql.DriverManager;			// DriverManager 사용위해 import 
import java.sql.PreparedStatement;		// PreparedStatement 사용위해 import 
import java.sql.ResultSet;
import java.sql.SQLException;			// 오류검사 위해 import
import java.util.ArrayList;

public class TeacherDao {				
	
	public int deleteTeacher(int teacher_no) {
		
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
			
			pstmt = conn.prepareStatement("DELETE FROM teacher WHERE teacher_no=?");
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
	
	public void updateTeacher(Teacher t) {
		// Teacher 업데이트를 하기 위한 메서드
		// 리턴 타입 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE teacher SET teacher_name=?, teacher_age=? WHERE teacher_no=?");
			pstmt.setString(1, t.getTeacher_name());
			pstmt.setInt(2, t.getTeacher_age());
			pstmt.setInt(3, t.getTeacher_no());
			
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
	
	
	public Teacher selectUpdateTeacher(int teacher_no) {
		// 수정화면에 정보를 불러오기 위한 메서드
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Teacher t = new Teacher();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT teacher_no, teacher_name, teacher_age FROM teacher WHERE teacher_no=?");
			pstmt.setInt(1, teacher_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				t.setTeacher_no(rs.getInt("teacher_no"));
				t.setTeacher_name(rs.getString("teacher_name"));
				t.setTeacher_age(rs.getInt("teacher_age"));
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
		
		return t;
		
	}
	
	
	public int selectCount() {
		
		// 테이블 내의 데이터 갯수를 구하기 위한 메서드
		// 숫자값을 리턴하기 위해 return data type 은 int type
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int totalRow = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM teacher");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalRow = rs.getInt("COUNT(*)");
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
		
		
		return totalRow;
		
	}
	
	public ArrayList<Teacher> selectTeacherByPage(int page, int pagePerRow, String searchWord){
		
		// 테이블 내 전체 학생의 수를 구하기 위한 메서드
		
		// 쿼리문의 몇번 부터 몇개까지 출력할건지 입력위해 매개변수 2개 전부 int type
		
		ArrayList<Teacher> list = new ArrayList<Teacher>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			if(searchWord.equals("")) {
			sql = "SELECT teacher_no, teacher_name, teacher_age FROM teacher ORDER BY teacher_no LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pagePerRow);
			
			}else{
				sql = "SELECT teacher_no, teacher_name, teacher_age FROM teacher WHERE teacher_name LIKE ? ORDER BY teacher_no LIMIT ?,?";
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, pagePerRow);				
			}
				
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// 조회하여 값이 출력될때까지 반복
				
				Teacher t = new Teacher();
				
				t.setTeacher_no(rs.getInt("teacher_no"));
				t.setTeacher_name(rs.getString("teacher_name"));
				t.setTeacher_age(rs.getInt("teacher_age"));
				
				list.add(t);
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
		
		return list;	// list 최대 pageperRow~1
		
	}
	

	public int insertTeacher(Teacher t)  {			// 접근지정자 public(모든곳에서 접근가능) 
		
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
		pstmt = conn.prepareStatement("INSERT INTO teacher(teacher_name, teacher_age) VALUES (?,?)");	
		pstmt.setString(1, t.getTeacher_name());	
		pstmt.setInt(2, t.getTeacher_age());		
		
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
