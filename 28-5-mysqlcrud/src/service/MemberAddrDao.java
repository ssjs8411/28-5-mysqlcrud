package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemberAddrDao {
	
	public void updateMemberAddr (MemberAddr maddr) {
		
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
            pstmt = conn.prepareStatement("UPDATE member_addr_no SET member_addr_cnotent=? WHERE member_no=?");
            pstmt.setString(1, maddr.getMember_addr_content());
            pstmt.setInt(2, maddr.getMember_no());
            
            pstmt.executeUpdate();
      } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
      }finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
      }

	
	public MemberAddr mSelectUpdateAddr (int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		
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
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM memer_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
                       
            // ���� ����
            rs = pstmt.executeQuery();
            pstmt.setInt(1, member_no);
            
            // ���� ����
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	maddr.setMember_addr_no(rs.getInt("member_addr_no"));
            	maddr.setMember_no(rs.getInt("member_no"));
            	maddr.setMember_addr_content(rs.getString("member_addr_content"));
            }
            
      } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
      }finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return maddr;
	}
	
	public MemberAddr mSelectAddr (int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		
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
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM memer_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
                       
            // ���� ����
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	maddr.setMember_addr_no(rs.getInt("member_addr_no"));
            	maddr.setMember_no(rs.getInt("member_no"));
            	maddr.setMember_addr_content(rs.getString("member_addr_content"));
            }
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return maddr;
	}
	
	public int insertMemberAddr (MemberAddr maddr) {
		
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
	            pstmt.setInt(1, maddr.getMember_addr_no());
	            pstmt.setString(2, maddr.getMember_addr_content());
	                       
	            // ���� ����
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	      
		} finally {
		
		// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
		
	}
		return 0;
		
	}
	
}
