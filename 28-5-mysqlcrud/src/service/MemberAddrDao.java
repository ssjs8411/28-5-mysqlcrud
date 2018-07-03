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
	            pstmt = conn.prepareStatement("INSERT INTO member_addr (member_no,member_addr_content) VALUES (?,?)");
	            pstmt.setInt(1, m.getMember_addr_no());
	            pstmt.setString(2, m.getMember_addr_content());
	                       
	            // 쿼리 실행
	            pstmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
	        
	        try {
	            // 닫는 순서 중요
	            pstmt.close();        
	            conn.close();    
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		return 0;
		
	}
	
}
