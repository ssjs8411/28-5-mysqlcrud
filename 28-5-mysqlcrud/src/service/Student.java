// 18.6.25 ������

package service;										// service ��Ű�� ���� �ִ�

public class Student {									// Student Ŭ����

	private int student_no;								// ���������� private ����Ŭ���� �������� ��밡��, int data type���� student_no���� ����
	private String student_name;						// String data type���� student_name ��������
	private int student_age;							// int data type���� student_age ���� ����
	
	public int getStudent_no() {						// ������ �Էµ� ���� �ҷ����� �޼���
		return student_no;								// student_no ������ ����ִ� ���� ���ϵȴ�
	}
	public void setStudent_no(int student_no) {			// ����� ������ ���� �Է��ϴ� �޼���
		this.student_no = student_no;					// ���������� ��������(�Ű�����)���� ���Ƽ� ���������� this�� �����Ѵ�
	}													// �Ű������� ����ִ� ���� ���������� ��´�
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public int getStudent_age() {
		return student_age;
	}
	public void setStudent_age(int student_age) {
		this.student_age = student_age;
	}
	
	

}
