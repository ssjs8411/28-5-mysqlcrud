//28기 김소희
package service;

public class MemberAddr {
	
	private int member_addr_no;
	private int member_no;
	private String member_addr_content;
	//private: 해당 클래스에서만 접근가능
	
	public int getMember_addr_no() {
		return member_addr_no;
	}
	public void setMember_addr_no(int member_addr_no) {
		this.member_addr_no = member_addr_no;
	}
	public int getMember_no() {
		return member_no;
	}
	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}
	public String getMember_addr_content() {
		return member_addr_content;
	}
	public void setMember_addr_content(String member_addr_content) {
		this.member_addr_content = member_addr_content;
	}
	
	
	
}