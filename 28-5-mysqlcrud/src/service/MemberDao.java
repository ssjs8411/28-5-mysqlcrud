/*2018-07-02 김소희*/
package service;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class MemberDao {
	
	  
	public int deleteMember (int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         
	         pstmt = conn.prepareStatement("DELETE FORM member WHERE member_no=?");
	         pstmt.setInt(1, member_no);
	         
	         pstmt.executeUpdate();
	         
		}catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}catch (SQLException e) {
   	// TODO Auto-generated catch block
    		 e.printStackTrace();
		}finally {
			
			// 객체 종료(닫는 순서 중요)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		return member_no;
		
		
	}
	public void updateMember(Member m) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         
	         pstmt = conn.prepareStatement("UPDATE member SET member_name=?, member_age=? WHERE member_no=?");
	         pstmt.setString(1, m.getMember_name());
	         pstmt.setInt(2, m.getMember_age());
	         pstmt.setInt(3, m.getMember_no());
	         
	         pstmt.executeUpdate();
	         
		}catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
		}catch (SQLException e) {
    	// TODO Auto-generated catch block
     		 e.printStackTrace();
		}finally {
			
			// 객체 종료(닫는 순서 중요)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
	}
	
	public Member mSelectUpdate(int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Member m = new Member();
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         
	         pstmt = conn.prepareStatement("SELECT member_no,, member_name, member_age FROM member WHERE member_no=?");
	         pstmt.setInt(1, member_no);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 m.setMember_no(rs.getInt("member_no"));
	        	 m.setMember_name(rs.getString("member_name"));
	        	 m.setMember_age(rs.getInt("member_age"));
	         }
	         
		} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
    		 e.printStackTrace();
    		 
		}finally {
			
			// 객체 종료(닫는 순서 중요)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
			return m;
		}
			
		
	
	
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
            return totalRow;    
    }   
        
 
    public ArrayList<Member> selectMemberByPage(int page, int pagePerRow, String word){
    	// 학생리스트 구하는 메소드
        // word :
    	// "" ->쿼리
    	// "검색단어" -> 쿼리
    	// 분기문 필요
    	// 요구사항 -> 동적쿼리
        ArrayList<Member> list = new ArrayList<>();
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        String sql = null;  
        
		try {
			Class.forName("com.mysql.jdbc.Driver");
			 
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
				            
		if(word.equals("")) {
			sql = "SELECT member_no, member_name, member_age FROM member ORDER BY member_no LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pagePerRow);
		}else {
			sql = "SELECT member_no, member_name, member_age FROM member WHERE memeber_name LIKE ? ORDER BY member_no LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+word+"%"); //like '%단어%'
			pstmt.setInt(2, page);
			pstmt.setInt(3, pagePerRow);
		}
			           
   
			rs = pstmt.executeQuery();
			            
		while(rs.next()) {    // 조회하여 값이 출력될때까지 반복
		                
			Member m  = new Member();
		
			m.setMember_no(rs.getInt("member_no"));
			m.setMember_name(rs.getString("member_name"));
			m.setMember_age(rs.getInt("member_age"));
			                
			list.add(m);
		
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
		            
        
 
    public int insertMember(Member m) {
        // 리턴 데이터 타입은 int 메소드명 insertMember(매개변수 m의 데이터 타입은 Member)
        Connection conn = null;
        PreparedStatement pstmt = null;
        // try=예외가 발생할 코드
        // catch=예외가 발생시 실행될 코드
        try {
            Class.forName("com.mysql.jdbc.Driver");        //드라이버 로딩
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
            
            // DB연결(ip주소, port번호 , DB명 , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //데이터베이스 명
            String dbUser = "root";        
            String dbPass = "java0000";        
        
        try {
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            // 쿼리문 작성
            pstmt = conn.prepareStatement("INSERT INTO member (member_name,member_age) VALUES (?,?)");
            pstmt.setString(1, m.getMember_name());
            pstmt.setInt(2, m.getMember_age());
            
            // 쿼리 실행
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
			
        	// 객체 종료(닫는 순서 중요)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
        return 0;
    }
 
}