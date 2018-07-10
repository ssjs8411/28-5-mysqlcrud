/*2018-07-09 김소희*/
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



public class MemberScoreDao {
 
	public int seletScoreAvg(){			
		// 평균을 구하는 메소드
		// return data type int인 selectScorAvg 메소드 생성
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
		
    	// 객체 종료(닫는 순서 중요)
		if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
		if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
		if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
		
        }
	    
		return scoreAvg;
		//scoreAvg에 담겨있는 주소 값을 리턴
		
	}
	
	public ArrayList<MemberAndScore> selectMemberListAboveAvg(){
		// reurn data type ArrayList<MemberAndScore>, selsectMemberListAboveAvg 메소드
		//	평균 보다 높은 사람의 이름과 점수 (join) 
		ArrayList<MemberAndScore> list = new ArrayList<MemberAndScore>();		//ArrayList<MemberAndScore> data type으로 list 변수 생성하고  new생성자 메소드로  생성된 ArrayList<MemberAndScore>객체의 주소 값을 list변수에 할당한다
		Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
  
        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);

            pstmt = conn.prepareStatement("SELECT m.member_name, ms.score FROM member_score ms INNER JOIN  member m on ms.member_no = m.member_no WHERE ms.score>=(SELECT AVG(score) FROM member_score)");
            
            rs = pstmt.executeQuery();
            
        while(rs.next()) {   

        	Member m = new Member();							//Member date type으로 변수 m 생성
     	   	MemberScore ms = new MemberScore();					//MemberScore date type으로 변수  ms 객체 생성
     	   	MemberAndScore mas = new MemberAndScore();			//MemberAndScore date type으로 변수  mas 객체 생성
     	   
     	   	m.setMember_no(rs.getInt("member_no"));				//평균보다 높은 사람의 점수와 이름을 보여주기 때문에 age는 필요없다
     	   	m.setMember_name(rs.getString("member_name"));

     	   	ms.setScore(rs.getInt("score"));					//score_no와 member_no도 필요없다 (점수만 알면 되기 때문에)
     	   
     	   	mas.setMember(m);
     	   	mas.setMemberScore(ms);
     	   	
     	   	
     	   	list.add(mas);
     	   	//list 에 담겨있는 주소값을 따라가서 add메서드를 호출하여 매개변수에는 mas에 담겨있는 주소값을 대입한다
     	   	
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
        
	}


	public ArrayList<MemberAndScore> selectMemberAndScore(){			
		//return data type ArrayList<MemberAndScore>, selectMemberAndScore 메소드
		ArrayList<MemberAndScore> list = new ArrayList<MemberAndScore>();
		//ArrayList<MemberAndScore> data type으로 list 변수 생성하고  new생성자 메소드로  생성된 ArrayList<MemberAndScore>객체의 주소 값을 list변수에 할당한다
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            
            String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
            String dbUser = "root";
            String dbPass = "java0000";
            
            conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);

            pstmt = conn.prepareStatement("SELECT ms.member_score_no, member_no, member_name, member_age, score FROM member_score ms INNER JOIN member m ON ms.member_no = m.member_no");
            
            rs = pstmt.executeQuery();
            
        while(rs.next()) {   

        	Member m = new Member();							//Member date type으로 변수 m 생성
     	   	MemberScore ms = new MemberScore();					//MemberScore date type으로 변수 ms 생성
     	   	MemberAndScore mas = new MemberAndScore();			//MemberAndScore date type으로 변수 mas 생성
     	   
     	   	m.setMember_no(rs.getInt("member_no"));
     	   	m.setMember_name(rs.getString("member_name"));
     	   	m.setMember_age(rs.getInt("member_age"));
     	   	
     	   	ms.setMember_score_no(rs.getInt("member_score_no"));
     		ms.setMember_no(rs.getInt("member_no"));
     	   	ms.setScore(rs.getInt("score"));
     	   
     	   	mas.setMember(m);
     	   	mas.setMemberScore(ms);
     	   	
     	   	
     	   	list.add(mas);
     	   	//list 에 담겨있는 주소값을 따라가서 add메서드를 호출하여 매개변수에는 mas에 담겨있는 주소값을 대입한다
     	   
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
		//list에 담겨있는 주소 값을 리턴
	}

	public int updateMemberScore (MemberScore ms) {
		//return data type int / updateMemberScore 메소드 (MemberScore data type으로 매겨변수 ms 생성)
		/*Member_score 테이블에 입력받은 점수가 중복이면 점수를 업데이트*/
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
		
		// 객체 종료(닫는 순서 중요)
		
		if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
		if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
		
	}
	
		return score;
		//score에 담겨있는 주소 값을 리턴
	}

	public void insertMemberScore (MemberScore ms) {
		//리턴 없고 insertMemberScort 메소드 (MemberScore data type으로 매개변수 ms 생성)
		/*Member_score 테이블에 점수 입력하는 메소드*/
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
		
		// 객체 종료(닫는 순서 중요)
		
		if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
		if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
		
	   }
	
	}
	
	
	
}
		
	
	
	
