package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import kr.or.ksmart.driverdb.DriverDB;

public class MemberDao {
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//insertMemberForm.jsp insertMemberAction.jsp 
	public int insertMember(Member member) throws ClassNotFoundException, SQLException {
		DriverDB db = new DriverDB();  //
		conn = db.driverDbcon(); 
		System.out.println("insertMember");
		pstmt = conn.prepareStatement("INSERT INTO member VALUES (?,?,?)");
		
		
		return 0;
	}

}
