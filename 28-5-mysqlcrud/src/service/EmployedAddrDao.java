// 18.7.4 ������ 
package service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class EmployedAddrDao {
	
	
	public int deleteEmployedAddr(int employed_no) {
		// EmployedAddr ������ �ϱ� ���� �޼���
		// ���� int, ���� �������� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return check;
		
	}
	
	public void updateEmployedAddr(EmployedAddr eaddr) {
		// EmployedAddr ������Ʈ�� �ϱ� ���� �޼���
		// ���� Ÿ�� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
	}
	
	public EmployedAddr selectUpdateEmployedAddr(int employed_no) {
		// ����ȭ�鿡 ������ �ҷ����� ���� �޼���
		// EmployedAddr Ŭ������ �ּҰ� ����
		
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return eaddr;
		
	}
	
	
	public ArrayList<EmployedAddr> selectEmployedAddrList(int employed_no){
		// �޾ƿ� employed_no�� ���� ��ȸ�Ͽ� �Ѹ��� �ּ� ��ȸ�ϴ� �޼���
		// EmployedAddrŬ������ �ּ� ����(�迭) ->�������� ���� ������ ������ ��ȸ
		// employed_no�� ���� �޾Ƽ� ������ �ۼ�
		
		ArrayList<EmployedAddr> alea = new ArrayList<EmployedAddr>();
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		ResultSet rs = null;
		
		try {
			
			// 1�ܰ�: ����̹��ε�
				Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ�: DB����
				String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
				String dbUser = "root";
				String dbPass = "java0000";
				conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
				
			// 3�ܰ�: ���� �����غ�(������ �ۼ�)
				pstmt = conn.prepareStatement("SELECT employed_addr_no, employed_no, employed_addr_content FROM employed_addr WHERE employed_no=?");
				pstmt.setInt(1, employed_no);
			
			// 4�ܰ� : ���� ����
				rs = pstmt.executeQuery();
				
			// 5�ܰ� : ���� ������ ���
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		
		return alea;
		
	}
	
	public EmployedAddr selectEmployedAddr(int employed_no) {
		
		// �޾ƿ� employed_no�� ���� ��ȸ�Ͽ� �Ѹ��� �ּ� ��ȸ�ϴ� �޼���
		// EmployedAddr Ŭ������ �ּҰ��� ����
		Connection conn = null;				// DB ������ ���� ���� ���� �� �� �ʱ�ȭ
		PreparedStatement pstmt = null;		// ��ü ������ ���� ���� ���� �� �� �ʱ�ȭ
		ResultSet rs = null;
		EmployedAddr eaddr = new EmployedAddr();
		
		try {
			// 1�ܰ�: ����̹��ε�
			Class.forName("com.mysql.jdbc.Driver");
			
			// 2�ܰ�: DB����
			String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
			String dbUser = "root";
			String dbPass = "java0000";
			conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);	// ����̹� ����
			
			// 3�ܰ�: ���� �����غ�(������ �ۼ�)
			pstmt = conn.prepareStatement("SELECT employed_addr_no, employed_no, employed_addr_content FROM employed_addr WHERE employed_no=?");
			pstmt.setInt(1, employed_no);
			
			// 4�ܰ� : ���� ����
			rs = pstmt.executeQuery();
			
			// 5�ܰ� : ���� ������ ���
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
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		
		return eaddr;
		
	}

	public int insertEmployedAddr(EmployedAddr eaddr)  {			// ���������� public(�������� ���ٰ���) 
		
		 // �Ѹ��� Employed(Addr)�� �Է��ϱ� ���� �޼���
		 // �Ű����� data type(Employed),	�Ű�������: eaddr
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

			pstmt = conn.prepareStatement("INSERT INTO employed_addr (employed_no, employed_addr_content) VALUES (?, ?)");	// employedAddr ���̺� insert
			pstmt.setInt(1, eaddr.getEmployed_no());	// ù��° ?�� employedŬ���� ���� �ִ� getemployed_name�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			pstmt.setString(2, eaddr.getEmployed_addr_content());		// �ι�° ?�� employedŬ���� ���� �ִ� getemployed_age�޼��带 ȣ���Ͽ� �޼����� ���ϰ��� �Է�
			
			// 4�ܰ�: ��������
			pstmt.executeUpdate();			
		
		
		}  catch (SQLException e) {
			
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			
			// ��ü ����(������� �Ųٷ� ��������ش�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return 0;
		
	}

}
