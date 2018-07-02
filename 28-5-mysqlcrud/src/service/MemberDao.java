//28�� �����
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	
	public int selectCount () {
		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int totalRow = 0;
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT COUNT(*) FROM member");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalRow = rs.getInt("COUNT(*)");
				
				}
			
		}	catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			
			
		}
			try {
				// �ݴ� ���� �߿�
				rs.close();
				pstmt.close();
				conn.close();
		}	 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} 
			return totalRow;	
	}   
		

	public ArrayList<Member> selectStudentByPage(int page, int pagePerRow){
		
			ArrayList<Member> list = new ArrayList<>();
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			String sql = "SELECT member_no, member_name, member_age FROM member ORDER BY member_no LIMIT ?,?";
		
			try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pagePerRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�
				
			Member m  = new Member();
				
			m.setMember_no(rs.getInt("member_no"));
			m.setMember_name(rs.getString("member_name"));
			m.setMember_age(rs.getInt("member_age"));
				
			list.add(m);
				
			}
			
		}	catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 	catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	finally {
			
		}		
			try {
			// �ݴ� ���� �߿�
			rs.close();
			pstmt.close();
			conn.close();
		}	 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
			return list;
	}
			
		

	public int insertMember(Member m) {
		// ���� ������ Ÿ���� int �޼ҵ�� insertMember(�Ű����� m�� ������ Ÿ���� Member)
		Connection conn = null;
		PreparedStatement pstmt = null;
		// try=���ܰ� �߻��� �ڵ�
		// catch=���ܰ� �߻��� ����� �ڵ�
		try {
			Class.forName("com.mysql.jdbc.Driver");		//����̹� �ε�
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
			pstmt = conn.prepareStatement("INSERT INTo member (member_name,member_age) VALUES (?,?)");
			pstmt.setString(1, m.getMember_name());
			pstmt.setInt(2, m.getMember_age());
			
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
