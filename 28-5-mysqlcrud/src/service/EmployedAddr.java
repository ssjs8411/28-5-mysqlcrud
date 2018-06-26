// 18.6.26 최지수
package service;												// service 패키지 내에 있다

public class EmployedAddr {										// EmployedAddr 클래스

	private int employed_addr_no;								// 접근지정자 private 같은클래스 내에서만 사용가능, int data type으로 employed_addr_no변수 선언
	private int employed_no;									// int data type으로 employed_no 변수 선언
	private String employed_addr_content;						// String data type으로 // String data type으로 employed_addr_content 변수선언 변수선언
	
	public int getEmployed_addr_no() {							// 변수에 입력된 값을 불러오는 메서드
		return employed_addr_no;								// employed_addr_no 변수에 담겨있는 값이 리턴된다
	}
	public void setEmployed_addr_no(int employed_addr_no) {		// 선언된 변수에 값을 입력하는 메서드
		this.employed_addr_no = employed_addr_no;				// 전역변수와 지역변수(매개변수)명이 같아서 전역변수는 this로 구분한다
	}															// 매개변수에 담겨있는 값을 전역변수에 담는다
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
