// 18.6.26 ������
package service;												// service ��Ű�� ���� �ִ�

public class EmployedAddr {										// EmployedAddr Ŭ����

	private int employed_addr_no;								// ���������� private ����Ŭ���� �������� ��밡��, int data type���� employed_addr_no���� ����
	private int employed_no;									// int data type���� employed_no ���� ����
	private String employed_addr_content;						// String data type���� // String data type���� employed_addr_content �������� ��������
	
	public int getEmployed_addr_no() {							// ������ �Էµ� ���� �ҷ����� �޼���
		return employed_addr_no;								// employed_addr_no ������ ����ִ� ���� ���ϵȴ�
	}
	public void setEmployed_addr_no(int employed_addr_no) {		// ����� ������ ���� �Է��ϴ� �޼���
		this.employed_addr_no = employed_addr_no;				// ���������� ��������(�Ű�����)���� ���Ƽ� ���������� this�� �����Ѵ�
	}															// �Ű������� ����ִ� ���� ���������� ��´�
	public int getEmployed_no() {
		return employed_no;
	}
	public void setEmployed_no(int employed_no) {
		this.employed_no = employed_no;
	}
	public String getEmployed_addr_content() {
		return employed_addr_content;
	}
	public void setEmployed_addr_content(String employed_addr_content) {
		this.employed_addr_content = employed_addr_content;
	}
}
