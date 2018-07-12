package service;

public class StudentService {

	public void insertStudentMember(Student s) {
		
		new StudentDao().insertStudent(s);
	}
}
