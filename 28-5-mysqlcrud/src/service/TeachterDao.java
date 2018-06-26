// 이경선 
package service; 	// service 패키지 내에 있다

import java.sql.Connection;		// Connection 사용위해 import
import java.sql.DriverManager;	// DriverManager 사용위해 import 
import java.sql.PreparedStatement;	// PreparedStatement 사용위해 import
import java.sql.SQLException;	// 오류검사 위해 import


public class TeachterDao {		// TeachterDao 클래스
	
	public int InsertTeachter(Teachter t){	// 접근지정자 public(모든곳에서 접근가능) 
			
		// 한명의 Student를 입력하기 위한 메서드
				 // 매개변수 data type(Teachter),	매개변수명: t
				 // return data type : int(숫자) -> 쿼리문 실행하여 실행이 되면 1, 실행이 안되면 0으로 받을수도 있음
		
		Connection conn = null;			//db연결 변수 선언해주고 값초기화
		PreparedStatement pstmt = null;	// 객체 생성을 위한 변수 선언 및 값 초기화
	
	
	try{						// 오류가 발생할수도 있음 오류가 발생하면 catch에서 처리
		//01단계 :드라이버 로딩 끝
		Class.forName("com.mysql.jdbc.Driver");
		
		//02단계 :DB연결(Connection)시작

       //DB연결(ip주소, port번호 , DB명 , ID, PW
		String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(conn);
		
		// 3단계: 쿼리 실행준비(쿼리문 작성)
		pstmt = conn.prepareStatement("INSERT INTO teachter(teachter_name, teachter_age) VALUES (?,?);");
		System.out.println(pstmt);
		
		pstmt.setString(1, t.getTeachter_name());
		pstmt.setInt(2, t.getTeachter_age());	
		
		// 3단계: 쿼리 실행
		pstmt.executeUpdate();
	
	
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//06단계 :statement 또는 prepareStatement객체 종료(close())
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		//07단계 :Connection 객체 종료(close())
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	return 0;
}
}
		
		
	

	
