// 18.6.26 ������
package service;											// service ��Ű�� ���� �ִ�

public class Employed {										// Employed Ŭ����
	
	private int employed_no;								// ���������� private ����Ŭ���� �������� ��밡��, int data type���� employed_no���� ����
	private String employed_name;							// String data type���� employed_name ��������
	private int employed_age;								// int data type���� employed_age ���� ����
	
	public int getEmployed_no() {							// ������ �Էµ� ���� �ҷ����� �޼���
		return employed_no;									// employed_no ������ ����ִ� ���� ���ϵȴ�
	}
	public void setEmployed_no(int employed_no) {			// ����� ������ ���� �Է��ϴ� �޼���
		this.employed_no = employed_no;						// ���������� ��������(�Ű�����)���� ���Ƽ� ���������� this�� �����Ѵ�
	}														// �Ű������� ����ִ� ���� ���������� ��´�
	public String getEmployed_name() {
		return employed_name;
	}
	public void setEmployed_name(String employed_name) {
		this.employed_name = employed_name;
	}
	public int getEmployed_age() {
		return employed_age;
	}
	public void setEmployed_age(int employed_age) {
		this.employed_age = employed_age;
	}
}
