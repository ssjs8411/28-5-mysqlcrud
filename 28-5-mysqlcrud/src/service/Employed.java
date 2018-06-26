// 18.6.26 최지수
package service;											// service 패키지 내에 있다

public class Employed {										// Employed 클래스
	
	private int employed_no;								// 접근지정자 private 같은클래스 내에서만 사용가능, int data type으로 employed_no변수 선언
	private String employed_name;							// String data type으로 employed_name 변수선언
	private int employed_age;								// int data type으로 employed_age 변수 선언
	
	public int getEmployed_no() {							// 변수에 입력된 값을 불러오는 메서드
		return employed_no;									// employed_no 변수에 담겨있는 값이 리턴된다
	}
	public void setEmployed_no(int employed_no) {			// 선언된 변수에 값을 입력하는 메서드
		this.employed_no = employed_no;						// 전역변수와 지역변수(매개변수)명이 같아서 전역변수는 this로 구분한다
	}														// 매개변수에 담겨있는 값을 전역변수에 담는다
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
