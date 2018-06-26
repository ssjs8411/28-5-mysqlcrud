// 18.6.25 최지수
package service;						// service 패키지 내에 있다

import java.sql.Connection;				// Connection 사용위해 import
import java.sql.DriverManager;			// DriverManager 사용위해 import 
import java.sql.PreparedStatement;		// PreparedStatement 사용위해 import 
import java.sql.SQLException;			// 오류검사 위해 import

public class StudentDao {				// StudentDao 클래스
	

	public int insertStudent(Student s)  {			// 접근지정자 public(모든곳에서 접근가능) 
		
		 // 한명의 Student를 입력하기 위한 메서드
		 // 매개변수 data type(Student),	매개변수명: s
		 // return data type : int(숫자) -> 쿼리문 실행하여 실행이 되면 1, 실행이 안되면 0으로 받을수도 있음
		 
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		
		try{		// 오류가 발생할수도 있음 오류가 발생하면 catch에서 처리
		
		// 1단계: 드라이버로딩
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2단계: DB연결
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
		
		// 3단계: 쿼리 실행준비(쿼리문 작성)
		pstmt = conn.prepareStatement("INSERT INTO student(student_name, student_age) VALUES (?,?)");	// student 테이블에 insert
		pstmt.setString(1, s.getStudent_name());	// 첫번째 ?에 Student클래스 내에 있는 getStudent_name메서드를 호출하여 메서드의 리턴값을 입력
		pstmt.setInt(2, s.getStudent_age());		// 두번째 ?에 Student클래스 내에 있는 getStudent_age메서드를 호출하여 메서드의 리턴값을 입력
		
		// 4단계: 쿼리실행
		pstmt.executeUpdate();			
		
		
		}  catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		return 0;
		
	}
}
