//28�� �����
package service;								//package service

//public: �ܺ� ��𼭳� ���ٰ���
public class Member {							//Member class				
	
	//private: �ش� Ŭ���������� ���ٰ���
	private int member_no;						//���� ������ private int ������ Ÿ������ �������� member_no ����
	private String member_name;					//���� ������ private String ������ Ÿ������ �������� member_name ����
	private int member_age;						//���� ������ private int ������ Ÿ������ �������� member_age ����
	
	public int getMember_no() {					//���� �ִ� �޼ҵ� ���� ������ Ÿ���� int
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
	
	


	

