// 18.6.25 ������
package service;														// service ��Ű�� ���� �ִ�

public class StudentAddr {												// StudentAddr Ŭ����

	private int student_addr_no;										// ���������� private ����Ŭ���� �������� ��밡��, int data type���� student_addr_no���� ����
	private int student_no;												// int data type���� student_no ���� ����
	private String student_addr_content;								// String data type���� // String data type���� student_name �������� ��������
	
	public int getStudent_addr_no() {									// ������ �Էµ� ���� �ҷ����� �޼���
		return student_addr_no;											// student_addr_no ������ ����ִ� ���� ���ϵȴ�
	}
	public void setStudent_addr_no(int student_addr_no) {				// ����� ������ ���� �Է��ϴ� �޼���
		this.student_addr_no = student_addr_no;							// ���������� ��������(�Ű�����)���� ���Ƽ� ���������� this�� �����Ѵ�
	}																	// �Ű������� ����ִ� ���� ���������� ��´�
	public int getStudent_no() {
		return student_no;
	}
	public void setStudent_no(int student_no) {
		this.student_no = student_no;
	}
	public String getStudent_addr_content() {
		return student_addr_content;
	}
	public void setStudent_addr_content(String student_addr_content) {
		this.student_addr_content = student_addr_content;
	}
	
}
