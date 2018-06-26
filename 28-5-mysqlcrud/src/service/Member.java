//28기 김소희
package service;								//package service

//public: 외부 어디서나 접근가능
public class Member {							//Member class				
	
	//private: 해당 클래스에서만 접근가능
	private int member_no;						//접근 지정자 private int 데이터 타입으로 전역변수 member_no 선언
	private String member_name;					//접근 지정자 private String 데이터 타입으로 전역변수 member_name 선언
	private int member_age;						//접근 지정자 private int 데이터 타입으로 전역변수 member_age 선언
	
	public int getMember_no() {					//리턴 있는 메소드 리턴 데이터 타입은 int
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public int getMember_age() {
		return member_age;
	}
	public void setMember_age(int member_age) {
		this.member_age = member_age;
	}
	
	
	} 
	
	


	

