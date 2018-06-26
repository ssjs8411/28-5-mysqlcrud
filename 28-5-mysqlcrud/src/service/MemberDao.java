//28�� �����
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
	
	public int insertMember(Member m) {
		//���� ������ Ÿ���� int �޼ҵ�� insertMember(�Ű����� m�� ������ Ÿ���� Member)
		Connection conn = null;
		PreparedStatement pstmt = null;
		//try=���ܰ� �߻��� �ڵ�
		//catch=���ܰ� �߻��� ����� �ڵ�
		try {
			Class.forName("com.mysql.jdbc.Driver");		//����̹� �ε�
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	        //DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
	        String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
	        String dbUser = "root";		
	        String dbPass = "java0000";		
        
		try {
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			System.out.println(conn + "<--conn");
			
			//������ �ۼ�
			pstmt = conn.prepareStatement("INSERT INTo member (member_name,member_age) VALUES (?,?)");
			pstmt.setString(1, m.getMember_name());
			pstmt.setInt(2, m.getMember_age());
			
			//���� ����
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//��ü ����
			pstmt.close();		
			conn.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
