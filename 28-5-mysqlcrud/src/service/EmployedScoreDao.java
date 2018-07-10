// 18.7.9 ������
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployedScoreDao {
	
	public int deleteEmployedScore(int no) {
		// employed_score ���̺��� ������ �����ϴ� �޼���
		// ���� ���� ����� ����
		// �Ű����� employed_no�� ��
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return avg;
		
	}
	
	public ArrayList<EmployedAndScore> selectEmployedListAboveAvg(){
		// score�� ��հ� �̻��� ����Ʈ�� ��ȸ�ϴ� �޼���
		// EmployedAndScore�� �ּҰ��� �����Ѵ�(�迭)
		// �Ű����� ����

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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		
		return list;
		
	}
	
	public ArrayList<EmployedAndScore> selectEmployedAndScored(){
		// Employed ���̺�� Employed_score ���̺��� ���� ��ȸ�ϱ� ���� �޼���
		// ���ϰ� EmployedAndScore Ŭ������ �ּҰ�(�迭)
		// �Ű����� �Է°� ����
		
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
			
			while(rs.next()) {	// ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�
				
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return alesc;

	}
	
	public int updateEmployedScore(EmployedScore es) {
		// employed_score���̺� �ߺ����� ������ �Է¹��� �������� ������Ʈ(�����)
		// ���ϰ� ����
		// employedScore Ŭ������ �ּҰ��� �޴´�(���� �Էµ� �� ����)
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return check;
	}

	public void insertEmployedScore(EmployedScore es) {
		// employed_score ���̺� ������ �Է��ϱ� ���� �޼���
		// ���ϰ� ����
		// EmployedScore Ŭ������ �ּ� ���� (���� �Էµ� �� �޾� �ѱ��)
		
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
			pstmt = conn.prepareStatement("INSERT INTO employed_score (employed_no, employed_score) VALUES (?, ?)");	// employed_score ���̺� insert
			pstmt.setInt(1, es.getEmployed_no());	// ù��° ?�� EmployedScoreŬ���� ���� �ִ� getEmployed_no�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			pstmt.setInt(2, es.getEmployed_score());		// �ι�° ?�� EmployedScoreŬ���� ���� �ִ� getEmployed_score�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			
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
