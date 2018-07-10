// 이경선
package service; 	//package service

public class Teacher {					//Teacher 클래스
										//private : 내부에서 접근  public : 외부에서도 접근 
private int Teacher_no;		
private String Teacher_name;			//int 데이터 타입으로 전역변수 teacher_no 선언
private int Teacher_age;				//String 데이터 타입으로 전역변수 teacher_name 선언
										//int 데이터 타입으로 전역변수 teacher_age 선언
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
