/*2018-07-02 �����*/
package service;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
 
public class MemberDao {
	
	  
	public int deleteMember (int member_no) {
			//return data type int, deleteMember �޼ҵ� (int data type �Ű����� member_no ����)
			
			Connection conn = null;
			PreparedStatement pstmt = null;
	
		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         
	         pstmt = conn.prepareStatement("DELETE FORM member WHERE member_no=?");
	         pstmt.setInt(1, member_no);
	         
	         pstmt.executeUpdate();
	         
		}catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		}catch (SQLException e) {
			// TODO Auto-generated catch block
    		 e.printStackTrace();
		}finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
		return member_no;
		//member_no�� ����ִ� �ּ� ���� ����
		
	}
	public void updateMember(Member m) {
			//���� ���� updateMember �޼ҵ�  (Member data type���� �Ű����� m����)
			Connection conn = null;
			PreparedStatement pstmt = null;
			
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         //����̹� �ε�
	         pstmt = conn.prepareStatement("UPDATE member SET member_name=?, member_age=? WHERE member_no=?");
	         pstmt.setString(1, m.getMember_name());
	         pstmt.setInt(2, m.getMember_age());
	         pstmt.setInt(3, m.getMember_no());
	         
	         pstmt.executeUpdate();
	         
		}catch (ClassNotFoundException e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
		}catch (SQLException e) {
    	// TODO Auto-generated catch block
     		 e.printStackTrace();
		}finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
	}
	
	public Member mSelectUpdate(int member_no) {
			//return data type Member, mSelectUpdate �޼ҵ� (int data type���� �Ű����� member_no ����)
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			Member m = new Member();	//Member data type���� m���� �����ϰ�  new������ �޼ҵ��  ������ Member��ü�� �ּ� ���� m������ �Ҵ��Ѵ�

		
		try {
	         Class.forName("com.mysql.jdbc.Driver");
	            
	         String dbDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr";
	         String dbUser = "root";
	         String dbPass = "java0000";
	         conn = DriverManager.getConnection(dbDriver, dbUser, dbPass);
	         
	         pstmt = conn.prepareStatement("SELECT member_no, member_name, member_age FROM member WHERE member_no=?");
	         pstmt.setInt(1, member_no);
	         
	         rs = pstmt.executeQuery();
	         
	         if(rs.next()) {
	        	 m.setMember_no(rs.getInt("member_no"));
	        	 m.setMember_name(rs.getString("member_name"));
	        	 m.setMember_age(rs.getInt("member_age"));
	         }
	         
		} catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
    		 e.printStackTrace();
    		 
		}finally {
			
			// ��ü ����(�ݴ� ���� �߿�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
			return m;
			//m�� ����ִ� �ּ� ���� ����
		}
			
		
	
	
    public int selectCount() {
	        	//return data type int, selectCount �޼ҵ�
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
	            
	            pstmt = conn.prepareStatement("SELECT COUNT(*) FROM member");
	            
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
  
            } finally {
			
	        	// ��ü ����(�ݴ� ���� �߿�)
				if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
				if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
				if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
				
			}
	            return totalRow;    
	            //totalRow�� ����ִ� �ּ� ���� ����
	    }   
        
 
    public ArrayList<Member> selectMemberByPage(int page, int pagePerRow, String searchWord){
	    	//return date type ArrayList<Member>, selectMemberBypage �޼ҵ� (int data type page �Ű�����,pagePerRow�Ű����� / String data type searchWord �Ű����� ����)
	    	// �л�����Ʈ ���ϴ� �޼ҵ�
	        // word :
	    	// "" ->����
	    	// "�˻��ܾ�" -> ����
	    	// �б⹮ �ʿ�
	    	// �䱸���� -> ��������
	        ArrayList<Member> list = new ArrayList<Member>();	//ArrayList<Member> data type���� list���� �����ϰ� new������ �޼ҵ�� ������   ArrayList<Member>��ü�� �ּ� ���� list������ �Ҵ��Ѵ�
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
			//searchWord�� ��ġ�ϸ� �ؿ� ����
			sql = "SELECT member_no, member_name, member_age FROM member ORDER BY member_no LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, page);
			pstmt.setInt(2, pagePerRow);
		}else {
			//searchWord�� ��ġ���� ������
			sql = "SELECT member_no, member_name, member_age FROM member WHERE member_name LIKE ? ORDER BY member_no LIMIT ?,?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+searchWord+"%"); //like '%�ܾ�%'
			pstmt.setInt(2, page);
			pstmt.setInt(3, pagePerRow);
		}
			           
   
			rs = pstmt.executeQuery();
			            
		while(rs.next()) {    // ��ȸ�Ͽ� ���� ��µɶ����� �ݺ�
		                
			Member m  = new Member();
			//Member data type���� m���� �����ϰ� new������ �޼ҵ�� ������  Member��ü�� �ּ� ���� m������ �Ҵ��Ѵ�
			m.setMember_no(rs.getInt("member_no"));
			m.setMember_name(rs.getString("member_name"));
			m.setMember_age(rs.getInt("member_age"));
			                
			list.add(m);
			//list �� ����ִ� �ּҰ��� ���󰡼� add�޼��带 ȣ���Ͽ� �Ű��������� m�� ����ִ� �ּҰ��� �����Ѵ�

		}
			            
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
					
		// ��ü ����(�ݴ� ���� �߿�)
			if(rs!=null) try{ rs.close(); } catch (SQLException e) {}
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
		
		}
			return list;
		//list�� ����ִ� �ּ� ���� ����
		}
		            
        
 
    public int insertMember(Member m) {
        // return data type�� int, insertMember �޼ҵ� (�Ű����� m�� ������ Ÿ���� Member)
	        Connection conn = null;
	        PreparedStatement pstmt = null;
        // try=���ܰ� �߻��� �ڵ�
        // catch=���ܰ� �߻��� ����� �ڵ�
        try {
            Class.forName("com.mysql.jdbc.Driver");        //����̹� �ε�
            
            // DB����(ip�ּ�, port��ȣ , DB�� , ID, PW)
            String jdbcDriver = "jdbc:mysql://localhost:3306/5mysqlcrud?useUnicode=true&characterEncoding=euckr"; //�����ͺ��̽� ��
            String dbUser = "root";        
            String dbPass = "java0000";        
            
            conn = DriverManager.getConnection(jdbcDriver, dbUser, dbPass);
            System.out.println(conn + "<--conn");
            
            // ������ �ۼ�
            pstmt = conn.prepareStatement("INSERT INTO member (member_name,member_age) VALUES (?,?)");
            pstmt.setString(1, m.getMember_name());
            pstmt.setInt(2, m.getMember_age());
            
            // ���� ����
            pstmt.executeUpdate();
   
    	} catch (ClassNotFoundException e) {

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
			
        	// ��ü ����(�ݴ� ���� �߿�)
			if(pstmt!=null) try{ pstmt.close(); } catch (SQLException e) {}	// ������������
			if(conn!=null) try{ conn.close(); } catch (SQLException e) {}	// DB��������
			
		}
        return 0;
       
    }
 
}