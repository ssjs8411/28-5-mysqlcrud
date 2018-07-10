// 18.7.9 최지수
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentScoreDao {
	
	public int deleteStudentScore(int no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("DELETE FROM student_score WHERE student_no=?");
			pstmt.setInt(1, no);
			
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
	
	public int selectScoreAvg() {
		// score의 평균을 구하는 메서드
		// 평균값을 리턴한다
		// 매개변수 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int avg = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT AVG(score) FROM student_score");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avg = rs.getInt("AVG(score)");
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
		
		return avg;
		
	}
	
	public ArrayList<StudentAndScore> selectStudentListAboveAvg(){
		// score의 평균값 이상의 리스트를 조회하는 메서드
		// StudentAndScore의 주소값을 리턴한다(배열)
		// 매개변수 없음

		ArrayList<StudentAndScore> list = new ArrayList<StudentAndScore>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("SELECT student.student_no, student.student_name, student_score.score FROM student_score INNER JOIN student ON student_score.student_no = student.student_no WHERE student_score.score >= (SELECT AVG(score) FROM student_score)");			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				StudentAndScore sas = new StudentAndScore();
				Student s = new Student();
				StudentScore sc = new StudentScore();
				
				s.setStudent_no(rs.getInt("student_no"));
				s.setStudent_name(rs.getString("student_name"));
				sc.setScore(rs.getInt("score"));
				
				sas.setStudent(s);
				sas.setStudentScore(sc);
				
				list.add(sas);
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
		
		
		return list;
		
	}
	
	public ArrayList<StudentAndScore> selectStudentAndScored(){
		// student 테이블과 student_score 테이블이 같이 조회하기 위한 메서드
		// 리턴값 studentAndScore 클래스의 주소값(배열)
		// 매개변수 입력값 없음
		
		ArrayList<StudentAndScore> alsc = new ArrayList<StudentAndScore>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT student_score.student_score_no, student_score.score, student.student_no, student.student_name, student.student_age FROM student_score INNER JOIN student ON student_score.student_no = student.student_no");
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// 조회하여 값이 출력될때까지 반복
				
				StudentAndScore sac = new StudentAndScore();
				Student s = new Student();
				StudentScore sc = new StudentScore();
				
				s.setStudent_no(rs.getInt("student_no"));
				s.setStudent_name(rs.getString("student_name"));
				s.setStudent_age(rs.getInt("student_age"));
				
				sc.setStudent_score_no(rs.getInt("student_score_no"));
				sc.setStudent_no(rs.getInt("student_no"));
				sc.setScore(rs.getInt("score"));
				
				sac.setStudent(s);
				sac.setStudentScore(sc);
				
				alsc.add(sac);
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
		
		return alsc;

	}
	
	public int updateStudentScore(StudentScore sc) {
		// student_score테이블에 중복값이 있으면 입력받은 점수값을 업데이트(덮어쓰기)
		// 리턴값 없음
		// studentScore 클래스의 주소값을 받는다(폼에 입력된 값 받음)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE student_score SET score=? WHERE student_no=?");
			pstmt.setInt(1, sc.getScore());
			pstmt.setInt(2, sc.getStudent_no());
			
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

	public void insertStudentScore(StudentScore sc) {
		// student_score 테이블에 점수를 입력하기 위한 메서드
		// 리턴값 없음
		// StudentScore 클래스의 주소 연결 (폼에 입력된 값 받아 넘기기)
		
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
			pstmt = conn.prepareStatement("INSERT INTO student_score (student_no, score) VALUES (?, ?)");	// student_score 테이블에 insert
			pstmt.setInt(1, sc.getStudent_no());	// 첫번째 ?에 StudentScore클래스 내에 있는 getStudent_no메서드를 호출하여 메서드의 리턴값을 입력
			pstmt.setInt(2, sc.getScore());		// 두번째 ?에 StudentScore클래스 내에 있는 getScore메서드를 호출하여 메서드의 리턴값을 입력
			
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
	}
}
