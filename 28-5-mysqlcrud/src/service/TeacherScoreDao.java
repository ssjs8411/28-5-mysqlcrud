// 7.10 이경선
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

	public class TeacherScoreDao {
	
	public int selectScoreAvg() {
		//score 평균을 구하는 메서드
		
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
			
			pstmt = conn.prepareStatement("SELECT AVG(score) FROM teacher_score");
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				avg= rs.getInt("AVG(score)");
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
	public ArrayList<TeacherAndScore> selectTeacherListAboveAvg(){
		//평균점수 이상인 사람을 구하는 메소드
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<TeacherAndScore> list = new ArrayList<TeacherAndScore>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT teacher.teacher_no, teacher.teacher_name, teacher_score.score FROM teacher_score INNER JOIN teacher ON teacher_score.teacher_no = teacher.teacher_no WHERE teacher_score.score >= (SELECT AVG(score) FROM teacher_score)");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Teacher t = new Teacher();
				TeacherScore ts = new TeacherScore();
				TeacherAndScore tas = new TeacherAndScore(); 
				
				t.setTeacher_no(rs.getInt("teacher_no"));
				t.setTeacher_name(rs.getString("teacher_name"));
				

				ts.setScore(rs.getInt("score"));
				
				tas.setTeacher(t);
				tas.setTeacherScore(ts);
				
				list.add(tas);
				
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
	
	public ArrayList<TeacherAndScore> selectTeacherAndScored(){
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			ArrayList<TeacherAndScore> list = new ArrayList<TeacherAndScore>();
			
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("SELECT teacher_score.teacher_score_no, teacher_score.score, teacher.teacher_no, teacher.teacher_name, teacher.teacher_age FROM teacher_score INNER JOIN teacher ON teacher_score.teacher_no = teacher.teacher_no");
				
				rs = pstmt.executeQuery();
			
			while(rs.next()) {
				Teacher t = new Teacher();
				TeacherScore ts = new TeacherScore();
				TeacherAndScore tas = new TeacherAndScore(); 
				
				t.setTeacher_no(rs.getInt("teacher_no"));
				t.setTeacher_name(rs.getString("teacher_name"));
				t.setTeacher_age(rs.getInt("teacher_age"));
				
				ts.setTeacher_score_no(rs.getInt("teacher_Score_no"));
				ts.setTeacher_no(rs.getInt("teacher_no"));
				ts.setScore(rs.getInt("score"));
				
				tas.setTeacher(t);
				tas.setTeacherScore(ts);
				
				list.add(tas);
				
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
		public int updateTeacherScore(TeacherScore ts) {
			Connection conn = null;
			PreparedStatement pstmt = null;
			int check =0;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("UPDATE teacher_score SET score=? WHERE teacher_no=?");
				pstmt.setInt(1, ts.getScore());
				pstmt.setInt(2, ts.getTeacher_no());
				check = pstmt.executeUpdate();
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
			
			return check;
			
		}
		public void insertTeacherScore(TeacherScore ts) {
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			try {
				Class.forName("com.mysql.jdbc.Driver");
				
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
				
				pstmt = conn.prepareStatement("INSERT INTO teacher_score(teacher_no, score) VALUES(?,?)");
				pstmt.setInt(1, ts.getTeacher_no());
				pstmt.setInt(2, ts.getScore());
				
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