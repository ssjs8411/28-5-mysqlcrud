package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberAddrDao {
	public int insertMemberAddr (MemberAddr m) {
		
			Connection conn = null;
			PreparedStatement pstmt = null;
		 try {
	            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
	        } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	            
	            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
	            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
	            String dbUser = "root";        
	            String dbPass = "java0000";        
	        
	        try {
	            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
	            System.out.println(conn + "<--conn");
	            
	            // ������ �ۼ�
	            pstmt = conn.prepareStatement("INSERT INTO member_addr (member_no,member_addr_content) VALUES (?,?)");
	            pstmt.setInt(1, m.getMember_addr_no());
	            pstmt.setString(2, m.getMember_addr_content());
	                       
	            // ���� ����
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        try {
	            // �ݴ� ���� �߿�
	            pstmt.close();        
	            conn.close();    
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return 0;
		
	}
	
}
