// 18.7.9 ������
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return check;
		
	}
	
	public int selectScoreAvg() {
		// score�� ����� ���ϴ� �޼���
		// ��հ��� �����Ѵ�
		// �Ű����� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return avg;
		
	}
	
	public ArrayList<StudentAndScore> selectStudentListAboveAvg(){
		// score�� ��հ� �̻��� ����Ʈ�� ��ȸ�ϴ� �޼���
		// StudentAndScore�� �ּҰ��� �����Ѵ�(�迭)
		// �Ű����� ����

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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		
		return list;
		
	}
	
	public ArrayList<StudentAndScore> selectStudentAndScored(){
		// student ���̺�� student_score ���̺��� ���� ��ȸ�ϱ� ���� �޼���
		// ���ϰ� studentAndScore Ŭ������ �ּҰ�(�迭)
		// �Ű����� �Է°� ����
		
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
			
			while(rs.next()) {	// ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�
				
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return alsc;

	}
	
	public int updateStudentScore(StudentScore sc) {
		// student_score���̺� �ߺ����� ������ �Է¹��� �������� ������Ʈ(�����)
		// ���ϰ� ����
		// studentScore Ŭ������ �ּҰ��� �޴´�(���� �Էµ� �� ����)
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return check;
	}

	public void insertStudentScore(StudentScore sc) {
		// student_score ���̺� ������ �Է��ϱ� ���� �޼���
		// ���ϰ� ����
		// StudentScore Ŭ������ �ּ� ���� (���� �Էµ� �� �޾� �ѱ��)
		
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		
		try{		// ������ �߻��Ҽ��� ���� ������ �߻��ϸ� catch���� ó��
			
			// 1�ܰ�: ����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ�: DB����
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
			
			// 3�ܰ�: ���� �����غ�(������ �ۼ�)
			pstmt = conn.prepareStatement("INSERT INTO student_score (student_no, score) VALUES (?, ?)");	// student_score ���̺� insert
			pstmt.setInt(1, sc.getStudent_no());	// ù��° ?�� StudentScoreŬ���� ���� �ִ� getStudent_no�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			pstmt.setInt(2, sc.getScore());		// �ι�° ?�� StudentScoreŬ���� ���� �ִ� getScore�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			
			// 4�ܰ�: ��������
			pstmt.executeUpdate();			
			
			
			}  catch (SQLException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally {
				
				// ��ü ����(������� �Ųٷ� ��������ش�)
				if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
				if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
				
			}
	}
}
