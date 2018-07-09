package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TeacherScoreDao {
	


public ArrayList<TeacherAndScore> selectTeacherAndScored(){
	Connection conn = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList<TeacherAndScore> list = new ArrayList<TeacherAndScore>();
	
	try {
		Class.forName("com.mysql.jdbc.Driver");
		
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
		
		pstmt = conn.prepareStatement("SELECT teacher_score.teacher_score_no, teacher_score.score, teacher.teacher_no, teacher.teacher_name, teacher.teacher_age FROM teacher_score INNER JOIN teacher ON teacher_score.teacher_no = teacher.teacher_no");
		
		rs = pstmt.executeQuery();
	
	while(rs.next()) {
		Teacher t = new Teacher();
		TeacherScore ts = new TeacherScore();
		TeacherAndScore tas = new TeacherAndScore(); 
		
		t.setTeacher_no(rs.getInt("teacher_no"));
		t.setTeacher_name(rs.getString("teacher_name"));
		t.setTeacher_age(rs.getInt("teacher_age"));
		
		
		
		
	}
}
}