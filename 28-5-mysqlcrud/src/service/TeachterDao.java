// �̰漱 
package service; 	// service ��Ű�� ���� �ִ�

import java.sql.Connection;		// Connection ������� import
import java.sql.DriverManager;	// DriverManager ������� import 
import java.sql.PreparedStatement;	// PreparedStatement ������� import
import java.sql.ResultSet;
import java.sql.SQLException;	// �����˻� ���� import
import java.util.ArrayList;

public class TeachterDao {		// TeachterDao Ŭ����
	
	public int InsertTeachter(Teachter t){	// ���������� public(�������� ���ٰ���) 
			
		// �Ѹ��� Student�� �Է��ϱ� ���� �޼���
				 // �Ű����� data type(Teachter),	�Ű�������: t
				 // return data type : int(����) -> ������ �����Ͽ� ������ �Ǹ� 1, ������ �ȵǸ� 0���� �������� ����
		
		Connection conn = null;			//db���� ���� �������ְ� ���ʱ�ȭ
		PreparedStatement pstmt = null;	// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
	
	
	try{						// ������ �߻��Ҽ��� ���� ������ �߻��ϸ� catch���� ó��
		//01�ܰ� :����̹� �ε� ��
		Class.forName("com.mysql.jdbc.Driver");
		
		//02�ܰ� :DB����(Connection)����

       //DB����(ip�ּ�, port��ȣ , DB�� , ID, PW
		String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		
		conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
		System.out.println(conn);
		
		// 3�ܰ�: ���� �����غ�(������ �ۼ�)
		pstmt = conn.prepareStatement("INSERT INTO teachter(teachter_name, teachter_age) VALUES (?,?);");
		System.out.println(pstmt);
		
		pstmt.setString(1, t.getTeachter_name());
		pstmt.setInt(2, t.getTeachter_age());	
		
		// 3�ܰ�: ���� ����
		pstmt.executeUpdate();
	
	
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	} catch (SQLException e) {
		
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		//06�ܰ� :statement �Ǵ� prepareStatement��ü ����(close())
		if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) {}
		//07�ܰ� :Connection ��ü ����(close())
		if (conn != null) try { conn.close(); } catch(SQLException ex) {}
	}
	return 0;
}
	public ArrayList<Teachter> selectMemberByPage(int currentPage, int PerPageRow){
		ArrayList<Teachter> list = new ArrayList<>();
		
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "SELECT teachter_no, teachter_name, teachter_age FROM teachter ORDER BY teachter_no ASC LIMIT ?,?";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");	
				
			connection= DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			statement.setInt(1, currentPage);
			statement.setInt(2, PerPageRow);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Teachter teachter = new Teachter();
				teachter.setTeachter_no(resultSet.getInt("teachter_no"));
				teachter.setTeachter_name(resultSet.getString("teachter_name"));
				teachter.setTeachter_age(resultSet.getInt("teachter_age"));
				list.add(teachter);
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			
			
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		
		return list;
	}
	public int count() {
		Connection connection = null;
		ResultSet resultSet = null;
		PreparedStatement statement = null;
		int rowNumber = 0;
		
		String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		String sql = "SELECT COUNT(*) FROM teachter";
		
		try {	
			Class.forName("com.mysql.jdbc.Driver");		
				
			connection= DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
			statement = connection.prepareStatement(sql);
			
			resultSet = statement.executeQuery();
			
			if(resultSet.next()) {
				rowNumber = resultSet.getInt("COUNT(*)");
			}
		
		} catch(Exception e) {
			e.printStackTrace();
		}finally{
			
			if (resultSet != null) try { resultSet.close(); } catch(SQLException ex) {}
			if (statement != null) try { statement.close(); } catch(SQLException ex) {}
			
			
			if (connection != null) try { connection.close(); } catch(SQLException ex) {}
		}
		return rowNumber;
	}
		}
		
		
	

	
