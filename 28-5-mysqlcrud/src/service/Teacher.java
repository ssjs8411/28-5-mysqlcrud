// 이경선
package service; 	//package service

public class Teacher {					//Teacher 클래스
										//private : 내부에서 접근  public : 외부에서도 접근 
private int teacher_no;		
private String teacher_name;			//int 데이터 타입으로 전역변수 teacher_no 선언
private int teacher_age;				//String 데이터 타입으로 전역변수 teacher_name 선언
										//int 데이터 타입으로 전역변수 teacher_age 선언
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
