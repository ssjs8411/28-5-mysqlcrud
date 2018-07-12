package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberAddrDao {
	
	public ArrayList<MemberAddr> memberListSelect (String member_name){
		//return data type ArrayList<MemberAddr>, memberListSelect �޼ҵ� (String data type���� �Ű����� member_name ����)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<MemberAddr> alm = new ArrayList<MemberAddr>();
		//ArrayList<MemberAddr> data type����  alm���� �����ϰ� new������ �޼ҵ�� ������ ArrayList<MemberAddr>��ü�� �ּ� ����  alm������ �Ҵ��Ѵ�
		
		try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
      
            
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000"; 
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			System.out.println(conn + "<--conn");
			
			pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM member_addr WHERE member_no=?");
			rs = pstmt.executeQuery();
			
		while(rs.next()) {
			MemberAddr ma = new MemberAddr();
			//MemberAddr data type����  ma���� �����ϰ� new������ �޼ҵ�� ������ MemberAddr��ü�� �ּ� ����  ma������ �Ҵ��Ѵ�
			ma.setMember_addr_no(rs.getInt("member_addr_no"));
			ma.setMember_no(rs.getInt("member_no"));
			ma.setMember_addr_content(rs.getString("member_addr_content"));
			
			alm.add(ma);
			//alm�� ����ִ� �ּҰ��� ���󰡼� add�޼��带 ȣ���Ͽ� �Ű��������� ma�� ����ִ� �ּҰ��� �����Ѵ�
		}
		} catch (ClassNotFoundException e) {
			// TODO: handle exception
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
		}
		
		return alm;
		//alm�� ����ִ� �ּ� ���� ����
	
	}
	
	public void deleteMemberAddr (int member_no) {
			// return ���� deleteMemberAddr�޼ҵ� (int data type���� �Ű����� member_no ����)
			Connection conn = null;
			PreparedStatement pstmt  = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
      
            
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000"; 
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            pstmt = conn.prepareStatement("DELETE FROM member_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
            
            pstmt.executeUpdate();
            
		  } catch (ClassNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	      } catch (SQLException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
	      } finally {
	  			
	  			// ��ü ����(�ݴ� ���� �߿�)
	  			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
	  			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
	  			
	  	}
}
		
       
		
			
	public void updateMemberAddr (MemberAddr maddr) {
		//���� ���� updateMemberAddr�޼ҵ� (MemberAddr data type���� �Ű����� maddr ����)
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
        
            
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000";        
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            // ������ �ۼ�
            pstmt = conn.prepareStatement("UPDATE member_addr_no SET member_addr_cnotent=? WHERE member_no=?");
            pstmt.setString(1, maddr.getMember_addr_content());
            pstmt.setInt(2, maddr.getMember_no());
            
            pstmt.executeUpdate();
        
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
        } finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
      }

	
	public MemberAddr mSelectforUpdateAddr (int member_no) {
		//return data type MemberAddr, mSelectUpdateAddr�޼ҵ� (int data type���� �Ű����� member_no ����)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		//MemberAddr data type���� maddr���� �����ϰ� new������ �޼ҵ�� ������  MemberAddr��ü�� �ּ� ���� maddr������ �Ҵ��Ѵ�
		try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
      
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000";        
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            // ������ �ۼ�
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM member_no WHERE member_no=?");
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
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
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
		//maddr�� ����ִ� �ּ� ���� ����
	}
	
	public MemberAddr mSelectAddr (int member_no) {
		//return data type MemberAddr, mSelectAddr�޼ҵ� (int data type���� �Ű����� member_no ����)
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		//MemberAddr data type���� maddr���� �����ϰ� new������ �޼ҵ�� ������  MemberAddr��ü�� �ּ� ���� maddr������ �Ҵ��Ѵ�
		try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
        
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000";        
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            // ������ �ۼ�
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM member_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
                       
            // ���� ����
            rs = pstmt.executeQuery();
            
            if(rs.next()) {
            	maddr.setMember_addr_no(rs.getInt("member_addr_no"));
            	maddr.setMember_no(rs.getInt("member_no"));
            	maddr.setMember_addr_content(rs.getString("member_addr_content"));
        }
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();    
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
		//maddr�� ����ִ� �ּ� ���� ����
	}
	
	public int insertMemberAddr (MemberAddr maddr) {
		//return data type int, insertMemberAddr�޼ҵ� (MemberAddr data type���� �Ű����� maddr ����)
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
       
			// DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
			String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
			String dbUser = "root";        
			String dbPass = "java0000";        
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			System.out.println(conn + "<--conn");
			            
			// ������ �ۼ�
			pstmt = conn.prepareStatement("INSERT INTO member_addr (member_no,member_addr_content) VALUES (?,?)");
			pstmt.setInt(1, maddr.getMember_no());
			pstmt.setString(2, maddr.getMember_addr_content());
				                       
			// ���� ����
			pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
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