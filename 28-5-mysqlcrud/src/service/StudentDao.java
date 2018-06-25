package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class StudentDao {
	
	Connection conn = null;
	PreparedStatement pstmt = null;

	public int insertStudent(Student s) throws ClassNotFoundException, SQLException {
		
	
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String dbDriver = "jdbc:mysql://localhost:3306/6mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
		
		pstmt = conn.prepareStatement("INSERT INTO student(student_name, student_age) VALUES (?,?)");
		pstmt.setString(1, s.getStudent_name());
		pstmt.setInt(2, s.getStudent_age());
		pstmt.executeUpdate();
		
		return 0;
		
	}
}
