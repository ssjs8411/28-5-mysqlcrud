// 18.6.25 최지수
package service;														// service 패키지 내에 있다

public class StudentAddr {												// StudentAddr 클래스

	private int student_addr_no;										// 접근지정자 private 같은클래스 내에서만 사용가능, int data type으로 student_addr_no변수 선언
	private int student_no;												// int data type으로 student_no 변수 선언
	private String student_addr_content;								// String data type으로 // String data type으로 student_name 변수선언 변수선언
	
	public int getStudent_addr_no() {									// 변수에 입력된 값을 불러오는 메서드
		return student_addr_no;											// student_addr_no 변수에 담겨있는 값이 리턴된다
	}
	public void setStudent_addr_no(int student_addr_no) {				// 선언된 변수에 값을 입력하는 메서드
		this.student_addr_no = student_addr_no;							// 전역변수와 지역변수(매개변수)명이 같아서 전역변수는 this로 구분한다
	}																	// 매개변수에 담겨있는 값을 전역변수에 담는다
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
