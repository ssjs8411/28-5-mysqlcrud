// �̰漱 
package service; 	// service ��Ű�� ���� �ִ�

import java.sql.Connection;		// Connection ������� import
import java.sql.DriverManager;	// DriverManager ������� import 
import java.sql.PreparedStatement;	// PreparedStatement ������� import
import java.sql.SQLException;	// �����˻� ���� import


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
}
		
		
	

	
