// 이경선
package service; 	//package service

public class Teachter {					//Teachter 클래스
										//private : 내부에서 접근  public : 외부에서도 접근 
private int teachter_no;		
private String teachter_name;			//int 데이터 타입으로 전역변수 teachter_no 선언
private int teachter_age;				//String 데이터 타입으로 전역변수 teachter_name 선언
										//int 데이터 타입으로 전역변수 teachter_age 선언
public int getTeachter_no() {
		return teachter_no;
	}
	public void setTeachter_no(int teachter_no) {
		this.teachter_no = teachter_no;
	}
	public String getTeachter_name() {
		return teachter_name;
	}
	public void setTeachter_name(String teachter_name) {
		this.teachter_name = teachter_name;
	}
	public int getTeachter_age() {
		return teachter_age;
	}
	public void setTeachter_age(int teachter_age) {
		this.teachter_age = teachter_age;
	}
	
}
