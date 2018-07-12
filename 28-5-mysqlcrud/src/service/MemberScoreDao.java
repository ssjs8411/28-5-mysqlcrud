/*2018-07-09 �����*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberScoreDao {
 
	public int seletScoreAvg(){			
		// ����� ���ϴ� �޼ҵ�
		// return data type int�� selectScorAvg �޼ҵ� ����
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    
	    int scoreAvg = 0;
	    
	    try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
            
            pstmt = conn.prepareStatement("SELECT AVG(score) FROM member_score");
         
            rs = pstmt.executeQuery();
            
		if(rs.next()) {
			scoreAvg = rs.getInt("AVG(score)");
            	
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
	    
		return scoreAvg;
		//scoreAvg�� ����ִ� �ּ� ���� ����
		
	}
	
	public ArrayList<MemberAndScore> selectMemberListAboveAvg(){
		// reurn data type ArrayList<MemberAndScore>, selsectMemberListAboveAvg �޼ҵ�
		//	��� ���� ���� ����� �̸��� ���� (join) 
		ArrayList<MemberAndScore> als = new ArrayList<MemberAndScore>();		//ArrayList<MemberAndScore> data type���� list ���� �����ϰ�  new������ �޼ҵ��  ������ ArrayList<MemberAndScore>��ü�� �ּ� ���� list������ �Ҵ��Ѵ�
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);

            pstmt = conn.prepareStatement("SELECT m.member_no, m.member_name, ms.score FROM member_score ms INNER JOIN  member m on ms.member_no = m.member_no WHERE ms.score>=(SELECT AVG(score) FROM member_score)");
            
            rs = pstmt.executeQuery();
            
        while(rs.next()) {   

        	Member m = new Member();							//Member date type���� ���� m ����
     	   	MemberScore ms = new MemberScore();					//MemberScore date type���� ����  ms ��ü ����
     	   	MemberAndScore mas = new MemberAndScore();			//MemberAndScore date type���� ����  mas ��ü ����
     	   
     	   	m.setMember_no(rs.getInt("member_no"));				//��պ��� ���� ����� ������ �̸��� �����ֱ� ������ age�� �ʿ����
     	   	m.setMember_name(rs.getString("member_name"));

     	   	ms.setScore(rs.getInt("score"));					//score_no�� member_no�� �ʿ���� (������ �˸� �Ǳ� ������)
     	   
     	   	mas.setMember(m);
     	   	mas.setMemberScore(ms);
     	   	
     	   	
     	   als.add(mas);
     	   	//als �� ����ִ� �ּҰ��� ���󰡼� add�޼��带 ȣ���Ͽ� �Ű��������� mas�� ����ִ� �ּҰ��� �����Ѵ�
     	   	
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
        
		return als;
        
	}


	public ArrayList<MemberAndScore> selectMemberAndScore(){			
		//return data type ArrayList<MemberAndScore>, selectMemberAndScore �޼ҵ�
		ArrayList<MemberAndScore> list = new ArrayList<MemberAndScore>();
		//ArrayList<MemberAndScore> data type���� list ���� �����ϰ�  new������ �޼ҵ��  ������ ArrayList<MemberAndScore>��ü�� �ּ� ���� list������ �Ҵ��Ѵ�
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);

            pstmt = conn.prepareStatement("SELECT ms.member_score_no, ms.member_no, m.member_name, m.member_age, score FROM member_score ms INNER JOIN member m ON ms.member_no = m.member_no");
            
            rs = pstmt.executeQuery();
            
        while(rs.next()) {   

        	Member m = new Member();							//Member date type���� ���� m ����
     	   	MemberScore ms = new MemberScore();					//MemberScore date type���� ���� ms ����
     	   	MemberAndScore mas = new MemberAndScore();			//MemberAndScore date type���� ���� mas ����
     	   
     	   	m.setMember_no(rs.getInt("member_no"));
     	   	m.setMember_name(rs.getString("member_name"));
     	   	m.setMember_age(rs.getInt("member_age"));
     	   	
     	   	ms.setMember_score_no(rs.getInt("member_score_no"));
     		ms.setMember_no(rs.getInt("member_no"));
     	   	ms.setScore(rs.getInt("score"));
     	   
     	   	mas.setMember(m);
     	   	mas.setMemberScore(ms);
     	   	
     	   	
     	   	list.add(mas);
     	   	//list �� ����ִ� �ּҰ��� ���󰡼� add�޼��带 ȣ���Ͽ� �Ű��������� mas�� ����ִ� �ּҰ��� �����Ѵ�
     	   
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
		//list�� ����ִ� �ּ� ���� ����
	}
	
	public void deleteMemberScore (int member_no) {
		//return ���� deleteMemberScore �޼ҵ�/ int data type���� �Ű����� member_no ����
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
		pstmt = conn.prepareStatement("DELETE FROM member_score WHERE member_no=?");
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
	
	public int updateMemberScore (MemberScore ms) {
		//return data type int / updateMemberScore �޼ҵ� (MemberScore data type���� �Űܺ��� ms ����)
		/*Member_score ���̺� �Է¹��� ������ �ߺ��̸� ������ ������Ʈ*/
		Connection conn = null;
	    PreparedStatement pstmt = null;
	    
	    int score = 0;
	
		try {
		Class.forName("com.mysql.jdbc.Driver");
			            
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
			            
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			            
		pstmt = conn.prepareStatement("UPDATE member_score SET	member_no=?	WHERE score=?");
		pstmt.setInt(1, ms.getMember_no());
		pstmt.setInt(2, ms.getScore());
			         
		score = pstmt.executeUpdate();
		
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
	
		return score;
		//score�� ����ִ� �ּ� ���� ����
	}

	public void insertMemberScore (MemberScore ms) {
		// return ���� insertMemberScort �޼ҵ� (MemberScore data type���� �Ű����� ms ����)
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
		
	
	
	
