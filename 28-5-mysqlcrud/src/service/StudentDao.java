// 18.6.25 ������
package service;						// service ��Ű�� ���� �ִ�

import java.sql.Connection;				// Connection ������� import
import java.sql.DriverManager;			// DriverManager ������� import 
import java.sql.PreparedStatement;		// PreparedStatement ������� import 
import java.sql.SQLException;			// �����˻� ���� import

public class StudentDao {				// StudentDao Ŭ����
	

	public int insertStudent(Student s)  {			// ���������� public(�������� ���ٰ���) 
		
		 // �Ѹ��� Student�� �Է��ϱ� ���� �޼���
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
		pstmt = conn.prepareStatement("INSERT INTO student(student_name, student_age) VALUES (?,?)");	// student ���̺� insert
		pstmt.setString(1, s.getStudent_name());	// ù��° ?�� StudentŬ���� ���� �ִ� getStudent_name�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
		pstmt.setInt(2, s.getStudent_age());		// �ι�° ?�� StudentŬ���� ���� �ִ� getStudent_age�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
		
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
