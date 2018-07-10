// 18.7.9 최지수
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployedScoreDao {
	
	public int deleteEmployedScore(int no) {
		// employed_score 테이블의 정보를 삭제하는 메서드
		// 쿼리 실행 결과값 리턴
		// 매개변수 employed_no의 값
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("DELETE FROM employed_score WHERE employed_no=?");
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
			
			pstmt = conn.prepareStatement("SELECT AVG(employed_score) FROM employed_score");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				avg = rs.getInt("AVG(employed_score)");
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
	
	public ArrayList<EmployedAndScore> selectEmployedListAboveAvg(){
		// score의 평균값 이상의 리스트를 조회하는 메서드
		// EmployedAndScore의 주소값을 리턴한다(배열)
		// 매개변수 없음

		ArrayList<EmployedAndScore> list = new ArrayList<EmployedAndScore>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			pstmt = conn.prepareStatement("SELECT employed.employed_no, employed.employed_name, employed_score.employed_score FROM employed_score INNER JOIN employed ON employed_score.employed_no = employed.employed_no WHERE employed_score.employed_score >= (SELECT AVG(employed_score) FROM employed_score)");			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				EmployedAndScore eas = new EmployedAndScore();
				Employed e = new Employed();
				EmployedScore ec = new EmployedScore();
				
				e.setEmployed_no(rs.getInt("employed_no"));
				e.setEmployed_name(rs.getString("employed_name"));
				ec.setEmployed_score(rs.getInt("employed_score"));
				
				eas.setEmployed(e);
				eas.setEmployedScore(ec);
				
				list.add(eas);
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
	
	public ArrayList<EmployedAndScore> selectEmployedAndScored(){
		// Employed 테이블과 Employed_score 테이블이 같이 조회하기 위한 메서드
		// 리턴값 EmployedAndScore 클래스의 주소값(배열)
		// 매개변수 입력값 없음
		
		ArrayList<EmployedAndScore> alesc = new ArrayList<EmployedAndScore>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT employed_score.employed_score_no, employed_score.employed_score, employed.employed_no, employed.employed_name, employed.employed_age FROM employed_score INNER JOIN employed ON employed_score.employed_no = employed.employed_no");
		
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// 조회하여 값이 출력될때까지 반복
				
				EmployedAndScore eac = new EmployedAndScore();
				Employed e = new Employed();
				EmployedScore es = new EmployedScore();
				
				e.setEmployed_no(rs.getInt("employed_no"));
				e.setEmployed_name(rs.getString("employed_name"));
				e.setEmployed_age(rs.getInt("employed_age"));
				
				es.setEmployed_score_no(rs.getInt("employed_score_no"));
				es.setEmployed_no(rs.getInt("employed_no"));
				es.setEmployed_score(rs.getInt("employed_score"));
				
				eac.setEmployed(e);
				eac.setEmployedScore(es);
				
				alesc.add(eac);
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
		
		return alesc;

	}
	
	public int updateEmployedScore(EmployedScore es) {
		// employed_score테이블에 중복값이 있으면 입력받은 점수값을 업데이트(덮어쓰기)
		// 리턴값 없음
		// employedScore 클래스의 주소값을 받는다(폼에 입력된 값 받음)
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE employed_score SET employed_score=? WHERE employed_no=?");
			pstmt.setInt(1, es.getEmployed_score());
			pstmt.setInt(2, es.getEmployed_no());
			
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

	public void insertEmployedScore(EmployedScore es) {
		// employed_score 테이블에 점수를 입력하기 위한 메서드
		// 리턴값 없음
		// EmployedScore 클래스의 주소 연결 (폼에 입력된 값 받아 넘기기)
		
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
			pstmt = conn.prepareStatement("INSERT INTO employed_score (employed_no, employed_score) VALUES (?, ?)");	// employed_score 테이블에 insert
			pstmt.setInt(1, es.getEmployed_no());	// 첫번째 ?에 EmployedScore클래스 내에 있는 getEmployed_no메서드를 호출하여 메서드의 리턴값을 입력
			pstmt.setInt(2, es.getEmployed_score());		// 두번째 ?에 EmployedScore클래스 내에 있는 getEmployed_score메서드를 호출하여 메서드의 리턴값을 입력
			
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
