// �̰漱
package service; 	//package service

public class Teacher {					//Teacher Ŭ����
										//private : ���ο��� ����  public : �ܺο����� ���� 
private int Teacher_no;		
private String Teacher_name;			//int ������ Ÿ������ �������� teacher_no ����
private int Teacher_age;				//String ������ Ÿ������ �������� teacher_name ����
										//int ������ Ÿ������ �������� teacher_age ����
public int getTeacher_no() {
	return Teacher_no;
}
public void setTeacher_no(int teacher_no) {
	Teacher_no = teacher_no;
}
public String getTeacher_name() {
	return Teacher_name;
}
public void setTeacher_name(String teacher_name) {
	Teacher_name = teacher_name;
}
public int getTeacher_age() {
	return Teacher_age;
}
public void setTeacher_age(int teacher_age) {
	Teacher_age = teacher_age;
}

}
