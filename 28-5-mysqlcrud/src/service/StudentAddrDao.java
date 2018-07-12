// 18.6.25 최지수
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	
	public int deleteStudentAddr(int student_no) {
		// StudentAddr 삭제를 하기 위한 메서드
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
			
			pstmt = conn.prepareStatement("DELETE FROM student_addr WHERE student_no=?");
			pstmt.setInt(1, student_no);
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
	
	public void updateStudentAddr(StudentAddr saddr) {
		// StudentAddr 업데이트를 하기 위한 메서드
		// 리턴 타입 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE student_addr SET student_addr_content=? WHERE student_no=?");
			pstmt.setString(1, saddr.getStudent_addr_content());
			pstmt.setInt(2, saddr.getStudent_no());
			
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
	
	public StudentAddr selectUpdateStudentAddr(int student_no) {
		// 수정화면에 정보를 불러오기 위한 메서드
		// StudentAddr 클래스의 주소값 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		StudentAddr saddr = new StudentAddr();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT student_addr_no, student_no, student_addr_content FROM student_addr WHERE student_no=?");
			pstmt.setInt(1, student_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				saddr.setStudent_addr_no(rs.getInt("student_addr_no"));
				saddr.setStudent_no(rs.getInt("student_no"));
				saddr.setStudent_addr_content(rs.getString("student_addr_content"));
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
		
		return saddr;
		
	}
	
	public ArrayList<StudentAddr> selectStudentAddrList(int student_no){
		// 받아온 student_no의 값을 조회하여 한명의 주소 조회하는 메서드
		// studentAddr 클래스의 주소값을 리턴(배열)
		// student_no의 값을 받아서 쿼리문 작성
		
		ArrayList<StudentAddr> alsa = new ArrayList<StudentAddr>();
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		ResultSet rs = null;
		
		try {
			// 1단계: 드라이버로딩
				Class.forName("com.mysql.jdbc.Driver");
			
			// 2단계: DB연결
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
						
			// 3단계: 쿼리 실행준비(쿼리문 작성)
				
				pstmt = conn.prepareStatement("SELECT student_addr_no, student_no, student_addr_content FROM student_addr WHERE student_no=?");
				pstmt.setInt(1, student_no);
				
			// 4단계 : 쿼리 실행
				rs = pstmt.executeQuery();
				
			// 5단계 : 쿼리 실행결과 사용
				while(rs.next()) {
					StudentAddr sa = new StudentAddr();
					sa.setStudent_addr_no(rs.getInt("student_addr_no"));
					sa.setStudent_no(rs.getInt("student_no"));
					sa.setStudent_addr_content(rs.getString("student_addr_content"));
					
					alsa.add(sa);
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
		
		return alsa;
		
	}
	public StudentAddr selectStudentAddr(int student_no) {
		
		// 받아온 student_no의 값을 조회하여 한명의 주소 조회하는 메서드
		// StudentAddr 클래스의 주소값을 리턴
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		ResultSet rs = null;
		StudentAddr saddr = new StudentAddr();
		
		try {
			// 1단계: 드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2단계: DB연결
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
			
			// 3단계: 쿼리 실행준비(쿼리문 작성)
			pstmt = conn.prepareStatement("SELECT student_addr_no, student_no, student_addr_content FROM student_addr WHERE student_no=?");
			pstmt.setInt(1, student_no);
			
			// 4단계 : 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 5단계 : 쿼리 실행결과 사용
			if(rs.next()) {
				
				saddr.setStudent_addr_no(rs.getInt("student_addr_no"));
				saddr.setStudent_no(rs.getInt("student_no"));
				saddr.setStudent_addr_content(rs.getString("student_addr_content"));
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
		
		return saddr;
		
	}

	public int insertStudentAddr(StudentAddr saddr)  {			// 접근지정자 public(모든곳에서 접근가능) 
		
		 // 한명의 Student(Addr)를 입력하기 위한 메서드
		 // 매개변수 data type(Student),	매개변수명: s
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

			pstmt = conn.prepareStatement("INSERT INTO student_addr (student_no, student_addr_content) VALUES (?, ?)");	// studentAddr 테이블에 insert
			pstmt.setInt(1, saddr.getStudent_no());	// 첫번째 ?에 Student클래스 내에 있는 getStudent_name메서드를 호출하여 메서드의 리턴값을 입력
			pstmt.setString(2, saddr.getStudent_addr_content());		// 두번째 ?에 Student클래스 내에 있는 getStudent_age메서드를 호출하여 메서드의 리턴값을 입력
			
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
