// 18.6.25 ������
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class StudentAddrDao {
	
	public int deleteStudentAddr(int student_no) {
		// StudentAddr ������ �ϱ� ���� �޼���
		// ���� int, ���� �������� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return check;
		
	}
	
	public void updateStudentAddr(StudentAddr saddr) {
		// StudentAddr ������Ʈ�� �ϱ� ���� �޼���
		// ���� Ÿ�� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
	}
	
	public StudentAddr selectUpdateStudentAddr(int student_no) {
		// ����ȭ�鿡 ������ �ҷ����� ���� �޼���
		// StudentAddr Ŭ������ �ּҰ� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return saddr;
		
	}
	
	public ArrayList<StudentAddr> selectStudentAddrList(int student_no){
		// �޾ƿ� student_no�� ���� ��ȸ�Ͽ� �Ѹ��� �ּ� ��ȸ�ϴ� �޼���
		// studentAddr Ŭ������ �ּҰ��� ����(�迭)
		// student_no�� ���� �޾Ƽ� ������ �ۼ�
		
		ArrayList<StudentAddr> alsa = new ArrayList<StudentAddr>();
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		ResultSet rs = null;
		
		try {
			// 1�ܰ�: ����̹��ε�
				Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ�: DB����
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
						
			// 3�ܰ�: ���� �����غ�(������ �ۼ�)
				
				pstmt = conn.prepareStatement("SELECT student_addr_no, student_no, student_addr_content FROM student_addr WHERE student_no=?");
				pstmt.setInt(1, student_no);
				
			// 4�ܰ� : ���� ����
				rs = pstmt.executeQuery();
				
			// 5�ܰ� : ���� ������ ���
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return alsa;
		
	}
	public StudentAddr selectStudentAddr(int student_no) {
		
		// �޾ƿ� student_no�� ���� ��ȸ�Ͽ� �Ѹ��� �ּ� ��ȸ�ϴ� �޼���
		// StudentAddr Ŭ������ �ּҰ��� ����
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		ResultSet rs = null;
		StudentAddr saddr = new StudentAddr();
		
		try {
			// 1�ܰ�: ����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ�: DB����
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
			
			// 3�ܰ�: ���� �����غ�(������ �ۼ�)
			pstmt = conn.prepareStatement("SELECT student_addr_no, student_no, student_addr_content FROM student_addr WHERE student_no=?");
			pstmt.setInt(1, student_no);
			
			// 4�ܰ� : ���� ����
			rs = pstmt.executeQuery();
			
			// 5�ܰ� : ���� ������ ���
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return saddr;
		
	}

	public int insertStudentAddr(StudentAddr saddr)  {			// ���������� public(�������� ���ٰ���) 
		
		 // �Ѹ��� Student(Addr)�� �Է��ϱ� ���� �޼���
		 // �Ű����� data type(Student),	�Ű�������: s
		 // return data type : int(����) -> ������ �����Ͽ� ������ �Ǹ� 1, ������ �ȵǸ� 0���� �������� ����
		 
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

			pstmt = conn.prepareStatement("INSERT INTO student_addr (student_no, student_addr_content) VALUES (?, ?)");	// studentAddr ���̺� insert
			pstmt.setInt(1, saddr.getStudent_no());	// ù��° ?�� StudentŬ���� ���� �ִ� getStudent_name�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			pstmt.setString(2, saddr.getStudent_addr_content());		// �ι�° ?�� StudentŬ���� ���� �ִ� getStudent_age�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			
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
		return 0;
		
	}
}
