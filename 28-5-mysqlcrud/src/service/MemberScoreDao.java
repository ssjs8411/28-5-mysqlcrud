/*2018-07-09 �����*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberScoreDao {
	
	public ArrayList<MemberAndScore> selectMemberAndScore(){
		/*Member ���̺�� Member_score ���̺� �� ����*/
		ArrayList<MemberAndScore> list = new ArrayList<MemberAndScore>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
            
            pstmt = conn.prepareStatement( "SELECT member_score_no, member_no, member_name, member_age, score FROM member_score ms INNER JOIN member m ON ms.member_no = m.member_no");
         
            rs = pstmt.executeQuery();
            
        while(rs.next()) {    // ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�

        	Member m = new Member();
     	   	MemberScore ms = new MemberScore();
     	   	MemberAndScore mas = new MemberAndScore();
     	   
     	   	m.setMember_no(rs.getInt("member_no"));
     	   	m.setMember_name(rs.getString("member_name"));
     	   	m.setMember_age(rs.getInt("member_age"));
     	   	
     	   	ms.setMember_score_no(rs.getInt("member_score_no"));
     	   	ms.setMember_no(rs.getInt("member_no"));
     	   	ms.setScore(rs.getInt("score"));
     	   
     	   	mas.setMember(m);
     	   	mas.setMemberScore(ms);
     	   	
     	   	
     	   	list.add(mas);
     	   
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

		return list;
}

	public int updateMemberScore (MemberScore ms) {
		/*Member_score ���̺� �Է¹��� ������ �ߺ��̸� ������ ������Ʈ*/
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    int check = 0;
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
			            
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
			            
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			            
		pstmt = conn.prepareStatement("UPDATE member_score SET	member_no=?	WHERE score=?");
		pstmt.setInt(1, ms.getMember_no());
		pstmt.setInt(2, ms.getScore());
			         
		check = pstmt.executeUpdate();
		
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
	
		return check;
		
	}

	public void insertMemberScore (MemberScore ms) {
		/*Member_score ���̺� ���� �Է��ϴ� �޼ҵ�*/
		Connection conn = null;
	    PreparedStatement pstmt = null;
	   
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
			            
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
			            
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			            
		pstmt = conn.prepareStatement("INSERT INTO member_score (member_no, score) VALUES (?, ?)");
		pstmt.setInt(1, ms.getMember_no());
		pstmt.setInt(2, ms.getScore());
			         
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
	
	
	
}
		
	
	
	
