// 18.6.25 최지수

package service;										// service 패키지 내에 있다

public class Student {									// Student 클래스

	private int student_no;								// 접근지정자 private 같은클래스 내에서만 사용가능, int data type으로 student_no변수 선언
	private String student_name;						// String data type으로 student_name 변수선언
	private int student_age;							// int data type으로 student_age 변수 선언
	
	public int getStudent_no() {						// 변수에 입력된 값을 불러오는 메서드
		return student_no;								// student_no 변수에 담겨있는 값이 리턴된다
	}
	public void setStudent_no(int student_no) {			// 선언된 변수에 값을 입력하는 메서드
		this.student_no = student_no;					// 전역변수와 지역변수(매개변수)명이 같아서 전역변수는 this로 구분한다
	}													// 매개변수에 담겨있는 값을 전역변수에 담는다
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
