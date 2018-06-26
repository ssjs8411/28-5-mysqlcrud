//28기 김소희
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MemberDao {
	
	public int insertMember(Member m) {
		//리턴 데이터 타입은 int 메소드명 insertMember(매개변수 m의 데이터 타입은 Member)
		Connection conn = null;
		PreparedStatement pstmt = null;
		//try=예외가 발생할 코드
		//catch=예외가 발생시 실행될 코드
		try {
			Class.forName("com.mysql.jdbc.Driver");		//드라이버 로딩
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	        //DB연결(ip주소, port번호 , DB명 , ID, PW)
	        String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //데이터베이스 명
	        String dbUser = "root";		
	        String dbPass = "java0000";		
        
		try {
			conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			System.out.println(conn + "<--conn");
			
			//쿼리문 작성
			pstmt = conn.prepareStatement("INSERT INTo member (member_name,member_age) VALUES (?,?)");
			pstmt.setString(1, m.getMember_name());
			pstmt.setInt(2, m.getMember_age());
			
			//쿼리 실행
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			//객체 종료
			pstmt.close();		
			conn.close();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

}
