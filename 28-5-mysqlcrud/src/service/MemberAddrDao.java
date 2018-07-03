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
            pstmt = conn.prepareStatement("UPDATE member_addr_no SET member_addr_cnotent=? WHERE member_no=?");
            pstmt.setString(1, maddr.getMember_addr_content());
            pstmt.setInt(2, maddr.getMember_no());
            
            pstmt.executeUpdate();
      } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            
      }finally {
			
			// 객체 종료(닫는 순서 중요)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
      }

	
	public MemberAddr mSelectUpdateAddr (int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		
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
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM memer_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
                       
            // 쿼리 실행
            rs = pstmt.executeQuery();
            pstmt.setInt(1, member_no);
            
            // 쿼리 실행
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
			
			// 객체 종료(닫는 순서 중요)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		return maddr;
	}
	
	public MemberAddr mSelectAddr (int member_no) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberAddr maddr = new MemberAddr();
		
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
            pstmt = conn.prepareStatement("SELECT member_addr_no, member_no, member_addr_content FROM memer_addr WHERE member_no=?");
            pstmt.setInt(1, member_no);
                       
            // 쿼리 실행
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
			
			// 객체 종료(닫는 순서 중요)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		return maddr;
	}
	
	public int insertMemberAddr (MemberAddr maddr) {
		
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
	            pstmt.setInt(1, maddr.getMember_addr_no());
	            pstmt.setString(2, maddr.getMember_addr_content());
	                       
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
