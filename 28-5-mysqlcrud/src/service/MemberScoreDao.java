package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberScoreDao {
	
	public ArrayList<MemberAndScore> selectMemberAndScore(){
		
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
            
        while(rs.next()) {    // 조회하여 값이 출력될때까지 반복

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
		
    	// 객체 종료(닫는 순서 중요)
		if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
		if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
		if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
		
	}
        
		
		return list;
		
	}
		
	}
		/*Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		ArrayList<MemberAndScore> list = new ArrayList<MemberAndScore>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String sql ="select ms.member_score_no, ms.member_no, m.member_name,m.member_age,ms.score from member_score ms inner join member m ON ms.member_no = m.member_no";

			
		} 
			
           String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
           String dbUser = "root";
           String dbPass = "java0000";
           conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
          // pstmt = conn.prepareStatement("select ms.member_score_no, ms.member_no, m.member_name,m.member_age,ms.score from member_score ms inner join member m ON ms.member_no = m.member_no");
           
           rs = pstmt.executeQuery();
            
           while(rs.next()) {
        	   
        	   Member member = new Member();
        	   MemberScore memberscore = new MemberScore();
        	   MemberAndScore memberAndScore = new MemberAndScore();
        	   
        	   memberAndScore.setMember(member);
        	   memberAndScore.setMemberScore(memberscore);
        	   
        	   list.add(memberAndScore);
           		}
           
		    } catch (ClassNotFoundException e) {
		        // TODO Auto-generated catch block
		    		e.printStackTrace();
		    } catch (SQLException e) {
		        // TODO Auto-generated catch block
		    		e.printStackTrace();
		    } finally {
   			
   			// 객체 종료(닫는 순서 중요)
   			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
   			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
   			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
   			
   		}
		return null;
		
	}*/


