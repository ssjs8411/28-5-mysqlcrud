// 18.7.4 최지수 
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployedAddrDao {
	
	
	public int deleteEmployedAddr(int employed_no) {
		// EmployedAddr 삭제를 하기 위한 메서드
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
			
			pstmt = conn.prepareStatement("DELETE FROM employed_addr WHERE employed_no=?");
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
	
	public void updateEmployedAddr(EmployedAddr eaddr) {
		// EmployedAddr 업데이트를 하기 위한 메서드
		// 리턴 타입 없음
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("UPDATE employed_addr SET employed_addr_content=? WHERE employed_no=?");
			pstmt.setString(1, eaddr.getEmployed_addr_content());
			pstmt.setInt(2, eaddr.getEmployed_no());
			
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
	
	public EmployedAddr selectUpdateEmployedAddr(int employed_no) {
		// 수정화면에 정보를 불러오기 위한 메서드
		// EmployedAddr 클래스의 주소값 리턴
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployedAddr eaddr = new EmployedAddr();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement("SELECT employed_addr_no, employed_no, employed_addr_content FROM employed_addr WHERE employed_no=?");
			pstmt.setInt(1, employed_no);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				eaddr.setEmployed_addr_no(rs.getInt("employed_addr_no"));
				eaddr.setEmployed_no(rs.getInt("employed_no"));
				eaddr.setEmployed_addr_content(rs.getString("setEmployed_addr_content"));
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
		
		return eaddr;
		
	}
	
	
	public ArrayList<EmployedAddr> selectEmployedAddrList(int employed_no){
		// 받아온 employed_no의 값을 조회하여 한명의 주소 조회하는 메서드
		// EmployedAddr클래스의 주소 리턴(배열) ->여러개의 값이 있으면 여러개 조회
		// employed_no의 값을 받아서 쿼리문 작성
		
		ArrayList<EmployedAddr> alea = new ArrayList<EmployedAddr>();
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		ResultSet rs = null;
		
		try {
			
			// 1단계: 드라이버로딩
				Class.forName("com.mysql.jdbc.Driver");
			
			// 2단계: DB연결
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
				
			// 3단계: 쿼리 실행준비(쿼리문 작성)
				pstmt = conn.prepareStatement("SELECT employed_addr_no, employed_no, employed_addr_content FROM employed_addr WHERE employed_no=?");
				pstmt.setInt(1, employed_no);
			
			// 4단계 : 쿼리 실행
				rs = pstmt.executeQuery();
				
			// 5단계 : 쿼리 실행결과 사용
				while(rs.next()) {
					EmployedAddr eaddr = new EmployedAddr();
					
					eaddr.setEmployed_addr_no(rs.getInt("employed_addr_no"));
					eaddr.setEmployed_no(rs.getInt("employed_no"));
					eaddr.setEmployed_addr_content(rs.getString("employed_addr_content"));
					
					alea.add(eaddr);
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
		
		
		return alea;
		
	}
	
	public EmployedAddr selectEmployedAddr(int employed_no) {
		
		// 받아온 employed_no의 값을 조회하여 한명의 주소 조회하는 메서드
		// EmployedAddr 클래스의 주소값을 리턴
		Connection conn = null;				// DB 연결을 위한 변수 선언 및 값 초기화
		PreparedStatement pstmt = null;		// 객체 생성을 위한 변수 선언 및 값 초기화
		ResultSet rs = null;
		EmployedAddr eaddr = new EmployedAddr();
		
		try {
			// 1단계: 드라이버로딩
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2단계: DB연결
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// 드라이버 접속
			
			// 3단계: 쿼리 실행준비(쿼리문 작성)
			pstmt = conn.prepareStatement("SELECT employed_addr_no, employed_no, employed_addr_content FROM employed_addr WHERE employed_no=?");
			pstmt.setInt(1, employed_no);
			
			// 4단계 : 쿼리 실행
			rs = pstmt.executeQuery();
			
			// 5단계 : 쿼리 실행결과 사용
			if(rs.next()) {
				
				eaddr.setEmployed_addr_no(rs.getInt("employed_addr_no"));
				eaddr.setEmployed_no(rs.getInt("employed_no"));
				eaddr.setEmployed_addr_content(rs.getString("setEmployed_addr_content"));
			}
			
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
		
		return eaddr;
		
	}

	public int insertEmployedAddr(EmployedAddr eaddr)  {			// 접근지정자 public(모든곳에서 접근가능) 
		
		 // 한명의 Employed(Addr)를 입력하기 위한 메서드
		 // 매개변수 data type(Employed),	매개변수명: eaddr
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

			pstmt = conn.prepareStatement("INSERT INTO employed_addr (employed_no, employed_addr_content) VALUES (?, ?)");	// employedAddr 테이블에 insert
			pstmt.setInt(1, eaddr.getEmployed_no());	// 첫번째 ?에 employed클래스 내에 있는 getemployed_name메서드를 호출하여 메서드의 리턴값을 입력
			pstmt.setString(2, eaddr.getEmployed_addr_content());		// 두번째 ?에 employed클래스 내에 있는 getemployed_age메서드를 호출하여 메서드의 리턴값을 입력
			
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
