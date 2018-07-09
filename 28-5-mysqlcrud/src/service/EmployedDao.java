// 18.6.26 최지수
package service;									// service 패키지 내에 있다

import java.sql.Connection;							// Connection 사용위해 import
import java.sql.DriverManager;						// DriverManager 사용위해 import 
import java.sql.PreparedStatement;					// PreparedStatement 사용위해 import 
import java.sql.ResultSet;
import java.sql.SQLException;						// 오류검사 위해 import
import java.util.ArrayList;

public class EmployedDao {							// EmployedDao 클래스
	
	public int deleteEmployed(int employed_no) {
		// Employed 삭제를 하기 위한 메서드
		// 리턴 int, 쿼리 실행결과값 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		int check = 0;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("DELETE FROM employed WHERE employed_no=?");
			pstmt.setInt(1, employed_no);
			check = pstmt.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return check;
		
	}
	
	public void updateEmployed(Employed emp) {
		// Employed 업데이트를 하기 위한 메서드
		// 리턴 타입 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE employed SET employed_name=?, employed_age=? WHERE employed_no=?");
			pstmt.setString(1, emp.getEmployed_name());
			pstmt.setInt(2, emp.getEmployed_age());
			pstmt.setInt(3, emp.getEmployed_no());
			
			pstmt.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
	}
	
	
	public Employed selectUpdateEmployed(int employed_no) {
		// 수정화면에 정보를 불러오기 위한 메서드
		// Student 클래스의 주소값 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Employed emp = new Employed();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT employed_no, employed_name, employed_age FROM employed WHERE employed_no=?");
			pstmt.setInt(1, employed_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				emp.setEmployed_no(rs.getInt("employed_no"));
				emp.setEmployed_name(rs.getString("employed_name"));
				emp.setEmployed_age(rs.getInt("employed_age"));
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return emp;
		
	}
	
	public int selectCountEmployed() {
			
			// 테이블 내의 데이터 갯수를 구하기 위한 메서드
			// 숫자값을 리턴하기 위해 return data type 은 int type
			
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
				
				pstmt = conn.prepareStatement("SELECT COUNT(*) FROM employed");
				
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
			}finally {
				
				// 객체 종료(실행순서 거꾸로 종료시켜준다)
				if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
				if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
				if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
				
			}
			
			
			return totalRow;
			
		}
	
	public ArrayList<Employed> selectEmployedByPage(int page, int pagePerRow, String searchWord){
		
		// 테이블 내 전체 수를 구하기 위한 메서드
		// ArrayList type으로 Employed클래스의 주소값 리턴(배열)
		// 쿼리문의 몇번 부터 몇개까지 출력할건지 입력위해 매개변수 2개  int type
		// 검색조건을 받는 searchWord 검색값이 없을땐 전체 조회
		// 18.7.9 메서드 수정(검색조건 시 쿼리문 수정)
		
		ArrayList<Employed> list = new ArrayList<Employed>();
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
			
			if(searchWord.equals("")) {
				sql = "SELECT employed_no, employed_name, employed_age FROM employed ORDER BY employed_no LIMIT ?,?";	// employed에서 employed_no칼럼 기준 몇번부터 몇개까지 조회
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, page);
				pstmt.setInt(2, pagePerRow);
			}else {
				sql = "SELECT employed_no, employed_name, employed_age FROM employed WHERE employed_name LIKE ? ORDER BY employed_no LIMIT ?,?";	
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, "%"+searchWord+"%");
				pstmt.setInt(2, page);
				pstmt.setInt(3, pagePerRow);
			}
			
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// 조회하여 값이 출력될때까지 반복
				
				Employed e = new Employed();
				
				e.setEmployed_no(rs.getInt("employed_no"));
				e.setEmployed_name(rs.getString("employed_name"));
				e.setEmployed_age(rs.getInt("employed_age"));
				
				list.add(e);
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB연결종료
			
		}
		
		return list;	// list 최대 pageperRow~1
		
	}

	public int insertEmployed(Employed emp)  {		// 접근지정자 public(모든곳에서 접근가능)
		
		// 한명의 Employed를 입력하기 위한 메서드
		// 매개변수 data type(Employed),	매개변수명: emp
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
		pstmt = conn.prepareStatement("INSERT INTO employed(employed_name, employed_age) VALUES (?,?)");		// employed 테이블에 insert
		pstmt.setString(1, emp.getEmployed_name());		// 첫번째 ?에 employed클래스 내에 있는 getEmployed_name메서드를 호출하여 메서드의 리턴값을 입력
		pstmt.setInt(2, emp.getEmployed_age());			// 두번째 ?에 employed클래스 내에 있는 getEmployed_age메서드를 호출하여 메서드의 리턴값을 입력
		
		// 4단계: 쿼리실행
		pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// 객체 종료(실행순서 거꾸로 종료시켜준다)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}		// 쿼리연결종료
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}		// DB연결종료
		}
		return 0;
		
	}
}
