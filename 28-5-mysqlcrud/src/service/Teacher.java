// �̰漱
package service; 	//package service

public class Teacher {					//Teacher Ŭ����
										//private : ���ο��� ����  public : �ܺο����� ���� 
private int teacher_no;		
private String teacher_name;			//int ������ Ÿ������ �������� teacher_no ����
private int teacher_age;				//String ������ Ÿ������ �������� teacher_name ����
										//int ������ Ÿ������ �������� teacher_age ����
public int getTeacher_no() {
		return teacher_no;
	}
	public void setTeacher_no(int teacher_no) {
		this.teacher_no = teacher_no;
	}
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}
	public int getTeacher_age() {
		return teacher_age;
	}
	public void setTeacher_age(int teacher_age) {
		this.teacher_age = teacher_age;
	}
	
}
