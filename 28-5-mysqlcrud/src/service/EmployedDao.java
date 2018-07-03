// 18.6.26 ������
package service;									// service ��Ű�� ���� �ִ�

import java.sql.Connection;							// Connection ������� import
import java.sql.DriverManager;						// DriverManager ������� import 
import java.sql.PreparedStatement;					// PreparedStatement ������� import 
import java.sql.ResultSet;
import java.sql.SQLException;						// �����˻� ���� import
import java.util.ArrayList;

public class EmployedDao {							// EmployedDao Ŭ����
	
	public int selectCountEmployed() {
			
			// ���̺� ���� ������ ������ ���ϱ� ���� �޼���
			// ���ڰ��� �����ϱ� ���� return data type �� int type
			
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
				
				// ��ü ����(������� �Ųٷ� ��������ش�)
				if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
				if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
				if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
				
			}
			
			
			return totalRow;
			
		}
	
	public ArrayList<Employed> selectEmployedByPage(int page, int pagePerRow){
		
		// ���̺� �� ��ü ���� ���ϱ� ���� �޼���
		// ArrayList type���� EmployedŬ������ �ּҰ� ����(�迭)
		// �������� ��� ���� ����� ����Ұ��� �Է����� �Ű����� 2�� ���� int type
		
		ArrayList<Employed> list = new ArrayList<Employed>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT employed_no, employed_name, employed_age FROM employed ORDER BY employed_no LIMIT ?,?";	// student���� student_noĮ�� ���� ������� ����� ��ȸ
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pagePerRow);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {	// ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�
				
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return list;	// list �ִ� pageperRow~1
		
	}

	public int insertEmployed(Employed emp)  {		// ���������� public(�������� ���ٰ���)
		
		// �Ѹ��� Employed�� �Է��ϱ� ���� �޼���
		// �Ű����� data type(Employed),	�Ű�������: emp
		// return data type : int(����) -> ������ �����Ͽ� ������ �Ǹ� 1, ������ �ȵǸ� 0���� �������� ����
		
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		
		try{		// ������ �߻��Ҽ��� ���� ������ �߻��ϸ� catch���� ó��
		
			
		// 1�ܰ�: ����̹��ε�
		Class.forName("com.mysql.jdbc.Driver");
		
		// 2�ܰ�: DB����
		String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
		String dbUser = "root";
		String dbPass = "java0000";
		conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
		
		// 3�ܰ�: ���� �����غ�(������ �ۼ�)
		pstmt = conn.prepareStatement("INSERT INTO employed(employed_name, employed_age) VALUES (?,?)");		// employed ���̺� insert
		pstmt.setString(1, emp.getEmployed_name());		// ù��° ?�� employedŬ���� ���� �ִ� getEmployed_name�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
		pstmt.setInt(2, emp.getEmployed_age());			// �ι�° ?�� employedŬ���� ���� �ִ� getEmployed_age�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
		
		// 4�ܰ�: ��������
		pstmt.executeUpdate();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}		// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}		// DB��������
		}
		return 0;
		
	}
}
